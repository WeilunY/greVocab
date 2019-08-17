import Vue from 'vue'
import Router from 'vue-router'

import WordCard from '@/components/WordCard.vue'
import WordList from '@/components/WordList.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/card',
      name: 'WordCard',
      component: WordCard,
    },

    {
      path: '/card/:id',
      name: 'WordCard',
      component: WordCard,
      props: true
    }, 
    {
      path: '/list',
      name: 'WordList',
      component: WordList
    }
    
  ]
})