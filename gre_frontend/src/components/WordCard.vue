<template>

    <div class="outer-container">
    <div class="back-card">
        <div class="container">
            <h1>{{ word }}</h1>
            <h2>{{ chin_def }}</h2>
        </div>

    </div>
    <div class="buttons">
        <button type="button" class="btn"
         @click="getWord(current_id - 1)">Previous</button>
         
        <button type="button" class="btn"
        @click="getWord(current_id + 1)">Next</button>
    </div>
    
    </div>
    
</template>

<script>
export default {
    name: "word-card",

    mounted(){
        this.getWord(1);
    },

    data(){
        return {
            current_id: Number,
            word: String,
            chin_def: String,
        }   
    },

    props: {
        user_id: Number,
    },

    
    methods: {

        async getWord(id){

            if(id <= 0){
                id = 1
            }
            
            const response = await fetch(`http://localhost:8080/word/getAWord/${id}`)

            const data = await response.json()

            this.current_id = data.data.id
            this.word = data.data.word
            this.chin_def = data.data.chin_def

        },
        

    },


}
</script>

<style scoped>

    .outer-container{

        height: 450px;
        width: 700px;
        position: absolute;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        margin: auto;

    }
    .back-card{
        height: 400px;
        width: 700px;
        background-color: cornflowerblue;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
       
    }

    .container {
        position: absolute;
        left: 50%;
        top: 45%;
        transform: translate(-50%, -50%);
    }

    .buttons{
        margin-top: 40px;
        position: relative;
        text-align: center
    }

    h1{
        font-family: 'Helvetica';
        font-size: 44px;
        color: white;
        text-align: center;
    }

    h2{
        font-family: 'Helvetica';
        font-size: 24px;
        color: white;
        text-align: center;
    }
        
</style>