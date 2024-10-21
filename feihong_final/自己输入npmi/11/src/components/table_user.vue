<template>
    <div id="app">
        <el-row :gutter="20" class="search">
            <el-col span="4">
                <el-input placeholder="请输入姓名" prefix-icon="el-icon-search" v-model="input">
                </el-input>
            </el-col>
            <el-col span="6">
                <el-button type="primary" icon="el-icon-search" @click="query()">查询</el-button>
                <el-button type="primary" icon="el-icon-refresh" @click="refresh()">刷新</el-button>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-table :data="tableData" border height="850px" style="width: 100%" :row-class-name="tableRowClassName">

                    <el-table-column prop="account" label="账户" width="100">
                    </el-table-column>
                    <el-table-column prop="password" label="密码" width="100">
                    </el-table-column>
                    <el-table-column prop="name" label="姓名" width="180">
                    </el-table-column>
                    <el-table-column prop="sex" label="性别" width="180">
                    </el-table-column>
                    <el-table-column prop="phone" label="手机号" width="250">
                    </el-table-column>
                    <el-table-column prop="mailbox" label="邮箱" width="250">
                    </el-table-column>

                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button type="primary" size="mini" icon="el-icon-edit"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                            <!-- 编辑对话框 -->
                            <el-dialog title="录入信息" :visible.sync="editdialogVisible">
                                <span>
                                    <el-form ref="form" :model="form">
                                        <el-form-item label="账号" :label-width="formLabelWidth">
                                            <el-input :disabled="true" v-model="editform.id"
                                                autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="密码" :label-width="formLabelWidth">
                                            <el-input v-model="editform.age" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="姓名" :label-width="formLabelWidth">
                                            <el-input v-model="editform.name" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="性别" :label-width="formLabelWidth">
                                            <el-select v-model="editform.sex" placeholder="请选择性别">
                                                <el-option label="男" value="男"></el-option>
                                                <el-option label="女" value="女"></el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form-item label="手机号" :label-width="formLabelWidth">
                                            <el-input v-model="editform.phone" type="tel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="邮箱" :label-width="formLabelWidth">
                                            <el-input v-model="editform.major" autocomplete="off"></el-input>
                                        </el-form-item>
                                    </el-form>
                                </span>
                                <div slot="footer" class="dialog-footer">
                                    <el-button type="primary" @click="edit()">提交</el-button>
                                    <el-button @click="editdialogVisible = false, getdata()">取 消</el-button>
                                </div>
                            </el-dialog>
                        </template>
                    </el-table-column>
                </el-table>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            tableData: [],
            input: '',
            editdialogVisible: false,
            editform: {
                account: '',
                password: '',
                name: '',
                sex: '',
                phone: '',
                mailbox: ''
            },
            formLabelWidth: '120px',
            currentPage: 1,
            pageSize: 5,
            total: 0
        }

    },
    methods: {
        //刷新按钮的方法
        refresh() {
            this.getdata();
            this.refreshsucess();
        },
        //刷新成功的弹窗
        refreshsucess() {
            this.$message({
                message: '刷新成功',
                type: 'success'
            });
        },
        //从数据库获取数据
        getdata() {
            axios.get('http://localhost:8080/studentdata/selectPage',
            {
                params: { currentPage: this.currentPage, pageSize: this.pageSize }
            }
            ).then(res => {
                console.log(res.data);
                this.tableData = res.data;
            })
        },
        //点击编辑显示带数据的表单弹窗
        handleEdit(index, row) {
            console.log(index, row);
            this.editdialogVisible = true;
            this.editform = row;
        },
        //显示添加弹窗
        showaddform() {
            this.adddialogVisible = true;
        },
        //分页方法
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.pageSize = val;
            this.getdata();
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.currentPage = val;
            this.getdata();
        },
        //查询按钮的方法
        query() {
            axios.get('http://localhost:8080/studentdata/select', {
                //传递参数
                params: {
                    name: this.input
                }
            }).then(res => {
                this.tableData = res.data;
                this.queryfinishi();
            })
        },
        //查询成功的弹窗
        queryfinishi() {
            this.$message({
                message: '已显示信息',
                type: 'success'
            });
        },
        //编辑按钮的方法
        edit() {
            axios.post('http://localhost:8080/studentdata/edit', this.editform)
                .then(response => {
                    console.log(response);
                })
                .catch(error => {
                    console.log(error);
                });
            this.editdialogVisible = false;
            this.editsucess();
        },
        //编辑成功的弹窗
        editsucess() {
            this.$message({
                message: '修改成功',
                type: 'success'
            });
        }
    },
    mounted() {
        this.getdata();
    }
}

</script>

<style>
.search {
    margin-bottom: 20px;
}

.pagination {
    margin-top: 20px;
}
</style>
