import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import Antd from 'ant-design-vue'
import {createPinia} from "pinia"
import 'ant-design-vue/dist/antd.css'

//pinia实例
const pinia = createPinia()


createApp(App).use(router).use(pinia).use(Antd).mount('#app')
