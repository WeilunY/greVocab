<template>
    <div class="outer-container">
        <div class="table table-striped table-hover">
            <p v-if="words.length < 1" class="word-table">
            No Words
            </p>

            <table v-else>
            <thead>
                <tr>
                <th scope="col">ID</th>
                <th scope="col">Word</th>
                <th scope="col">Chinese Definition</th>
                </tr>
            </thead>
            <!-- for loop for loading data-->
            <tr scope="row" v-for="word in words" :key="word.id">
                <td>{{word.id}}</td>
                <td>{{word.word}}</td>
                <td>{{word.chin_def}}</td>
            </tr>
            </table>
        </div>
        <div class="b-group">
            <button type="button" class="btn" @click="previousPage()">Previous</button>
            <button type="button" class="btn" @click="nextPage()">Next</button>
        </div>
    
    </div>


</template>

<script>

export default {
    name: 'word-list',

    data() {
        return {
            words: Object,
            currentPage: 1,
            contentInPage: 10,
        }
    },

   mounted(){
    //    this.currentPage = 1,
    //    this.contentInPage = 10,
       this.getRange(1, 10)
    },


    methods: {

        async getRange(start, end){
            const response = await fetch("http://localhost:8080/word/getRange", {
                method: 'POST',
                headers: { 'Content-type': 'application/json'},
                body: JSON.stringify({'start': start, 'end': end}),
                //mode: 'no-cors'
            })

            const data = await response.json()
            this.words = data.data.data
        },

        async getAllWords(){
            const response = await fetch("http://localhost:8080/word/getAll")
            const data = await response.json()
            //console.log(type(data.data.data))
            this.words = data.data.data
        },

        async previousPage(){
            if (this.currentPage == 1){
                return
            }

            this.currentPage = this.currentPage - 1; 
            const start = (this.currentPage - 1) * 10 + 1
            const end = this.currentPage * 10
            this.getRange(start, end)
        }, 

        async nextPage(){
            

            this.currentPage = this.currentPage + 1; 
            const start = (this.currentPage - 1) * 10 + 1
            const end = this.currentPage * 10
            this.getRange(start, end)
        }
    }
}
</script>

<style scoped>
   

</style>
