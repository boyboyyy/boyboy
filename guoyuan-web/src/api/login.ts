import request from '@/unite/request'
import axios from 'axios'
//模拟登录的接口
export const loginByroot = (loginData: any) => {
    return axios.post<any, any>('api/login/news', loginData)
}
