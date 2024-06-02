<template>
    <el-scrollbar>
        <el-table :data="tableData">
            <el-table-column type="index" label="ID" width="100" />
            <el-table-column prop="name" label="水果的种类" width="200" />
            <el-table-column prop="firstSeason" label="第一季度" width="200" />
            <el-table-column prop="secondSeason" label="第二季度" width="200" />
            <el-table-column prop="thirdSeason" label="第三季度" width="200" />
            <el-table-column prop="forthSeason" label="第四季度" width="200" />
            <el-table-column label="操作">
                <template #default="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">
                        修改
                    </el-button>
                    <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">
                        删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </el-scrollbar>
    <!-- 修改窗口 -->
    <el-dialog v-model="dialogVisible" title="请修改你的个人信息" width="500">
        <el-form class="demo-ruleForm">
            <el-form-item label="水果的种类:">
                <el-input v-model="userUpData.name" />
            </el-form-item>

            <el-form-item label="第一季度:">
                <el-input v-model.number="userUpData.firstSeason" />
            </el-form-item>

            <el-form-item label="第二季度:">
                <el-input v-model.number="userUpData.secondSeason" />
            </el-form-item>

            <el-form-item label="第三季度:">
                <el-input v-model.number="userUpData.thirdSeason" />
            </el-form-item>

            <el-form-item label="第四季度:">
                <el-input v-model.number="userUpData.forthSeason" />
            </el-form-item>


        </el-form>
        <template #footer>
            <div class="dialog-footer">
                <el-button @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click.native="userFixData" @click="dialogVisible = false">
                    确认
                </el-button>
            </div>
        </template>
    </el-dialog>
</template>
<script lang="ts" setup>
import { ref, reactive, onMounted } from 'vue'
import axios from 'axios'
import { ElNotification } from 'element-plus'
import { getFruitSeason, fixFruitSeason, deleteFruitSeason } from '@/api/season'
//水果的信息
let tableData = ref([])
//修改显示和隐藏
let dialogVisible = ref(false)
//修改表单时输入的数据
let userUpData: any = reactive({
    id: '',

})

//修改的按钮
const handleEdit = (index: any, scope: any) => {
    // console.log(scope);
    dialogVisible.value = true;
    userUpData.id = scope.id;
    userUpData.name = '';
    userUpData.firstSeason = null;
    userUpData.secondSeason = null;
    userUpData.thirdSeason = null;
    userUpData.forthSeason = null;
}


//修改表格的接口
const userFixData = async () => {
    const result: any = await fixFruitSeason(userUpData)
    if (result.code = "0x200") {
        ElNotification({
            title: 'Success',
            message: '修改成功',
            type: 'success',
        })
        fruitSeason();
        console.log(result, 'sdsd');
    } else {
        ElNotification({
            title: 'Error',
            message: '修改失败',
            type: 'error',
        })
    }

}

//删除按钮
const handleDelete = async (index: any, scope: any) => {
    const result: any = await deleteFruitSeason(scope.id)

    if (result.code = "0x200") {
        ElNotification({
            title: 'Success',
            message: '删除成功',
            type: 'success',
        })
        fruitSeason();
        console.log(result, 'sdsd');
    } else {
        ElNotification({
            title: 'Error',
            message: '删除失败',
            type: 'error',
        })
    }

}

//获取苹果信息
const fruitSeason = async () => {
    const result: any = await getFruitSeason()
    console.log(result, 'dsds');
    if (result.data.code === '0x200') {
        tableData.value = result.data.data
        console.log(tableData.value);
    }
}

onMounted(() => {
    fruitSeason()
})
</script>