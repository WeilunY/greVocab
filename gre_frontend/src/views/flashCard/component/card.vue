<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>{{ this.word.word }}</span>
            <el-button v-if="this.word.user_id > 0" circle plain type="warning" icon="el-icon-star-on"
                   ></el-button>
            <el-button v-else circle plain type="warning" icon="el-icon-star-off"
                    ></el-button>
        </div>

        <div class="text item"> {{this.word.chin_def}} </div>

    </el-card>
    
</template>

<script>
export default {
    name: "card",

    props:{
        word_id: Number,
    },

    data(){
        return {
            user_id: 1,
            word: Object,
        }
    },

    mounted(){
        this.getWord(2)
    },

    methods: {
        async getWord(id){
            const response = await fetch("http://localhost:8080/word/getRange", {
            method: 'POST',
            headers: { 'Content-type': 'application/json'},
            body: JSON.stringify({'start': id, 'end': id, 'id': this.user_id})
            })

            const data = await response.json()

            const word_list = [].slice.call(data.data.data)

            this.word = word_list[0]
        }
    }

}
</script>

<style scoped>
    .text {
        font-size: 24px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 600px;
        height: 260px;
    }

</style>