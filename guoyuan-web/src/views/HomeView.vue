<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
        <el-scrollbar>
          <el-menu route="true" default-active="1">

            <el-sub-menu index="1">
              <template #title>
                <el-icon>
                  <List />
                </el-icon>果园种植信息
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-1" @click="toApply">水果种植信息</el-menu-item>
                <el-menu-item index="1-2" @click="toBanana">水果种植季节</el-menu-item>
              </el-menu-item-group>
            </el-sub-menu>

            <el-sub-menu index="2">
              <template #title>
                <el-icon>
                  <el-icon>
                    <Histogram />
                  </el-icon>
                </el-icon>销售统计
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1" @click="toFormData">销售数据分析</el-menu-item>
              </el-menu-item-group>
            </el-sub-menu>
          </el-menu>
        </el-scrollbar>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <div class="toolbar">
            <div class="flex flex-wrap gap-4">
              <el-card style="width: 100%" shadow="always">
                <el-dropdown>
                  <el-icon style="margin-right: 8px; margin-top: 1px">
                    <setting />
                  </el-icon>
                  <template #dropdown>
                    <el-dropdown-menu>
                      <el-dropdown-item>退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                  </template>
                </el-dropdown>
                <span>Tom</span>
              </el-card>
            </div>
          </div>
        </el-header>

        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script lang="ts" setup>
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'
import { onMounted } from "vue";
import { useRouter } from 'vue-router'

//路由跳转变量
const Router = useRouter();
//跳转去苹果园
const toApply = () => {
  Router.push('/home/apply')
}
//跳转去香蕉园
const toBanana = () => {
  Router.push('/home/banana')
}
//跳转去数据信息
const toFormData = () => {
  Router.push('/home/formdata')
}
//跳转去榴莲信息
const toLiu = () => {
  Router.push('/home/liu')
}
//跳转去草莓信息
const toStrawbery = () => {
  Router.push('/home/strawberry')
}
onMounted(() => {


})
</script>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}

.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}

.layout-container-demo .el-menu {
  border-right: none;
}

.layout-container-demo .el-main {
  padding: 0;
}

.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
</style>