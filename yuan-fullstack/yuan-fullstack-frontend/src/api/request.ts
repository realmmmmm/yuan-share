import axios from "axios";
import {message} from "ant-design-vue";

const request = axios.create({
    baseURL: import.meta.env['VITE_APP_BASE_API'],
    timeout:5000
})

//请求拦截器配置
request.interceptors.request.use(
    config => {
        // @ts-ignore
        config.headers['Authorization'] = 'bearer'
        console.log("config===>", config)
        return config
    },
    error => {
        return Promise.reject(error)
    }
)

//响应拦截器配置
request.interceptors.response.use(
    response => {
        if (response.status === 200){
            const {code} = response.data
            if (code === 403){
                message.error('认证失败，请重新登录')
            }else if (code === 400){
                message.error('认证失败')
            }
        }else if (response.status === 404){
            message.error('请求未找到')
        }else {
            return Promise.reject("网络请求错误")
        }
        return response
    },error => {
        const {code} =error
        if (code === 'REE_BAD_RESPONSE'){
            message.error("网络请求错误")
        }else {
            message.error("服务器异常")
        }
        return Promise.reject(error)
    }
)

// 1 GET请求封装
export const getMapping = (url: string, data: any) => {
    return request.get(url, {
        params: data
    })
}

//2 POST
export const postMapping = (url: string, data: any) =>{
    return request({
        method: 'post',
        url: url,
        data: data
    })
}

//2 PUT
export const putMapping = (url: string, data: any) =>{
    return request({
        method: 'put',
        url: url,
        data: data
    })
}

//2 delete
export const deleteMapping = (url: string, data: any) =>{
    return request({
        method: 'delete',
        url: url,
        data: data
    })
}

//2 POST
export const requestMapping = (method: string, url: string, data: any) =>{
    if (method == 'get' || method == 'GET'){
        return getMapping(url,data)
    }else {
        return request({
            method: method,
            url: url,
            data: data
        })
    }

}