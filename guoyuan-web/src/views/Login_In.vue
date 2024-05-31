<template>
  <div class="login">
    <div class="login-box">
      <div style="flex: 1;display: flex">
        <img src="../assets/R-C.jpg" style="width: 100%">
      </div>
      <div style="flex:1">
        <el-form :model="user">
          <div style="font-size: 20px; font-weight: bold; text-align: center;margin-bottom:18px">登录智慧果园后台系统</div>

          <el-form-item>
            <el-input v-model="user.username" placeholder="请输入账号"></el-input>
          </el-form-item>
          <el-form-item>
            <el-input show-password v-model="user.password" placeholder="请输入密码"></el-input>
          </el-form-item>

          <el-form-item>
            <el-button @click="login()" style="margin-top:16px;width: 100%">登录</el-button>
          </el-form-item>
          <div style="display: flex;">
            <div style="flex: 1">还没有账号？请<span @click="toRegister" style="color:#0f9876;cursor: pointer">注册</span></div>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'
import { setCookie } from '@/unite/cookie'
import { ElNotification } from 'element-plus'
import { loginByroot } from '@/api/login'
//路由跳转变量
const Router = useRouter();
const user = reactive({
  username: '',
  password: '',
})
//去主页面
const login = async () => {
  const result: any = await loginByroot(user)
  if (result.data.code == '0x200') {
    setCookie('token', { token: result.data.token }, 24)
    setCookie('user', result.data.data, 24)
    Router.push('/home')
    ElNotification({
      title: '登录成功',
      message: '欢迎来到智慧果园系统',
      type: 'success',
    })
  } else {
    if (result.data.code === 401) {
      ElNotification({
        title: '登录失败',
        message: '账号或密码错误',
        type: 'error',
      })
    }
  }
}

//去注册
const toRegister = () => {
  Router.push('/register')
  console.log('submit!')
}
</script>
<style scoped>
.login {
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #ffcc80
}

.login-box {
  display: flex;
  background-color: #fff;
  width: 50%;
  border-radius: 5px;
  overflow: hidden;
}

.el-form {
  margin: 85px 15px;

}

.s-canvas {
  display: flex;
  justify-content: center;
}

.validCode {
  flex: 1;
  display: flex;
  justify-content: center;
  margin-top: 1px;

}

.el-button--default {
  background-color: #46eac2 !important;
  border-color: #46eac2 !important;
}
</style>
