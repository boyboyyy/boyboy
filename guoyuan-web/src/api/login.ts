/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-05-31 21:46:54
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-05-31 22:47:27
 * @FilePath: \guoyuan-web\src\api\login.ts
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import request from '@/unite/request'    
// import axios from 'axios'    
//模拟登录的接口    
export const loginByroot = (loginData: any) => {    
    console.log(loginData)    
    
    return request.post<any, any>('api/user/login', loginData)    
}    
