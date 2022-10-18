
import {createRouter, createWebHashHistory, RouteRecordRaw} from "vue-router";
//定义路由

// @ts-ignore

const router: Array<RouteRecordRaw> = [
    {
        path: '/',
        component: () => import("../views/Login.vue")
    },
    {
        path: '/home',
        component: () => import("../views/home.vue"),
        children: [
            {
                path: '/userList',
                component: () => import("../views/UserList.vue"),
            }
        ]
    },
    {
        path: '/toReg',
        component: () => import("../views/Register.vue")
    }
]
export default createRouter({
    history: createWebHashHistory(),
    routes: router
})