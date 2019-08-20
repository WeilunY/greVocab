<template>
    <div class="container">
        <a>Login to GRE Vocab</a>
        <el-form :model="form" class="demo-form-inline">
        <el-form-item label="Username: ">
            <el-input v-model="form.username" placeholder="username"></el-input>
        </el-form-item>
        <el-form-item label="Password: ">
            <el-input v-model="form.password" placeholder="password" type="password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">Login</el-button>
            <el-button  @click="onSubmit">Register</el-button>
        </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    data() {
      return {
        form: {
          username: '',
          password: ''
        }
      }
    },
    methods: {
      async onSubmit() {

        const response = await fetch("http://localhost:8080/login/verify", {
            method: "POST", 
            headers: { 'Content-type': 'application/json'},
            body: JSON.stringify({'username': this.form.username, 'password': this.form.password})
        })

        const data = await response.json()

        const status = data.status
       
        if(status === "error") {
            alert("Wrong username or password")
        } else {

            this.$store.commit('login', data.data)
            sessionStorage.user_id = data.data
            this.$router.push('wordList')

        }
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

</style>