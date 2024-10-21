import VueRouter from 'vue-router'
import { Message } from 'element-ui'


const routes = [

  //登录路由
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Main_login.vue')
  },
  //主页路由
  {
    path: '/index',
    name: 'index',
    component: () => import('../views/Main_content.vue'),
    meta: {
      title1: '介绍',
      title2: '飞鸿'
      
    }
  },
  {
    path: '/',
    redirect: '/index'
  },
  //订单路由
  {
    path: '/index/orders',
    name: 'orders',
    component: () => import('../components/table_orders.vue'),
    meta: {
      title1: '订单管理',
      title2: '订单信息'
    }
  },
  //订单物流
  {
    path: '/index/map',
    name: 'order_map',
    component: () => import('../components/map.vue'),
    meta: {
      title1: '订单管理',
      title2: '订单物流'
    }
  },
  //运单路由
  {
    path: '/index/transport',
    name: 'transport',
    component: () => import('../components/table_transport.vue'),
    meta: {
      title1: '运单管理',
      title2: '运单信息'
    }
  },
  //货物路由
  {
    path: '/index/cargo',
    name: 'cargo',
    component: () => import('../components/table_cargo.vue'),
    meta: {
      title1: '货物管理',
      title2: '货物信息'
    }
  },
  //工资路由
  {
    path: '/index/salary',
    name: 'salary',
    component: () => import('../components/table_salary.vue'),
    meta: {
      title1: '工资管理',
      title2: '工资信息'
    }
  },

  //个人中心路由
  {
    path: '/index/user',
    name: 'user',
    component: () => import('../views/views_user.vue'),
    meta: {
      title1: '个人中心',
      title2: '个人信息'
    
    }
  },
  /* {
    path: '/',
    name: 'home',
    redirect: '/index'
  }, */
  //订单路由

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (to.path === '/login') return next()
  // 修改这里，使用localStorage
  const tokenStr = localStorage.getItem('token')
  if (!tokenStr) {
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

