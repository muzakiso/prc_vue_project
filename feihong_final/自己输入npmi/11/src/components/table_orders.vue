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
                    <el-table-column prop="ordersId" label="订单编号" width="100">
                    </el-table-column>
                    <el-table-column prop="status" label="订单状态" width="100">
                    </el-table-column>
                    <el-table-column prop="startDate" label="创建日期" width="100">
                    </el-table-column>
                    <el-table-column prop="endDate" label="结束日期" width="100">
                    </el-table-column>
                    <el-table-column prop="partya" label="甲方" width="200">
                    </el-table-column>
                    <el-table-column prop="aaddress" label="甲方地址" width="250">
                    </el-table-column>
                    <el-table-column prop="acontacter" label="甲方联系人" width="100">
                    </el-table-column>
                    <el-table-column prop="acontacterTel" label="甲方联系人电话" width="180">
                    </el-table-column>
                    <el-table-column prop="partyb" label="乙方" width="200">
                    </el-table-column>
                    <el-table-column prop="baddress" label="乙方地址" width="250">
                    </el-table-column>
                    <el-table-column prop="bcontacter" label="乙方联系人" width="100">
                    </el-table-column>
                    <el-table-column prop="bcontacterTel" label="乙方联系人电话" width="180">
                    </el-table-column>
                    <el-table-column prop="head" label="负责人" width="100">
                    </el-table-column>
                    <el-table-column prop="headTel" label="负责人电话" width="180">
                    </el-table-column>
                    <el-table-column prop="transportId" label="运单编号" width="180">
                    </el-table-column>
                    <el-table-column prop="amount" label="结算金额" width="180">
                    </el-table-column>
                    <el-table-column prop="notes" label="备注" width="200">
                    </el-table-column>


                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button type="primary" size="mini" icon="el-icon-edit"
                                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                            <!-- 编辑对话框 -->
                            <el-dialog title="录入信息" :visible.sync="editdialogVisible">
                                <span>
                                    <el-form ref="form" :model="editform">
                                        <el-form-item label="订单编号" :label-width="formLabelWidth">
                                            <el-input :disabled="true" v-model="editform.ordersId"
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
                                            <el-input v-model="editform.startDate" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="结束日期" :label-width="formLabelWidth">
                                            <el-input v-model="editform.endDate" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方" :label-width="formLabelWidth">
                                            <el-input v-model="editform.partya" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方地址" :label-width="formLabelWidth">
                                            <el-input v-model="editform.aaddress" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方联系人" :label-width="formLabelWidth">
                                            <el-input v-model="editform.acontacter" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方联系人电话" :label-width="formLabelWidth">
                                            <el-input v-model="editform.acontacterTel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方" :label-width="formLabelWidth">
                                            <el-input v-model="editform.partyb" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方地址" :label-width="formLabelWidth">
                                            <el-input v-model="editform.baddress" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方联系人" :label-width="formLabelWidth">
                                            <el-input v-model="editform.bcontacter" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方联系人电话" :label-width="formLabelWidth">
                                            <el-input v-model="editform.bcontacterTel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="负责人" :label-width="formLabelWidth">
                                            <el-input v-model="editform.head" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="负责人电话" :label-width="formLabelWidth">
                                            <el-input v-model="editform.headTel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="运单编号" :label-width="formLabelWidth">
                                            <el-input v-model="editform.transportId" autocomplete="off"></el-input>
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
                                    <el-form ref="form" :model="addform">
                                        <el-form-item label="订单编号" :label-width="formLabelWidth">
                                            <el-input :disabled="false" v-model="addform.ordersId"
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
                                            <el-input v-model="addform.startDate" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="结束日期" :label-width="formLabelWidth">
                                            <el-input v-model="addform.endDate" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方" :label-width="formLabelWidth">
                                            <el-input v-model="addform.partya" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方地址" :label-width="formLabelWidth">
                                            <el-input v-model="addform.aaddress" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方联系人" :label-width="formLabelWidth">
                                            <el-input v-model="addform.acontacter" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="甲方联系人电话" :label-width="formLabelWidth">
                                            <el-input v-model="addform.acontacterTel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方" :label-width="formLabelWidth">
                                            <el-input v-model="addform.partyb" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方地址" :label-width="formLabelWidth">
                                            <el-input v-model="addform.baddress" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方联系人" :label-width="formLabelWidth">
                                            <el-input v-model="addform.bcontacter" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="乙方联系人电话" :label-width="formLabelWidth">
                                            <el-input v-model="addform.bcontacterTel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="负责人" :label-width="formLabelWidth">
                                            <el-input v-model="addform.head" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="负责人电话" :label-width="formLabelWidth">
                                            <el-input v-model="addform.headTel" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="运单编号" :label-width="formLabelWidth">
                                            <el-input v-model="addform.transportId" autocomplete="off"></el-input>
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
                ordersId:'',
                startDate:'',
                status:'',
                endDate:'',
                partya:'',
                aaddress:'',
                acontacter:'',
                acontacterTel:'',
                partyb:'',
                baddress:'',
                bcontacter:'',
                bcontacterTel:'',
                head:'',
                headTel:'',
                transportId:'',
                amount:'',
                notes:''
            },
            addform: {
                ordersId:'',
                startDate:'',
                status:'',
                endDate:'',
                partya:'',
                aaddress:'',
                acontacter:'',
                acontacterTel:'',
                partyb:'',
                baddress:'',
                bcontacter:'',
                bcontacterTel:'',
                head:'',
                headTel:'',
                transportId:'',
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
            axios.get('http://localhost:8080/orders/getByPage',
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
            axios.get('http://localhost:8080/orders/delete', {
                params: { ordersId: row.ordersId }
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
            axios.get('http://localhost:8080/orders/add', {
                params: {
                    ordersId: this.addform.ordersId,
                    startDate: this.addform.startDate,
                    status: this.addform.status,
                    endDate: this.addform.endDate,
                    partya: this.addform.partya,
                    aaddress: this.addform.aaddress,
                    acontacter: this.addform.acontacter,
                    acontacterTel: this.addform.acontacterTel,
                    partyb: this.addform.partyb,
                    baddress: this.addform.baddress,
                    bcontacter: this.addform.bcontacter,
                    bcontacterTel: this.addform.bcontacterTel,
                    head: this.addform.head,
                    headTel: this.addform.headTel,
                    transportId: this.addform.transportId,
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
            axios.get('http://localhost:8080/orders/getById', {
                //传递参数
                params: {
                    ordersId: this.input
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
            axios.post('http://localhost:8080/orders/update', this.editform)
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
