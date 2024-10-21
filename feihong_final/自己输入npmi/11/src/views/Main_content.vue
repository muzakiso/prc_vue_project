<template>
    <div class="container">
      <header class="header">
        <h2>Welcome Swan Goose!</h2>
      </header>
      <main class="content">
        <h3>
          &emsp;&emsp;此运输管理系统由飞鸿团队设计创作，本团队公司注重锐意革新，始终坚持创新网络安全防护理念（主动防御）、诚信、客户至上原则，提供最贴近用户需要的安全服务，
          研究和开发具有国际优秀水平的信息安全产品。公司正以坚实稳健的步伐，朝着规模化、产业化的方向发展。
          我们厚积而薄发，加强团队合作，培养和引进高端人才，以人为本，鼓励员工进行技术创新，最终建立专业化的团队。
          本公司热忱期望与各界同仁携手一道，共同为推动中国的信息安全建设不懈努力!以技术为服务的根基，以客户需求为服务的核心，用最专业的服务打造出让客户满意的产品。
        </h3>
        
        <el-row class="chart-titles-row">
          <el-col span="12">
            <div class="chart-title">运费行情</div>
            <div id="main1" style="height: 300px; width: 100%"></div>
          </el-col>
          <el-col span="10">
            <div class="chart-title">司机收入</div>
            <div id="main2" style="height: 300px; width: 100%"></div>
          </el-col>
        </el-row>
        <!-- 图片插入 -->
        <img src="https://pho.yuyy.cloudns.biz/file/03c100b4e9ab4b371671f.jpg" alt="图片1" class="image">
        <img src="https://pho.yuyy.cloudns.biz/file/1ae437bd73ff89ec18ae2.jpg" alt="图片2" class="image">
        <!-- 图表插入 -->
      </main>
    </div>
  </template>
    
    <style scoped>
  
  #main1, #main2 {
    width: 100%;
    height: 300px;
    margin-bottom: 20px;
  }
  
    .container {
      display: flex;
      flex-direction: column;
      align-items: center;
      max-width: 1200px;
      margin: 0 auto;
      padding: 20px;
      font-family: 'Arial', sans-serif;
    }
    
    .header {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border-radius: 5px;
      text-align: center;
      margin-bottom: 20px;
    }
    
    .content {
      text-align: justify;
      line-height: 1.6;
      color: #333;
    }
  
   /* 新增图片容器样式 */
  .image-container {
    display: flex;
    justify-content: center; /* 水平居中图片 */
    align-items: center; /* 垂直居中图片 */
    flex-wrap: wrap; /* 允许图片换行 */
    margin-bottom: 20px;
  }
  
  .image {
    max-width: 40%;
    height: auto;
    margin: 50px; /* 增加图片之间的间距 */
  }
  
  .chart-titles-row {
    display: flex;
    align-items: flex-end; /* 将标题对齐到flex容器的底部 */
  }
  
  .chart-title {
    font-size: 1.5em; /* 根据需要调整标题大小 */
    margin-bottom: 10px; /* 添加一些底部边距 */
  }
  
    
    h2 {
      font-size: 2.5em;
      margin: 0;
    }
    
    h3 {
      font-size: 1.2em;
      margin-bottom: 20px;
    }
    
    </style>
  
  
  <script>
  import axios from 'axios';
  import * as echarts from 'echarts';
  
  export default {
    data() {
      return {};
    },
    methods: {
      refresh() {
        this.getdata();
        this.refreshsuccess();
      },
      refreshsuccess() {
        this.$message({
          message: '刷新成功',
          type: 'success'
        });
      },
      getdata() {
        axios.get('http://localhost:8080/salary/getAll').then(res => {
          console.log(res.data);
        });
      },
      initCharts() {
        // 工资表
        var myChart1 = echarts.init(document.getElementById('main1'));
        axios.get('http://localhost:8080/orders/getAll').then(res => {
          myChart1.showLoading();
          myChart1.setOption({
            title: {
              text: ''
            },
            tooltip: {},
            xAxis: {
              data: res.data.map(item => item.ordersId)
            },
            yAxis: {},
            series: [{
              name: '运费行情',
              type: 'bar',
              data: res.data.map(item => item.amount)
            }]
          });
          setTimeout(() => {
            myChart1.hideLoading();
          }, 500);
        });
  
        // 司机工资表
        var myChart2 = echarts.init(document.getElementById('main2'));
        axios.get('http://localhost:8080/salary/getAll').then(res => {
          var option = {
            tooltip: {
              trigger: 'item'
            },
            legend: {
              top: '5%',
              left: 'center'
            },
            series: [{
              name: '司机工资',
              type: 'pie',
              radius: ['40%', '70%'],
              avoidLabelOverlap: false,
              label: {
                show: false,
                position: 'center'
              },
              emphasis: {
                label: {
                  show: true,
                  fontSize: 40,
                  fontWeight: 'bold'
                }
              },
              labelLine: {
                show: false
              },
              data: res.data.map(item => ({
                name: item.driverName,
                value: item.amount
              }))
            }]
          };
          myChart2.setOption(option);
        });
      }
    },
    mounted() {
      this.initCharts();
    }
  }
  </script>
    