<template>
    <div id="app">
        <el-row :gutter="20" class="search">
            <el-col span="4">
                <el-input placeholder="订单编号" prefix-icon="el-icon-search" v-model="input">
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
                    <el-table-column prop="order_id" label="订单编号" width="100">
                    </el-table-column>
                    <el-table-column prop="status" label="订单状态" width="180">
                    </el-table-column>
                    <el-table-column prop="start_date" label="创建日期" width="180">
                    </el-table-column>
                    <el-table-column prop="end_date" label="结束日期" width="180">
                    </el-table-column>
                    <el-table-column prop="PartyA" label="甲方" width="200">
                    </el-table-column>
                    <el-table-column prop="Aaddress" label="甲方地址" width="250">
                    </el-table-column>
                    <el-table-column prop="Acontacter" label="甲方联系人" width="250">
                    </el-table-column>
                    <el-table-column prop="Acontacter_tel" label="甲方联系人电话" width="250">
                    </el-table-column>
                    <el-table-column prop="PartyB" label="乙方" width="250">
                    </el-table-column>
                    <el-table-column prop="Baddress" label="乙方地址" width="250">
                    </el-table-column>
                    <el-table-column prop="Bcontacter" label="乙方联系人" width="250">
                    </el-table-column>
                    <el-table-column prop="Bcontacter_tel" label="乙方联系人电话" width="250">
                    </el-table-column>
                    <el-table-column prop="head" label="负责人" width="250">
                    </el-table-column>
                    <el-table-column prop="head_tel" label="负责人电话" width="250">
                    </el-table-column>
                    <el-table-column prop="transport_id" label="运单编号" width="250">
                    </el-table-column>
                    <el-table-column prop="amount" label="结算金额" width="250">
                    </el-table-column>
                    <el-table-column prop="notes" label="备注" width="250">
                    </el-table-column>


                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button type="primary" size="mini" icon="el-icon-edit"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                            <!-- 编辑对话框 -->
                            <el-dialog title="录入信息" :visible.sync="editdialogVisible">
                                <span>
                                    <el-form ref="form" :model="form">
                                        <el-form-item label="订单编号" :label-width="formLabelWidth">
                                            <el-input :disabled="true" v-model="editform.order_id"
                                                autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="订单状态" :label-width="formLabelWidth">
                                            <el-select v-model="editform.status" placeholder="请选择状态">
                                                <el-option label="未开始" value="未开始"></el-option>
                                                <el-option label="进行中" value="进行中"></el-option>
                                                <el-option label="已完成" value="已完成"></el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form-item label="创建日期" :label-width="formLabelWidth">
                                            <el-input v-model="editform.start_date" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="结束日期" :label-width="formLabelWidth">
                                            <el-input v-model="editform.end_date" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方" :label-width="formLabelWidth">
                                            <el-input v-model="editform.PartyA" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方地址" :label-width="formLabelWidth">
                                            <el-input v-model="editform.Aaddress" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方联系人" :label-width="formLabelWidth">
                                            <el-input v-model="editform.Acontacter" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方联系人电话" :label-width="formLabelWidth">
                                            <el-input v-model="editform.Acontacter_tel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方" :label-width="formLabelWidth">
                                            <el-input v-model="editform.PartyB" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方地址" :label-width="formLabelWidth">
                                            <el-input v-model="editform.Baddress" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方联系人" :label-width="formLabelWidth">
                                            <el-input v-model="editform.Bcontacter" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方联系人电话" :label-width="formLabelWidth">
                                            <el-input v-model="editform.Bcontacter_tel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="负责人" :label-width="formLabelWidth">
                                            <el-input v-model="editform.head" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="负责人电话" :label-width="formLabelWidth">
                                            <el-input v-model="editform.head_tel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="运单编号" :label-width="formLabelWidth">
                                            <el-input v-model="editform.transport_id" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="结算金额" :label-width="formLabelWidth">
                                            <el-input v-model="editform.amount" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="备注" :label-width="formLabelWidth">
                                            <el-input v-model="editform.notes" type="tel" autocomplete="off"></el-input>
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
                                    <el-form ref="form" :model="form">
                                        <el-form-item label="订单编号" :label-width="formLabelWidth">
                                            <el-input :disabled="true" v-model="addform.order_id"
                                                autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="订单状态" :label-width="formLabelWidth">
                                            <el-select v-model="addform.status" placeholder="请选择状态">
                                                <el-option label="未开始" value="未开始"></el-option>
                                                <el-option label="进行中" value="进行中"></el-option>
                                                <el-option label="已完成" value="已完成"></el-option>
                                            </el-select>
                                        </el-form-item>
                                        <el-form-item label="创建日期" :label-width="formLabelWidth">
                                            <el-input v-model="addform.start_date" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="结束日期" :label-width="formLabelWidth">
                                            <el-input v-model="addform.end_date" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方" :label-width="formLabelWidth">
                                            <el-input v-model="addform.PartyA" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方地址" :label-width="formLabelWidth">
                                            <el-input v-model="addform.Aaddress" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方联系人" :label-width="formLabelWidth">
                                            <el-input v-model="addform.Acontacter" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方联系人电话" :label-width="formLabelWidth">
                                            <el-input v-model="addform.Acontacter_tel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方" :label-width="formLabelWidth">
                                            <el-input v-model="addform.PartyB" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方地址" :label-width="formLabelWidth">
                                            <el-input v-model="addform.Baddress" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方联系人" :label-width="formLabelWidth">
                                            <el-input v-model="addform.Bcontacter" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方联系人电话" :label-width="formLabelWidth">
                                            <el-input v-model="addform.Bcontacter_tel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="负责人" :label-width="formLabelWidth">
                                            <el-input v-model="addform.head" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="负责人电话" :label-width="formLabelWidth">
                                            <el-input v-model="addform.head_tel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="运单编号" :label-width="formLabelWidth">
                                            <el-input v-model="addform.transport_id" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="结算金额" :label-width="formLabelWidth">
                                            <el-input v-model="addform.amount" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="备注" :label-width="formLabelWidth">
                                            <el-input v-model="addform.notes" type="tel" autocomplete="off"></el-input>
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
                order_id:'',
                start_date:'',
                end_date:'',
                PartyA:'',
                Aaddress:'',
                Acontacter:'',
                Acontacter_tel:'',
                PartyB:'',
                Baddress:'',
                Bcontacter:'',
                Bcontacter_tel:'',
                head:'',
                head_tel:'',
                transport_id:'',
                amount:'',
                notes:''
            },
            addform: {
                order_id:'',
                start_date:'',
                end_date:'',
                PartyA:'',
                Aaddress:'',
                Acontacter:'',
                Acontacter_tel:'',
                PartyB:'',
                Baddress:'',
                Bcontacter:'',
                Bcontacter_tel:'',
                head:'',
                head_tel:'',
                transport_id:'',
                amount:'',
                notes:''
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
            axios.get('http://localhost:8080/order/getByPage',
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
            axios.get('http://localhost:8080/order/delete', {
                params: { order_id: row.order_id }
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
            axios.get('http://localhost:8080/order/add', {
                params: {
                    order_id: this.addform.order_id,
                    start_date: this.addform.start_date,
                    end_date: this.addform.end_date,
                    PartyA: this.addform.PartyA,
                    Aaddress: this.addform.Aaddress,
                    Acontacter: this.addform.Acontacter,
                    Acontacter_tel: this.addform.Acontacter_tel,
                    PartyB: this.addform.PartyB,
                    Baddress: this.addform.Baddress,
                    Bcontacter: this.addform.Bcontacter,
                    Bcontacter_tel: this.addform.Bcontacter_tel,
                    head: this.addform.head,
                    head_tel: this.addform.head_tel,
                    transport_id: this.addform.transport_id,
                    amount: this.addform.amount,
                    notes: this.addform.notes
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
            axios.get('http://localhost:8080/order/getById', {
                //传递参数
                params: {
                    order_id: this.input
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
            axios.post('http://localhost:8080/order/update', this.editform)
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
