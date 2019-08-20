<template>
    <div class="container">
        <h2>Register For GRE</h2>

        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm">

        <el-form-item label="Username: " prop="username">
            <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>

        <el-form-item label="Email: " prop="email">
            <el-input v-model="ruleForm.email"></el-input>
        </el-form-item>

        <el-form-item label="Password: " prop="pass">
            <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="Confirm Password: " prop="checkPass">
            <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        
        <el-form-item>
            <el-button type="primary" @click="submitForm()">Submit</el-button>
            <el-button @click="resetForm('ruleForm')">Reset</el-button>
        </el-form-item>
    </el-form>
    </div>
    
</template>

<script>
  export default {
      name: "register",

        data() {
        var checkUsername = (rule, value, callback) => {
            if (!value) {
                return callback(new Error('Username Cannot be empty'));
            }
            setTimeout(() => {
                callback();
            }, 100)
        };

        var checkEmail = (rule, value, callback) => {
            const mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
            if (!value) {
            return callback(new Error("Email can't be empty"))
            }
            setTimeout(() => {
            if (mailReg.test(value)) {
                callback()
            } else {
                callback(new Error("Please enter the correct email format"))
            }
            }, 100)
            
        };

        var validatePass = (rule, value, callback) => {
            if (value === '') {
            callback(new Error('Please enter your password'));
            } 
            else {
            if (this.ruleForm.checkPass !== '') {
                this.$refs.ruleForm.validateField('checkPass');
            }
            callback();
            }
        };

        var validatePass2 = (rule, value, callback) => {
            if (value === '') {
            callback(new Error('Please re-enter your password'));
            } else if (value !== this.ruleForm.pass) {
            callback(new Error("Passwords don't match"));
            } else {
            callback();
            }
        };

        return {
            ruleForm: {
                pass: '',
                checkPass: '',
                username: '',
                email: '',
            },
            rules: {
                pass: [
                    { validator: validatePass, trigger: 'blur' },
                    { pattern: /^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\W_]+$)(?![a-z0-9]+$)(?![a-z\W_]+$)(?![0-9\W_]+$)[a-zA-Z0-9\W_]{8,30}$/,
                     message: '密码为数字，小写字母，大写字母，特殊符号 至少包含三种，长度为 8 - 30位' }
                ],
                checkPass: [
                    { validator: validatePass2, trigger: 'blur' }
                ],
                 username: [
                    { validator: checkUsername, trigger: 'blur' }
                ],
                email: [
                    { validator: checkEmail, trigger: 'blur' }
                ],
               
            }
          };
        },

        methods: {
            async submitForm() {
                const valid = await this.$refs['ruleForm'].validate()
    
                if (valid) {

                    const response = await fetch("http://localhost:8080/user/createUser", {
                        method: "POST",
                        headers: {'Content-type': 'application/json'},
                        body: JSON.stringify({
                            'username': this.ruleForm.username,
                            'password': this.ruleForm.pass,
                            'email': this.ruleForm.email
                        })
                    })

                    const data = await response.json()

                    if(data.status !== "success"){
                        this.$message.error("The email has already existed")
                    } else {
                        this.$router.push('login')
                        this.$message({
                            message: "Registration Success",
                            type: "success"
                        })
                    }

                } else {
                    console.log('error submit!!');
                    return false;
                }
    
            },

            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>
    h2{
        font-size: 32px;
        margin-bottom: 20px;
    }
    .container{
        width: 500px;
        height: 600px;
        position: absolute;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        margin: auto;
    }
</style>