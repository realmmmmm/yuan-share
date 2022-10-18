<template>
  <a-form
      :model="formState"
      name="basic"
      :label-col="{ span: 8 }"
      :wrapper-col="{ span: 16 }"
      autocomplete="off"
      @finish="onFinish"
      @finishFailed="onFinishFailed"
      class="login"
  >
    <a-form-item
        label="用户名"
        name="userName"
        :rules="[{ required: true, message: '输入你的用户名!' }]"
    >
      <a-input v-model:value="formState.userName" />
    </a-form-item>

    <a-form-item
        label="密&nbsp&nbsp&nbsp&nbsp码"
        name="password"
        :rules="[{ required: true, message: '输入你的密码!' }]"
    >
      <a-input-password v-model:value="formState.password" />
    </a-form-item>

    <a-form-item name="remember" :wrapper-col="{ offset: 8, span: 16 }">
      <a-checkbox v-model:checked="formState.remember">记住我</a-checkbox>
      <a-button type="link" :size="20" @click="toReg()">没有账号?去注册</a-button>
    </a-form-item>

    <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
      <a-button type="primary" html-type="submit">登录</a-button>
    </a-form-item>
  </a-form>
</template>
<script setup lang="ts">
import { reactive } from 'vue';
import router from '../router'
import {getMapping} from "../api/request";
import {message} from "ant-design-vue";

interface FormState {
  userName: string;
  password: string;
  remember: boolean;
}

    const formState = reactive<FormState>({
      userName: '',
      password: '',
      remember: true,
    });
    const onFinish = (values: any) => {
      console.log('Success:', values);
      getMapping('/sys/tUsers/login',values).then((res) =>{
        const {code} = res.data
        const msg = res.data.message
        if (code === 200){
          router.push({path: "/home"});
        }else {
          message.warn(msg)
        }
      })

    };

    const onFinishFailed = (errorInfo: any) => {
      console.log('Failed:', errorInfo);
    };

    const toReg = () => {
      router.push("/toReg");
    }

</script>
<style>
.login{
  position: absolute;
  top: 50%;
  left: 40%;
  transform: translate(-30%, -30%);
  width: 400px;
  height: 300px;
}
</style>
