/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-06-01 11:41:00
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-06-01 11:43:42
 * @FilePath: \guoyuan-web\src\api\Fruit.ts
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import request from '@/unite/request'
//获取苹果的信息接口
// export const getFruitApply = (token: String) => {
//     return request.post<any, any>(`/activity/selectByToken?token=${token}`)
// }

//模拟的接口
//获取苹果的信息接口
// import axios from 'axios'
export const getFruit = () => {
    return request.get<any, any>('api/fruit/selectAll')
}
//获取苹果修改的信息接口
export const fixFruit = (fixData: any) => {
    return request.post<any, any>('api/fruit/edit', fixData)
}
//获取删除苹果的删除接口
export const deleteFruit = (deleteId: any) => {
    return request.post<any, any>(`api/fruit/deleteById?id=${deleteId}`)
}


