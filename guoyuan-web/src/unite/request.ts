

import axios from "axios";
// import VueCookie from 'vue-cookie';
import { getCookie } from '@/unite/cookie'
const http = axios.create({
    timeout: 1000 * 30,
    withCredentials: true,
    headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
})

/**
* 请求拦截
* @param {*} params 
* @param {*} openDefultParams 
* @returns 
*/
http.interceptors.request.use(config => {
    const token = getCookie("token");
    //设置请求头
    config.headers['Authorization'] = token;
    config.headers['accept'] = '*/*'

    return config;
})


/**
 * 响应拦截
 * @param response 响应数据
 */
http.interceptors.response.use(response => {
    console.log(response, "response")
    return response;
}, error => {
    // 检查错误是否为401
    if (error.response && error.response.status === 401) {
        //删除token
        // VueCookie.delete('token')
        // console.log(this.$cookie.get('token'));
    }
    return Promise.reject(error);
});



export default http