<template>
    <div id="app">
        <el-row :gutter="20" class="search">
            <el-col span="4">
                <el-input placeholder="请输入账单编号" prefix-icon="el-icon-search" v-model="input">
                </el-input>
            </el-col>
            <el-col span="6">
                <el-button type="primary" icon="el-icon-search" @click="query()">查询</el-button>
                <el-button type="primary" icon="el-icon-plus" @click="showaddform()">添加</el-button>
                <el-button type="primary" icon="el-icon-refresh" @click="refresh()">刷新</el-button>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-table :data="tableData" border height="850px" style="width: 100%" :row-class-name="tableRowClassName">
                    <el-table-column prop="salary_id" label="账单编号" width="100">
                    </el-table-column>
                    <el-table-column prop="transport_id" label="运单编号" width="180">
                    </el-table-column>
                    <el-table-column prop="driver_name" label="司机姓名" width="180">
                    </el-table-column>
                    <el-table-column prop="driver_tel" label="司机电话" width="180">
                    </el-table-column>
                    <el-table-column prop="license_plate" label="车牌号码" width="200">
                    </el-table-column>
                    <el-table-column prop="amount" label="工资金额" width="250">
                    </el-table-column>
                    <el-table-column prop="notes" label="备注" width="300">
                    </el-table-column>


                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button type="primary" size="mini" icon="el-icon-edit"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                            <!-- 编辑对话框 -->
                            <el-dialog title="录入信息" :visible.sync="editdialogVisible">
                                <span>
                                    <el-form ref="form" :model="form">
                                    <el-form-item label="账单编号" :label-width="formLabelWidth">
                                        <el-input :disabled="true" v-model="editform.salary_id"
                                                autocomplete="off"></el-input>
                                        </el-form-item>
                                    <el-form-item label="运单编号" :label-width="formLabelWidth">
                                        <el-input :disabled="true" v-model="editform.transport_id"
                                                autocomplete="off"></el-input>
                                        </el-form-item>
                                    <el-form-item label="司机姓名" :label-width="formLabelWidth">
                                        <el-input v-model="editform.driver_name" autocomplete="off"></el-input>
                                        </el-form-item>
                                    <el-form-item label="司机电话" :label-width="formLabelWidth">
                                        <el-input v-model="editform.driver_tel" autocomplete="off"></el-input>
                                        </el-form-item>
                                    <el-form-item label="车牌号码" :label-width="formLabelWidth">
                                        <el-input v-model="editform.license_plate" autocomplete="off"></el-input>
                                        </el-form-item>
                                    <el-form-item label="工资金额" :label-width="formLabelWidth">
                                        <el-input v-model="editform.amount" autocomplete="off"></el-input>
                                        </el-form-item>
                                    <el-form-item label="备注" :label-width="formLabelWidth">
                                        <el-input v-model="editform.notes" autocomplete="off"></el-input>
                                        </el-form-item>  
                                    </el-form>
                                </span>
                                <div slot="footer" class="dialog-footer">
                                    <el-button type="primary" @click="edit()">提交</el-button>
                                    <el-button @click="editdialogVisible = false, getdata()">取 消</el-button>
                                </div>
                            </el-dialog>
                            <!-- 添加对话框 -->
                            <el-dialog title="添加信息" :visible.sync="adddialogVisible">
                                <span>
                                    <el-form ref="form" :model="addform">
                                        
                                            <el-form-item label="账单编号" :label-width="formLabelWidth">
                                                <el-input :disabled="true" v-model="addeditform.salary_id"
                                                        autocomplete="off"></el-input>
                                                </el-form-item>
                                            <el-form-item label="运单编号" :label-width="formLabelWidth">
                                                <el-input :disabled="true" v-model="addeditform.transport_id"
                                                        autocomplete="off"></el-input>
                                                </el-form-item>
                                            <el-form-item label="司机姓名" :label-width="formLabelWidth">
                                                <el-input v-model="addeditform.driver_name" autocomplete="off"></el-input>
                                                </el-form-item>
                                            <el-form-item label="司机电话" :label-width="formLabelWidth">
                                                <el-input v-model="addeditform.driver_tel" autocomplete="off"></el-input>
                                                </el-form-item>
                                            <el-form-item label="车牌号码" :label-width="formLabelWidth">
                                                <el-input v-model="addeditform.license_plate" autocomplete="off"></el-input>
                                                </el-form-item>
                                            <el-form-item label="工资金额" :label-width="formLabelWidth">
                                                <el-input v-model="addeditform.amount" autocomplete="off"></el-input>
                                                </el-form-item>
                                            <el-form-item label="备注" :label-width="formLabelWidth">
                                                <el-input v-model="addeditform.notes" autocomplete="off"></el-input>
                                                </el-form-item>  
                                    </el-form>
                                </span>
                                <div slot="footer" class="dialog-footer">
                                    <el-button type="primary"
                                        @click="adddialogVisible = false, handleadd()">提交</el-button>
                                    <el-button @click="adddialogVisible = false">取 消</el-button>
                                </div>
                            </el-dialog>

                            <el-popconfirm confirm-button-text='确定' cancel-button-text='取消' icon="el-icon-info"
                                icon-color="red" title="确定删除这一条信息吗？" @confirm="handledelete(scope.$index, scope.row)">
                                <el-button size="mini" type="danger" icon="el-icon-delete"
                                    slot="reference">删除</el-button>
                            </el-popconfirm>

                        </template>
                    </el-table-column>
                </el-table>
            </el-col>
        </el-row>
        <!-- 分页组件 -->
        <el-row :gutter="20" class="pagination">
            <el-col span="4" :offset="15">
                <div class="block">
                    <el-pagination
                    
                    background="true"
                    hide-on-single-page="true"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                        :current-page="currentPage"
                        :page-sizes="[5, 10, 15, 20]" :page-size="pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="total">
                    </el-pagination>
                </div>
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
            adddialogVisible: false,
            editform: {
                salary_id:"",
                transport_id:"",
                driver_name:"",
                driver_tel:"",
                license_plate:"",
                amount:"",
                notes:""
                
            },
            addform: {
                salary_id:"",
                transport_id:"",
                driver_name:"",
                driver_tel:"",
                license_plate:"",
                amount:"",
                notes:""
                

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
            axios.get('http://localhost:8080/salary/getByPage',
            {
                params: { currentPage: this.currentPage, pageSize: this.pageSize }
            }
            ).then(res => {
                console.log(res.data);
                this.tableData = res.data.records;
                this.total = res.data.total;
                this.currentPage = res.data.current;
                this.pageSize = res.data.size;
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
        //删除按钮的方法
        handledelete(index, row) {
            console.log(index, row);
            axios.get('http://localhost:8080/salary/delete', {
                params: { id: row.id }
            }
            ).then(res => {
                console.log(res.data);
                this.getdata();
                this.deletesucess();
            })

        },
        //删除成功的弹窗
        deletesucess() {
            this.$message({
                message: '删除成功',
                type: 'success'
            });
        },
        //添加按钮的方法
        handleadd() {
            axios.get('http://localhost:8080/salary/add', {
                params: {
                  salary_id:this.salary_id,
                  transport_id:this.transport_id,
                  driver_name:this.driver_name,
                  driver_tel:this.driver_tel,
                  license_plate:this.license_plate,
                  amount:this.amount,
                  notes:this.notes
                }
            }).then(res => {
                res.data = this.addform
                this.getdata();
                this.addsucess();
            })
        },
        //添加成功的弹窗
        addsucess() {
            this.$message({
                message: '添加成功',
                type: 'success'
            });
        },
        //查询按钮的方法
        query() {
            axios.get('http://localhost:8080//salary/getById', {
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
            axios.post('http://localhost:8080//salary/update', this.editform)
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
.block{
    font-size: medium;
}
</style>
