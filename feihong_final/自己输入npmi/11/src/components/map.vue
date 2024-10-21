<template>
    <div id="container"></div>
  </template>
  
  <script>
  import AMapLoader from "@amap/amap-jsapi-loader";
  
  export default {
    name: "map-view",
    data() {
      return {
        map: null,
        truckDriving: null, // 存储TruckDriving实例
      };
    },
    mounted() {
      this.initAMap();
    },
    beforeDestroy() {
      if (this.map) {
        this.map.destroy();
      }
      if (this.truckDriving) {
        this.truckDriving.clear(); // 清除路线显示
      }
    },
    methods: {
      initAMap() {
        window._AMapSecurityConfig = {
          securityJsCode: "5d824cbe43e2fce5b1051686ed896cf5", // 请替换为您的安全密钥
        };
        AMapLoader.load({
          key: "b0e73493807b4d504d2616bc36d98499", // 请替换为您的API密钥
          version: "2.0",
          plugins: ["AMap.Scale", "AMap.TruckDriving"],
        })
          .then((AMap) => {
            this.map = new AMap.Map("container", {
              viewMode: "3D",
              zoom: 10, // 根据实际情况调整
              center: [111.316006, 30.722519], // 初始中心点
            });
  
            // 创建TruckDriving实例
            this.truckDriving = new AMap.TruckDriving({
              map: this.map,
              policy: AMap.TruckDrivingPolicy.LEAST_TIME, // 最短时间策略
              size: 4, // 车辆大小，根据实际情况选择
            });
  
            // 定义起点和终点
            const start = [111.316006, 30.722519]; // 起点坐标
            const end = [114.298572, 30.584355]; // 终点坐标
  
            // 执行路线搜索
            this.truckDriving.search(start, end, (status, result) => {
              if (status === "complete" && result.info === "OK") {
                // 搜索成功，绘制最短路线
                const path = result.routes[0].steps; // 获取最短路线
                if (path) {
                  // 绘制路线
                  this.map.add(
                    new AMap.Polyline({
                      path: path,
                      strokeColor: "#FF0000", // 红色线条
                      strokeWeight: 6,
                      strokeOpacity: 0.8,
                    })
                  );
                }
              } else {
                // 搜索失败，根据 result 进行错误处理
                console.error("路线搜索失败", result);
              }
            });
          })
          .catch((e) => {
            console.error("地图加载失败", e);
          });
      },
    },
  };
  </script>
  
  <style scoped>
  #container {
    width: 100%;
    height: 800px;
  }
  </style>
  