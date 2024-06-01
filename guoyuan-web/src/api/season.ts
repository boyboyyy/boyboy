import request from '@/unite/request'
//获取水果的信息接口
// import axios from 'axios'
export const getFruitSeason = () => {
    return request.get<any, any>('api/session/selectAll')
}
//获取苹果修改的信息接口
export const fixFruitSeason = (fixData: any) => {
    return request.post<any, any>('api/session/edit', fixData)
}
//获取删除苹果的删除接口
export const deleteFruitSeason = (deleteId: any) => {
    return request.post<any, any>(`api/session/deleteById?id=${deleteId}`)
}


