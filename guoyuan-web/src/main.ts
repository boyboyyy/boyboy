import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/moke/index'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import * as echarts from 'echarts';

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.config.globalProperties.$echarts = echarts;
app.use(store).use(router).use(ElementPlus).mount("#app");
