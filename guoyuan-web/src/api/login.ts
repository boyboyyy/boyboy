import request from '@/unite/request'
// import axios from 'axios'
//模拟登录的接口
export const loginByroot = (loginData: any) => {
    return request.post<any, any>('/user/login', loginData)
}
