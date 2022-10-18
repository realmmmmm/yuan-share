<template>
  <a-layout style="min-height: 100vh">
    <a-layout-sider v-model:collapsed="collapsed" collapsible>
      <div class="logo" />
      <a-menu v-model:selectedKeys="selectedKeys" theme="dark" mode="inline">
        <a-sub-menu key="sub1">
          <template #title>
            <span>
              <user-outlined />
              <span>系统管理</span>
            </span>
          </template>
          <router-link to="/userList"><a-menu-item key="3">用户管理</a-menu-item></router-link>


        </a-sub-menu>

      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0" />
      <a-layout-content style="margin: 0 16px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>系统管理</a-breadcrumb-item>
          <a-breadcrumb-item>用户管理</a-breadcrumb-item>
        </a-breadcrumb>
<!--        <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">-->
<!--          Bill is a cat.-->
<!--        </div>-->
        <router-view></router-view>
      </a-layout-content>
      <a-layout-footer style="text-align: center">
        @mmm13123
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script setup lang="ts">

import { defineComponent, ref } from 'vue';

      const collapsed = ref<boolean>(false)
      const selectedKeys = ref<string[]>(['1'])

</script>
<style>
#components-layout-demo-side .logo {
  height: 32px;
  margin: 16px;
  background: rgba(255, 255, 255, 0.3);
}

.site-layout .site-layout-background {
  background: #fff;
}
[data-theme='dark'] .site-layout .site-layout-background {
  background: #141414;
}
</style>
