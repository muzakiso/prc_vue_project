<template>
  <div class="tag-group">
    <el-row>
      <el-col :span="4">
        <img src="..\src\assets\feihong.png" alt="error" width="300px" height="150px" />
      </el-col>
      <el-col :span="20">
        <el-row>
          <el-col :span="4">
            <!-- 面包屑 -->
            <el-breadcrumb class="bread" size="1000px" separator="/">
              <el-breadcrumb-item @click.native="goToIndex" style="cursor: pointer;">首页</el-breadcrumb-item>
              <el-breadcrumb-item v-for="route in $route.matched" :key="route.path">{{ route.meta.title1 }}</el-breadcrumb-item>
              <el-breadcrumb-item v-for="route in $route.matched" :key="route.path">{{ route.meta.title2 }}</el-breadcrumb-item>
            </el-breadcrumb>
          </el-col>
          <!-- 头像和注销按钮 -->
          <el-col :span="2" offset="18">
            <div class="demo-basic--circle">
              <div class="block"><el-avatar :size="80" :src="circleUrl"></el-avatar></div>
              <el-button type="danger" size="mini" @click="logout">注销</el-button>
            </div>
          </el-col>
          <!-- 标签 -->
          <el-col :span="10">
            <el-tag class="tag" v-for="route in $route.matched" :key="route.path" :closable="true" @click="handleMenu(item)" @close="handleClose(item, index)" size="medium">{{ route.meta.title2 }}</el-tag>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>


<script>
export default {
  data() {
    return {
      circleUrl: "https://tse1-mm.cn.bing.net/th/id/OIP-C.9gV-xAa0fnshmkFYZYaJ1gHaHU?rs=1&pid=ImgDetMain",
      sizeList: ["large", "medium", "small"],
      tags: [
        {
          name: 'index',
          path: '/',
          label: '首页'
        }, {
          name: 'orders',
          path: '/index/orders',
          label: '订单信息'
        }, {
          name: 'transport',
          path: '/index/transport',
          label: '运单信息'
        }, {
          name: 'cargo',
          path: '/index/cargo',
          label: '货物信息'
        }, {
          name: 'salary',
          path: '/index/salary',
          label: '工资信息'
        },{
          name: 'user',
          path: '/index/user',
          label: '个人中心'
        }
      ]
    }
  },
  methods: {
    handleMenu: function (tag) {
      console.dir(tag)
    },
    // tag的关闭是通过手动删除数据实现的
    handleClose(tag, index) {
      console.dir(tag)
      this.tags.splice(index, 1)
    },
    goToIndex() {
      if (this.$route.path !== '/index') {
        this.$router.push('/index');
      }
    },
    logout() {
  this.$confirm('确认注销吗?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    // 清除localStorage中的token
    localStorage.removeItem('token');
    // 显示提示框
    this.$message({
      type: 'success',
      message: '注销成功!'
    });
    // 设置延时跳转
    setTimeout(() => {
      this.$router.push('/login');
    }, 2000);
  }).catch(() => {
    // 如果用户点击了取消，不做任何操作
  });
}

  },

}
</script>


<style>
.tag {
  margin-top: 0px;
}

.bread {
  margin-top: 20px;
}

.demo-basic--circle {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.block {
  margin-bottom: 10px; /* 添加一些底部间距 */
}

</style>