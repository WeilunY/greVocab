<template>
  <div id="app">
    <word-list :wordData = "words"/>
  </div>
</template>

<script>
import WordList from "@/components/WordList.vue"

export default {
  name: 'app',

  components: {
    WordList
  },

  data(){
        return {
            words:[
                 {
                    "id": 1,
                    "word": "abase",
                    "chin_def": "v.降低···的地位，贬抑，使卑下"
                },
                {
                    "id": 2,
                    "word": "abash",
                    "chin_def": "v.使害羞，使尴尬"
                },
                {
                    "id": 3,
                    "word": "abate",
                    "chin_def": "v.减轻，减少"
                },
                {
                    "id": 16,
                    "word": "abolish",
                    "chin_def": "v.废止，废除(法律、制度、习俗等)"
                }
            ]
        }
    }
}
</script>

<style>

</style>
