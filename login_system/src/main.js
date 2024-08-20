import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import router from './router'
import VueRouter from 'vue-router';
import axios from 'axios'

// 全局引入elementui组件
Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.config.productionTip = false

new Vue({
  router,
  axios,
  render: function (h) { return h(App) }
}).$mount('#app')
