<template>
    <div>
        <el-row>
            <h4>个人头像</h4>
            <el-col offset="3" :span="2">
                <div class="demo-basic--circle">
                    <div class="block"><el-avatar :size="80" :src="circleUrl"></el-avatar></div>
                </div>
            </el-col>
            <el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/"
                    :show-file-list="false" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
        </el-row>

        <el-row>
            <el-col :span="10">
                <el-descriptions size="medium" border="true" title="个人信息">
                    <el-descriptions-item label="用户名">admin</el-descriptions-item>
                    <el-descriptions-item label="姓名">lc</el-descriptions-item>
                    <el-descriptions-item label="手机号">150348</el-descriptions-item>
                    <el-descriptions-item label="状态">
                        <el-tag size="small">在岗</el-tag>
                    </el-descriptions-item>
                    <el-descriptions-item label="邮箱地址">1254875.com</el-descriptions-item>
                </el-descriptions>
                <!-- 添加编辑按钮 -->
                <el-button type="primary" @click="showEditForm = true">编辑信息</el-button>
            </el-col>
            <el-col :span="14" v-if="showEditForm">
                <el-tabs type="border-card">
                    <el-tab-pane label="编辑个人资料">
                        <el-form :model="form" :label-position="labelPosition" label-width="80px" ref="form">
                            <el-form-item label="姓名">
                                <el-input v-model="form.name"></el-input>
                            </el-form-item>
                            <el-form-item label="手机号">
                                <el-input v-model="form.region"></el-input>
                            </el-form-item>
                            <el-form-item label="邮箱地址">
                                <el-input v-model="form.type"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('form')">提交</el-button>
                                <el-button @click="resetForm('form')">清空</el-button>
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                    <el-tab-pane label="修改密码">
                        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px"
                            class="demo-ruleForm">
                            <el-form-item label="密码" prop="pass">
                                <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="确认密码" prop="checkPass">
                                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                                <el-button @click="resetForm('ruleForm')">清空</el-button>
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                </el-tabs>
            </el-col>
        </el-row>
    </div>
</template>


<script>
// import axios from 'axios';
export default {
    data() {
        return {
            showEditForm: false,
            imageUrl: '',
            circleUrl: "https://tse1-mm.cn.bing.net/th/id/OIP-C.9gV-xAa0fnshmkFYZYaJ1gHaHU?rs=1&pid=ImgDetMain",
            sizeList: ["large", "medium", "small"],
            labelPosition: 'right',
            form: {
                name: '',
                region: '',
                type: ''
            },
            ruleForm: {
                pass: '',
                checkPass: '',
                age: ''
            },
            rules: {
                pass: [
                    { validator: this.validatePass, trigger: 'blur' }
                ],
                checkPass: [
                    { validator: this.validatePass2, trigger: 'blur' }
                ],
            }
        };
    },
    methods: {
        validatePass(rule, value, callback) {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                if (this.ruleForm.checkPass !== '') {
                    this.$refs.ruleForm.validateField('checkPass');
                }
                callback();
            }
        },
        validatePass2(rule, value, callback) {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.ruleForm.pass) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        },
        submitForm(formName) {
    if (this.$refs[formName]) {
        this.$refs[formName].validate((valid) => {
            if (valid) {
                this.$message({
                    message: '待审核!',
                    type: 'warning'
                });
                this.showEditForm = false; // 关闭编辑表单
            } else {
                console.log('提交失败!!');
                return false;
            }
        });
    }
},
resetForm(formName) {
    if (this.$refs[formName]) {
        this.$refs[formName].resetFields();
    }
},   
handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw);
        },
        beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
            }
            if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isJPG && isLt2M;
        }
    }
}
</script>


<style>
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}

.avatar-uploader .el-upload:hover {
    border-color: #409EFF;
}

.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 90px;
    height: 90px;
    line-height: 90px;
    text-align: center;
}

.avatar {
    width: 178px;
    height: 178px;
    display: block;
}
</style>
