import axios from 'axios'
//处理 类型“AxiosResponse<any, any>”上不存在属性 的问题
declare module "axios" {
    interface AxiosResponse<T = any> {
        code: string
        data: T
        message: string
        // 这里追加你的参数
    }
    export function create(config?: AxiosRequestConfig): AxiosInstance;
}

const request = axios.create({
    baseURL: '',
    timeout: 20000,
})

request.interceptors.request.use(
    (config) => {
        return config

    }
)

request.interceptors.response.use(
    (response) => {
        console.log(response);

        if (response.status === 200) {
            return response.data
        } else {

            return Promise.reject(response.data)
        }
    },
    (error) => {
        return Promise.reject(error)
    }
)

export default request;