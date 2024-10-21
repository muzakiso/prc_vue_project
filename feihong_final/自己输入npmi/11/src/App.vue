<template>
  <div id="app">
    <el-container>
      <el-header height="150px"><Header></Header></el-header>
      <el-container>
        <el-aside width="300px"><Aside></Aside></el-aside>
        <el-main><router-view></router-view></el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Header from './views/Header_content.vue';
import Aside from './views/Nav_menu.vue';

export default {
  name: 'App',
  data() {
    return {
      msg: '',
      num: 1
    }
  },
  methods: {
    handleChange(value) {
      console.log(value);
    }
  },
  // 注册组件，名字按规范自己取
  components: {
    // mytable,
    Aside,
    Header
  }
}
</script>
