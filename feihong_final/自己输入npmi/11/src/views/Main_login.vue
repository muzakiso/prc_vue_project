<template>
    <div id="background">
        <!-- <div id="logo">
            <img src="..\src\assets\logo.png" alt="error" width="300px" height="150px" />
        </div> -->
        <div id="login">
            <el-card class="box-card">
                <div id="form">
                    <el-form :model="formModel" :rules="rules" ref="form" autocomplete="off" label-width="50px">
                        <el-form-item>
                            <h1 style="margin: 0 auto">飞鸿管理系统</h1>
                        </el-form-item>
                        <el-form-item prop="account" label-width="50px">
                            <el-input v-model="formModel.account" autocomplete="off" @keyup.enter.native="onSubmit"
                                placeholder="请输入用户名"></el-input>
                        </el-form-item>
                        <el-form-item prop="password">
                            <el-input v-model="formModel.password" type="password" autocomplete="off"
                                @keyup.enter.native="onSubmit" placeholder="请输入密码"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">提交</el-button>
                            <el-tooltip class="item" effect="light" content="清空所有" transition="el-fade-in-linear" placement="bottom-end">
                                <el-button @click="reset">重置</el-button>
                            </el-tooltip>
                        </el-form-item>
                    </el-form>
                </div>
            </el-card>
        </div>

        <div id="clock">
            <div id="time">{{ time }}</div>
            <div id="date">{{ date }}</div>
        </div>

        <div id="copyright">
            Copyright © 2024-2025 CTGU Feihong. All rights reserved.
        </div>

    </div>
</template>

<style scoped>
#background {

    position: fixed;
    height: 100%;
    width: 100%;
    top: 0;
    left: 0;
    background-image: linear-gradient(90deg,
            cyan,
            purple);
    background-size: 400%;
    animation: myanimation 10s infinite;
}

#logo {
    color: aliceblue;
    font-size: 50px;
    font-weight: 1000;
    text-transform: uppercase;
    position: absolute;
    top: 15%;
    left: 15%;
    opacity: 0.75;
}

#login {
    position: absolute;
    top: 30%;
    left: 38%;
}

.el-card {
    width: 400px;
    /* 调整卡片宽度 */
    height: 280px;
    margin: 0 auto;
    /* 水平居中 */
    background-color: rgba(255, 255, 255, 0.4);
    /* 修正背景颜色透明度 */
    border-radius: 15px;
}

#form {
    line-height: 60px;
    padding-left: 15px;
    padding-right: 15px;
}

#clock {
    color: aliceblue;
    position: absolute;
    top: 70%;
    left: 10%;
    text-align: left;
}

#time {
    font-size: 100px
}

#date {
    font-size: 35px;
}

#copyright {
    color: aliceblue;
    position: absolute;
    top: 95%;
    left: 38%;
}

#form {
    position: absolute;
    left: 5%;
}

/* 标题居中样式 */
.el-form-item:first-child {
    text-align: center;
    /* 使标题居中 */
}

.el-form-item:first-child h1 {
    font-size: 1.8em;
    /* 增加字体大小，可根据需要调整 */
    margin-bottom: 20px;
    /* 增加标题与表单之间的间距 */
}

/* 按钮对齐和样式 */
.el-form-item:last-child {
    text-align: center;
    /* 使按钮居中 */
}

.el-button {
    width: 100px;
    /* 设置按钮宽度 */
    margin: 0 10px;
    /* 设置按钮之间的间距 */
}

@keyframes myanimation {
    0% {
        background-position: 0% 50%;
    }

    50% {
        background-position: 100% 50%;
    }

    100% {
        background-position: 0% 50%;
    }
}
</style>



<script>
import axios from 'axios';
import { Message } from "element-ui";
import { ElInput } from "element-ui";


export default {
    comments: {
        ElInput,
    },
    data() {
        return {
            formModel: {
                account: '',
                password: '',
            },
            time: '',
            date: '',
            rules: {
                account: [
                    { required: true, message: "请输入用户名", trigger: "blur" },
                    {
                        min: 3,
                        max: 10,
                        message: "用户名必须是 5-10位的字符",
                        trigger: "blur",
                    },
                ],
                password: [
                    { required: true, message: "请输入密码", trigger: "blur" },
                    {
                        min: 6,
                        max: 15,
                        message: "密码必须是 6-15位的非空字符",
                        trigger: "blur",
                    },
                ],
            },
        }
    },
    mounted() {
        this.$nextTick(() => {
            setInterval(this.update_clock, 1000);
        })
    },
    methods: {
        update_clock: function () {
            var d = new Date();
            var year = d.getFullYear();
            if (year < 10) {
                year = "0" + year;
            }
            var month = d.getMonth() + 1;
            if (month < 10) {
                month = "0" + month;
            }
            var day = d.getDate();
            if (day < 10) {
                day = "0" + day;
            }
            var hour = d.getHours();
            if (hour < 10) {
                hour = "0" + hour;
            }
            var minute = d.getMinutes();
            if (minute < 10) {
                minute = "0" + minute;
            }
            this.time = hour + ":" + minute;
            this.date = year + "/" + month + "/" + day;
        },
        reset() {
            this.formModel.account = "";
            this.formModel.password = "";
        },
        onSubmit() {
    this.$refs.form.validate(async (valid) => {
        if (valid) {
            try {
                const res = await axios.post(
                    "http://localhost:8080/administrator/login",
                    this.formModel
                );
                if (res.data.code === 0) {
                    // 修改这里，使用localStorage
                    localStorage.setItem('token', res.data.token);
                    Message.success("登录成功！");
                    this.reset();
                    this.$router.push("/");
                } else {
                    Message.error(res.data.message);
                }
            } catch (error) {
                Message.error("登录失败，请稍后再试！");
            }
        }
    });
},

    },

}


</script>
