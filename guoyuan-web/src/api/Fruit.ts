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


