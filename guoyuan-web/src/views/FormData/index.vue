<template>
    <div>
        <section class="mainbox">
            <div id="column-left-top">
                <echart :options="option"></echart>
            </div>
            <div id="column-left-bottom">
                <echart :options="option1"></echart>
            </div>
            <div id="column-right-top">
                <echart :options="option2"></echart>
            </div>
            <div id="column-right-bottom">
                <echart :options="option3"></echart>
            </div>
        </section>
    </div>
</template>
<script lang="ts" setup>
// import echarts from '@/unite/echarts'
import { ref, reactive, onMounted, onBeforeUnmount, inject, onBeforeMount } from 'vue'
import echart from '@/components/echarts.vue';
import { getFruit, } from '@/api/Fruit'
import { getFruitSeason } from '@/api/season'
//水果的信息
let tableData: any;
//获取水果的面积
const fruit = async () => {
    const result: any = await getFruit()
    if (result.data.code === '0x200') {
        tableData = result.data.data
        let num = option1.series[0].data.map(function (elem) {
            return elem
        })
        let num2: any = tableData.map(function (elem: any) {
            return { value: elem.area, name: elem.name }
        })
        num = num2;
        option1.series[0].data = num
        // console.log(tableData);

        // 匹配产量的值
        let inputData: any = tableData.map(function (elem: any) {
            // return  type: 'category', data: [elem.production] 
            return elem.name
        })
        option2.xAxis.data = inputData
        // console.log(option2.xAxis);
        //匹配产量series值
        let inputSeries: any = tableData.map((item: any) => {
            return item.production
        })
        option2.series[0].data = inputSeries
        console.log(option2.series, 'inputSeries');
        console.log(option2.xAxis, 'inputxAxis');




    }
}
let num1 = ref()
//获取季度的信息
let seasonData: any;
const fruitSeason = async () => {
    const result: any = await getFruitSeason()
    if (result.data.code === '0x200') {
        seasonData = result.data.data
        //匹配legend中的name的数据
        num1.value = seasonData.map((item: any) => {
            return item.name
        })
        option.legend.data = num1.value;

        //匹配series中的数据
        let num2 = seasonData.map((item: any) => {
            return { name: item.name, type: 'line', data: [item.firstSeason, item.secondSeason, item.thirdSeason, item.forthSeason] }
        })
        option.series = num2
    }
}
onMounted(() => {
    fruit()
    fruitSeason()
})

//第一张图
const option = reactive({
    title: {
        text: '水果销售额'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: []
    },
    grid: {
        left: '2%',
        right: '6%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['第一季度', '第二季度', '第三季度', '第四季度']
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value}千克'
        }
    },
    series: [
        {
            // name: '草莓',
            // type: 'line',
            // data: [454, 656, 245, 653]
        }
    ]
});
//第二张图
const option1 = reactive({
    title: {
        text: '水果的种植面积',
        left: 'center'
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        orient: 'vertical',
        left: 'left'
    },
    series: [
        {
            name: '种植面积占比',
            type: 'pie',
            radius: '50%',
            data: [
                // { value: 200, name: '栗子' },
                // { value: 245, name: '香蕉' },
                // { value: 297, name: '水蜜桃' },
                // { value: 245, name: '草莓' },
            ],
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
});
//第三张图
const option2 = reactive({
    title: {
        text: '水果产值'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    grid: {
        left: '15%',

    },
    xAxis: {
        type: 'category',
        data: []
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value}千克'
        }
    },
    series: [
        {
            barWidth: '30%',
            data: [],
            type: 'bar'
        }
    ]
});
//第四张图
const option3 = {
    title: {
        text: '一周内的天气情况'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {},
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日']
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value} °C'
        }
    },
    series: [
        {
            name: '最高点',
            type: 'line',
            data: [10, 11, 13, 11, 12, 12, 9],
            markPoint: {
                data: [
                    { type: 'max', name: 'Max' },
                    { type: 'min', name: 'Min' }
                ]
            },
            markLine: {
                data: [{ type: 'average', name: 'Avg' }]
            }
        },
        {
            name: '最低点',
            type: 'line',
            data: [1, -2, 2, 5, 3, 2, 0],
            markPoint: {
                data: [{ name: '周最低', value: -2, xAxis: 1, yAxis: -1.5 }]
            },
            markLine: {
                data: [
                    { type: 'average', name: 'Avg' },
                    [
                        {
                            symbol: 'none',
                            x: '90%',
                            yAxis: 'max'
                        },
                        {
                            symbol: 'circle',
                            label: {
                                position: 'start',
                                formatter: 'Max'
                            },
                            type: 'max',
                            name: '最高点'
                        }
                    ]
                ]
            }
        }
    ]

};
onBeforeMount(() => {



})
onMounted(() => {
    fruit();

})




</script>
<style less>
.mainbox {
    background-color: rgb(244, 244, 230);
    width: 1265px;
    height: 600px;
    display: flex;
    align-items: center;
    justify-content: space-around;
    flex-wrap: wrap;

    #column-left-top {
        width: 40%;
        height: 40%;
        margin: 5px;
        /* background-color: yellow; */
    }

    #column-left-bottom {
        width: 40%;
        height: 40%;
        margin: 5px;
        /* background-color: red; */
    }

    #column-right-top {
        width: 40%;
        height: 40%;
        margin: 5px;
        /* background-color: green; */
    }

    #column-right-bottom {
        width: 40%;
        height: 40%;
        margin: 5px;
        /* background-color: blue; */
    }
}
</style>