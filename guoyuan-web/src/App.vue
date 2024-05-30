<template>
  <router-view />
</template>
<script setup lang='ts'>
import { provide } from 'vue'
import echarts from '@/unite/echarts'
provide('echarts', echarts)
</script>
<style lang="less"></style>
