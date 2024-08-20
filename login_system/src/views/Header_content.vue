<template>
  <div>
    <el-row>
      <el-col span="4">
        <img src="..\src\assets\feihong.png" alt="error" width="300px" height="150px" />
      </el-col>


<br>
      <el-col span="4">
        <!-- 面包屑 -->
        <el-breadcrumb size="1000px" separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
          <el-breadcrumb-item>活动详情</el-breadcrumb-item>
        </el-breadcrumb>
      </el-col>

<br>

      <!-- 头像 -->
      <el-row class="demo-avatar demo-basic">
        <el-col :span="2" offset="18">
          <div class="demo-basic--circle">
            <div class="block"><el-avatar :size="80" :src="circleUrl"></el-avatar></div>
          </div>
        </el-col>
      </el-row>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      sizeList: ["large", "medium", "small"]
    }
  }
}
</script>