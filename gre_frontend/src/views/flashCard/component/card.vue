<template>
    
    <div class="container">
    <el-button v-if="this.word.user_id > 0" circle type="warning" icon="el-icon-star-on" class="fav"
                   @click="toggleFavorite(0)"></el-button>
            <el-button v-else circle plain type="warning" icon="el-icon-star-off" class="fav"
                   @click="toggleFavorite(1)"></el-button>
    <el-card class="box-card">
        <div slot="header">
            <span>{{ this.word.word }}</span>
        </div>

        <div class="text item"> {{this.word.chin_def}} </div>
        

    </el-card>
    <div class="buttons">

            <el-button v-if="this.word_id > 1" @click="handleWord(0)" icon="el-icon-arrow-left"></el-button>
            <el-button v-else disabled>Previous</el-button>

            <el-button v-if="this.word_id < this.total" @click="handleWord(1)" icon="el-icon-arrow-right"></el-button>
            <el-button v-else disabled>Previous</el-button>
        </div>
    </div>
    
</template>

<script>
export default {
    name: "card",


    data(){
        return {
            user_id: -1,
            word: Object,
            word_id: Number,
            total: 0,
        }
    },

    mounted(){
        if(this.$route.params.word_id != null){
            this.word_id = this.$route.params.word_id
        } else {
            this.word_id = 1
        }
        this.getUserId()
        this.getWord(this.word_id)
        this.getSize()
        
    },

    methods: {
        /**
         * Get current word
         */
        async getWord(id){
            const response = await fetch("http://localhost:8080/word/getRange", {
            method: 'POST',
            headers: { 'Content-type': 'application/json'},
            body: JSON.stringify({'start': id, 'end': id, 'id': this.user_id})
            })

            const data = await response.json()

            const word_list = [].slice.call(data.data.data)

            this.word = word_list[0]
        },

         /**
         * Get the total number of word
         */
        async getSize(){
            const response = await fetch("http://localhost:8080/word/getCount")

            const data = await response.json()

            this.total = data.data
            
        },

        handleWord(status){
            if (status === 1){
                this.word_id += 1
            } else {
                this.word_id -= 1
            }

            this.getWord(this.word_id)
        },

        async toggleFavorite(status){
            const response = await fetch("http://localhost:8080/word/changeFavorite", {
                method: 'POST',
                headers: { 'Content-type': 'application/json'},
                body: JSON.stringify({'user_id': this.user_id, 'word_id': this.word_id, 'favorite': status})
            })
            const data = await response.json()

            this.getWord(this.word_id);
        },

        getUserId(){
          this.user_id = sessionStorage.user_id
        }
        
    },

    watch: {
        'sessionStorage.user_id': 'getUserId'
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

    .container{
        width: 600px;
        height: 400px;
        position: absolute;
        left: 0;
        top: 0;
        right: 0;
        bottom: 10%;
        margin: auto;
    }
    .box-card {
        width: 600px;
        height: 300px;
        
    }
    .fav {
        float: right;
        margin-bottom: 10px;
    }

    .buttons {
        margin-top: 20px;
    }

</style>