import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
    server: {
      proxy: {
        // 选项写法
        '/api': {
          target: 'http://localhost:7001/yuan',
          changeOrigin: true,
          rewrite: (path) => path.replace(/^\/api/, '')
         }
       }
     }
})
