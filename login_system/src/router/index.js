
import VueRouter from 'vue-router'

import { Message } from 'element-ui'

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Main_login.vue')
  },
  //主页路由
  {
    path: '/index',
    name: 'index',
    component: () => import('../views/Main_content.vue')
  },
  {
    path: '/',
    name: 'home',
    redirect: '/index'
  },
  //订单路由
  {
    path:'/order',
    name:'order',
    component:()=>import('../components/table_order.vue')
  },
  //运单路由
  {
    path:'/transport',
    name:'transport',
    component:()=>import('../components/table_transport.vue')
  },
  //货物路由
  {
    path:'/cargo',
    name:'cargo',
    component:()=>import('../components/table_cargo.vue')
  },
  //工资路由
  {
    path:'/salary',
    name:'salary',
    component:()=>import('../components/table_salary.vue')
  },
  //个人中心路由
  {
    path:'/user',
    name:'user',
    component:()=>import('../views/views_user.vue')
  },
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 路由拦截
router.beforeEach((to, from, next) => {
  if (to.path === '/login') return next()
  const tokenStr = window.sessionStorage.getItem('token')
  if (!tokenStr) {
    // 使用Element UI的Message组件来显示提示信息
    Message({
      message: '请登录',
      type: 'error',
      duration: 850,
      onClose: () => {
        next('/login')
      }
    })
  } else {
    next()
  }
})

export default router
