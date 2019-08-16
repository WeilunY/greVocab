<template>
  <div id="app">
    <!--<word-list :wordData = "words"/>-->
    <word-card/>
  </div>
</template>

<script>
import WordList from "@/components/WordList.vue"
import WordCard from "@/components/WordCard.vue"

export default {
  name: 'app',

  components: {

    WordCard
  },

  data(){
    return{
      words: [],
    }
  },

   mounted(){
      //this.getAllWords()
    },

    methods: {

        async getAllWords(){
            const response = await fetch("http://localhost:8080/word/getAll")
            const data = await response.json()
            this.words = data.data.data
        }
    }
}
</script>

<style>

</style>
