<template>
    <el-scrollbar>
        <el-table :data="tableData">
            <el-table-column type="index" label="ID" width="100" />
            <el-table-column prop="fruitCase" label="苹果的种类" width="200" />
            <el-table-column prop="mac" label="种植面积" width="200" />
            <el-table-column prop="season" label="成熟季节" width="200" />
            <el-table-column prop="input" label="水果产量" width="200" />
            <el-table-column label="操作">
                <template #default="scope">
                    <el-button size="small" @click="handleEdit()">
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
            <el-form-item label="苹果的种类:">
                <el-input v-model="userUpData.user.fruitCase" />
            </el-form-item>

            <el-form-item label="种植面积:">
                <el-input v-model="userUpData.user.mac" />
            </el-form-item>

            <el-form-item label="成熟季节:">
                <el-input v-model="userUpData.user.season" />
            </el-form-item>

            <el-form-item label="水果产量:">
                <el-input v-model="userUpData.user.input" />
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
import { getFruit, fixFruit } from '@/api/Fruit'
//水果的信息
let tableData = ref([])
//修改显示和隐藏
let dialogVisible = ref(false)
//修改表单时输入的数据
let userUpData: any = reactive({
    user: {
        fruitCase: '',
        mac: '',
        season: '',
        input: ''

    },
})

//修改的按钮
const handleEdit = () => {
    dialogVisible.value = true;
}

//修改表格的接口
const userFixData = async () => {
    const result: any = await fixFruit(userUpData)
    if (result.code = "0x200") {
        ElNotification({
            title: 'Success',
            message: '修改成功',
            type: 'success',
        })
        fruit();
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
    console.log(index, 'index');

    // const result: any = await deleteFruit(index)
    // if (result.code = "0x200") {
    //     ElNotification({
    //         title: 'Success',
    //         message: '修改成功',
    //         type: 'success',
    //     })
    //     fruit();
    //     console.log(result, 'sdsd');
    // } else {
    //     ElNotification({
    //         title: 'Error',
    //         message: '修改失败',
    //         type: 'error',
    //     })
    // }

}

//获取苹果信息
const fruit = async () => {
    const result: any = await getFruit()
    console.log(result, 'dsds');

    if (result.data.code === '0x200') {
        tableData.value = result.data.data
        console.log(tableData.value);
    }
}

onMounted(() => {
    fruit()
})
</script>