import Vue from 'vue'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import router from './router'
import VueRouter from 'vue-router';
import {Tag} from 'element-ui'
import VueContextMenu from 'vue-contextmenu'

// 全局引入elementui组件
Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.use(Tag)
Vue.config.productionTip = false

Vue.use(VueContextMenu)
new Vue({
  render: h => h(App),
  router
}).$mount('#app')


