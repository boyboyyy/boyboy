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
import { ref, reactive, onMounted, onBeforeUnmount } from 'vue'
import echart from '@/components/echarts.vue';
//第一张图
const option = {
    title: {
        text: '水果销售额'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['苹果', '香蕉', '草莓']
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
            name: '苹果',
            type: 'line',
            data: [120, 132, 101, 134]
        },
        {
            name: '香蕉',
            type: 'line',
            data: [300, 544, 444, 449]
        },
        {
            name: '草莓',
            type: 'line',
            data: [220, 182, 191, 234]
        },
    ]
};
//第二张图
const option1 = {
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
                { value: 1048, name: '榴莲' },
                { value: 735, name: '香蕉' },
                { value: 580, name: '草莓' },
                { value: 580, name: '苹果' },

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
};
//第三张图
const option2 = {
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
        data: ['苹果', '草莓', '榴莲', '香蕉']
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
            data: [120, 200, 150, 80, 70, 110, 130],
            type: 'bar'
        }
    ]
};
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
onMounted(() => {
    console.log(option.series, 'ssjk');
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