<template>
  <div id="app">
    <Navigation></Navigation>
    <router-view/>
    

  </div>
</template>

<script>
// import WordList from "@/components/WordList.vue"
// import WordCard from "@/components/WordCard.vue"
import Navigation from './components/Navigation'

export default {
  name: 'app',

  components: {

    // WordCard,
    Navigation
  },

  data(){
    return{
      user_id: 1,
      activeName: "first",
    }
  },

   
}
</script>

<style scoped>

</style>

