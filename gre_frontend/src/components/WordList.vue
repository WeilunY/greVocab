<template>
    <div class="words">
        <el-table
        :data="wordData"
        style="width: 100%">
        <el-table-column
            prop="word"
            label="Word"
            width="300">
        </el-table-column>
        <el-table-column
            prop="chin_def"
            label="Chinese Definition"
            width="300">
        </el-table-column>
        </el-table>
    </div>
</template>

<script>
export default {
    name: 'word-list',

    props: {
        wordData: Array,
    },

   
}
</script>

<style scoped>
    .words{
        width: 1000px;
        height: 1000px;
    }

</style>
