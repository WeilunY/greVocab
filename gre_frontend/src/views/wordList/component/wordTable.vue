<template>
    <div class="container">

        <el-table :data="words" style="width:100%"
        :row-class-name="favorited">
            <el-table-column type="index" label=""  sortable>
            </el-table-column>

            <el-table-column prop="word" label="Word"  sortable>
            </el-table-column>

            <el-table-column prop="chin_def" label="Chinese Definition" >
            </el-table-column>

            <el-table-column label="favorite">
                <template slot-scope="scope">
                <el-button v-if="scope.row.user_id > 0" circle plain type="warning" icon="el-icon-star-on"
                    @click="toggleFavorite(scope.row, 0)"></el-button>
                <el-button v-else circle plain type="warning" icon="el-icon-star-off"
                    @click="toggleFavorite(scope.row, 1)"></el-button>
                </template>
            </el-table-column>

        </el-table>

    </div>
    
</template>

<script>
export default {
    name: "word-table",

    props:{
        words: Array,
    },

    methods: {

        /**
         * Whether display as favorite 
         */
        favorited({row, rowIndex}){
            if(row.user_id > 0){
                return 'success-row';
            }
            return ''
        },

        /**
         * Call parent favorite
         */
        async toggleFavorite(row, status){
            this.$parent.toggleFavorite(row, status)
        }

    }
    
}
</script>

<style>

    .el-table .success-row {
        background: #f0f9eb;
    }


</style>