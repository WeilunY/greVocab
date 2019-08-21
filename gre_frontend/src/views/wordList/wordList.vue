<template>
  <div class="container">
      <!-- word table -->
      <word-table v-bind:words="word_list" style="margin-bottom: 20px;"></word-table>

      <!-- change page -->
      <div class="page">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[12, 15, 20]"
            :page-size="pageSize"
            background
            layout="total, sizes, prev, pager, next, jumper"
            :total="total">
          </el-pagination>
      </div>
  </div>
</template>

<script>
import WordTable from "./component/wordTable.vue";

export default {
  name: 'wordList',

  components: {
    WordTable,
  },

  created(){
    this.getUserId()
    this.getRange(1, 12, this.user_id)
  
    this.getSize()
  },

  data(){
        return {
            word_list: [],
            currentPage: 1,
            pageSize: 12,
            total: 10,
            favorites: [],
            user_id: -1,
        }
    },

  methods: {

      /**
       * Change number of item per page
       */
      handleSizeChange(val) {
        this.pageSize = val

        const start = (this.currentPage - 1) * this.pageSize + 1
        const end = this.currentPage * this.pageSize

        this.getRange(start, end, this.user_id);
 
      },

      /**
       * Change current page number
       */
      handleCurrentChange(val) {
        this.currentPage = val;

        const start = (this.currentPage - 1) * this.pageSize + 1
        const end = this.currentPage * this.pageSize

        this.getRange(start, end, this.user_id);
      },

     /**
      * Get the range of words display per page
      * @param start: the start index
      * @param end: end index
      * @param id: user_id
      */
     async getRange(start, end, id){
      const response = await fetch("http://localhost:8080/word/getRange", {
          method: 'POST',
          headers: { 'Content-type': 'application/json'},
          body: JSON.stringify({'start': start, 'end': end, 'id': id})
          })

          const data = await response.json()

          this.word_list = [].slice.call(data.data.data)
      },

      /**
       * Get the total number of word
       */
      async getSize(){
        const response = await fetch("http://localhost:8080/word/getCount")

        const data = await response.json()

        this.total = data.data
        
        console.log(data.data)
      },

      /**
       * Change the favoriate status of certain word
       * @param row the row number
       * @param status 1 - favorite, 0 - unfavoirte 
       */
      async toggleFavorite(row, status){
        const response = await fetch("http://localhost:8080/word/changeFavorite", {
                method: 'POST',
                headers: { 'Content-type': 'application/json'},
                body: JSON.stringify({'user_id': this.user_id, 'word_id': row.id, 'favorite': status})
          })

          const data = await response.json()

          const start = (this.currentPage - 1) * this.pageSize + 1
          const end = this.currentPage * this.pageSize

          this.getRange(start, end, this.user_id);
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
<style lang="css">
    .container {
        /*max-width: 1200px;*/
        margin-left: 6%;
        margin-right: 6%;
    
    }

    .page {
     position: sticky;
     bottom: 10px;
      
    }
</style>