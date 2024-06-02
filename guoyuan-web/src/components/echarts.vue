<template>
    <div class='echart' ref="chartDom"></div>
</template>

<script setup lang='ts' scoped>
import { inject, ref, onMounted, toRefs, watch } from 'vue'
const echarts: any = inject('echarts')
const chartDom: any = ref(null)
let myChart: any = null;
const props = defineProps({
    options: {
        type: Object,
        default: {},
        required: true
    },
})
// const resizeHandler = () => {
//     myChart.resize()
// }
onMounted(() => {
    myChart = echarts.init(chartDom.value)
    myChart.setOption(props.options, true)
    // console.log(props.options, 'mychart');
    // window.addEventListener('resize', resizeHandler)
})
watch(() => props.options, (newOptions) => {
    myChart.setOption(newOptions)
}, {
    deep: true
})
</script>

<style scoped>
.echart {
    width: 100%;
    height: 100%;
}
</style>
