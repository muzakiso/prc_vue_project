<template>
  <el-row class="tac">
    <el-col :span="12">
      <el-menu default-active="0" 
      class="el-menu-vertical-demo" 
      @open="handleOpen" 
      @close="handleClose" 
      router 
      unique-opened="true" 
      background-color="#ffffff" 
      text-color="#000000" 
      active-text-color="#4373dd">
        <el-menu-item index="/">
          <i class="el-icon-s-home"></i>
          <span slot="title">首页</span>
        </el-menu-item>


        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-document"></i>
            <span>订单管理</span>
          </template>
          <el-menu-item-group>
            <router-link to="/order">
              <el-menu-item index="1-1">订单信息</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>


        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-tickets"></i>
            <span>运单管理</span>
          </template>
          <el-menu-item-group>
            <router-link to="/transport">
              <el-menu-item index="2-1">运单信息</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-truck"></i>
            <span>货物管理</span>
          </template>
          <el-menu-item-group>
            <router-link to="/cargo">
              <el-menu-item index="3-1">货物信息</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="4">
          <template slot="title">
            <i class="el-icon-money"></i>
            <span>财务管理</span>
          </template>
          <el-menu-item-group>
            <router-link to="/salary">
              <el-menu-item index="4-1">司机工资</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>

        <el-menu-item index="/user">
          <i class="el-icon-user-solid"></i>
          <span slot="title">个人中心</span>
        </el-menu-item>

      </el-menu>
    </el-col>
  </el-row>
</template>

<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
.el-col {
  width: 100%;
}
</style>