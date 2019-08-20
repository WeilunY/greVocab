<template>
    <div class="container">
        <h1>Login to GRE Vocab</h1>
        <el-form :model="form">
        <el-form-item label="Email / Username: ">
            <el-input v-model="form.email" placeholder="email or username"></el-input>
        </el-form-item>
        <el-form-item label="Password: ">
            <el-input v-model="form.password" placeholder="password" type="password"></el-input>
        </el-form-item>
        <el-form-item style="padding-top: 18px">
            <el-button type="primary" @click="onSubmit">Login</el-button>
            <el-button  @click="toRegister">Register</el-button>
        </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    data() {
      return {
        form: {
          email: '',
          password: ''
        }
      }
    },

    methods: {
      async onSubmit() {

        const response = await fetch("http://localhost:8080/login/verify", {
            method: "POST", 
            headers: { 'Content-type': 'application/json'},
            body: JSON.stringify({'email': this.form.email, 'password': this.form.password})
        })

        const data = await response.json()

        const status = data.status
       
        if(status === "error") {
           this.$message.error('Wrong Email or Password');
            
        } else {

            this.$store.commit('login', data.data)
            sessionStorage.user_id = data.data
            console.log(sessionStorage.user_id)
            this.$router.push('wordList')

        }
      },

      toRegister(){
          this.$router.push('register')
      }
    }
}
</script>

<style scoped>
    .container{
        width: 400px;
        height: 600px;
        position: absolute;
        left: 0;
        top: 0;
        right: 0;
        bottom: 10%;
        margin: auto;
    }

    h1{
        font-size: 32px;
        margin-bottom: 20px;
    }

</style>