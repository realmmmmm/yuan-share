<template>
  <a-form
      ref="formRef"
      name="custom-validation"
      :model="formState"
      :rules="rules"
      v-bind="layout"
      @finish="handleFinish"
      @validate="handleValidate"
      @finishFailed="handleFinishFailed"
      class="reReg"
  >
    <a-form-item
        label="用户名"
        name="userName"
        :rules="[{ required: true, message: '输入你的用户名!' }]"
    >
      <a-input v-model:value="formState.userName" />
    </a-form-item>

    <a-form-item
        label="姓名"
        name="name"
        :rules="[{ required: true, message: '输入你的姓名!' }]"
    >
      <a-input v-model:value="formState.name" />
    </a-form-item>

    <a-form-item has-feedback label="密码" name="pass">
      <a-input v-model:value="formState.pass" type="password" autocomplete="off" />
    </a-form-item>
    <a-form-item has-feedback label="确认密码" name="checkPass">
      <a-input v-model:value="formState.checkPass" type="password" autocomplete="off" />
    </a-form-item>
    <a-form-item has-feedback label="年龄" name="age">
      <a-input-number v-model:value="formState.age" />
    </a-form-item>
    <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
      <a-button type="primary" html-type="submit">注册</a-button>
      <a-button style="margin-left: 10px" @click="resetForm">重置</a-button>
      <a-button type="link" :size="20" @click="toLogin">已有账号?去登录</a-button>
    </a-form-item>
  </a-form>
</template>
<script setup lang="ts">
import type { Rule } from 'ant-design-vue/es/form';
import { defineComponent, reactive, ref } from 'vue';
import type { FormInstance } from 'ant-design-vue';
import router from "../router";
interface FormState {
  userName: string;
  name: string;
  pass: string;
  checkPass: string;
  age: number | undefined;
}

const formRef = ref<FormInstance>();
const formState = reactive<FormState>({
  pass: '',
  checkPass: '',
  age: undefined,
});
let checkAge = async (_rule: Rule, value: number) => {
  if (!value) {
    return Promise.reject('请输入年龄');
  }
  if (!Number.isInteger(value)) {
    return Promise.reject('请输入数字');
  } else {
    if (value < 18) {
      return Promise.reject('年龄必须大于18岁');
    } else {
      return Promise.resolve();
    }
  }
};
let validatePass = async (_rule: Rule, value: string) => {
  if (value === '') {
    return Promise.reject('请输入密码');
  } else {
    if (formState.checkPass !== '') {
      formRef.value.validateFields('checkPass');
    }
    return Promise.resolve();
  }
};
let validatePass2 = async (_rule: Rule, value: string) => {
  if (value === '') {
    return Promise.reject('请重新输入密码');
  } else if (value !== formState.pass) {
    return Promise.reject("两个输入不匹配！");
  } else {
    return Promise.resolve();
  }
};

const rules: Record<string, Rule[]> = {
  pass: [{ required: true, validator: validatePass, trigger: 'change' }],
  checkPass: [{ validator: validatePass2, trigger: 'change' }],
  age: [{ validator: checkAge, trigger: 'change' }],
};
const layout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 14 },
};
const handleFinish = (values: FormState) => {
  console.log(values, formState);
};
const handleFinishFailed = errors => {
  console.log(errors);
};
const resetForm = () => {
  formRef.value.resetFields();
};
const handleValidate = (...args) => {
  console.log(args);
};
const toLogin = () => {
  router.push({path: '/'})
};

</script>
<style>
.reReg{
  position: absolute;
  top: 50%;
  left: 45%;
  transform: translate(-30%, -30%);
  width: 600px;
  height: 400px;
}
</style>
