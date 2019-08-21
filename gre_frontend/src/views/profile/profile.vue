<template>
    <div class="container">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm">

        <el-form-item label="Username: " prop="username">
            <p v-if=" this.edit === false "> {{this.user.username}} </p>
            <el-input v-else v-model="ruleForm.username"></el-input>
        </el-form-item>

        <el-form-item label="Email: " prop="email">
            <p v-if=" this.edit === false "> {{this.user.email}} </p>
            <el-input v-else v-model="ruleForm.email" placeholder="Enter Your Email"></el-input>
        </el-form-item>

        <el-form-item v-if=" this.edit === false ">
            <el-button @click="toogleHidden(1)"> Edit </el-button>
        </el-form-item>

        <div v-else>

            <el-form-item label="Password: " prop="pass">
                <el-input type="password" v-model="ruleForm.pass" autocomplete="off" placeholder="Enter Your Password"></el-input>
            </el-form-item>

            <el-form-item label="Confirm Password: " prop="checkPass">
                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off" placeholder="Re-Enter Your Password"></el-input>
            </el-form-item>

            <el-form-item >
                <el-button type="primary" @click="submitForm()">Save</el-button>
                <el-button @click="resetForm('ruleForm')">Reset</el-button>
                <el-button @click="toogleHidden(0)"> Exit </el-button>
            </el-form-item>
            </div>
    </el-form>

    </div>
</template>

<script>
export default {
    name: 'profie',

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
            user: Object,
            edit: false,

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

        mounted(){
            this.getUser()
        },

        methods: {
            async getUser() {
                const response = await fetch("http://localhost:8080/user/getUser", {
                    method: "POST",
                    headers: { 'Content-type': 'application/json'},
                    body: JSON.stringify({"id": sessionStorage.user_id})
                })

                const data = await response.json()

                this.user = data.data
            }, 

            async submitForm() {
                const valid = await this.$refs['ruleForm'].validate()
    
                if (valid) {

                    const response = await fetch("http://localhost:8080/user/updateUser", {
                        method: "POST",
                        headers: {'Content-type': 'application/json'},
                        body: JSON.stringify({
                            'id': sessionStorage.user_id,
                            'username': this.ruleForm.username,
                            'password': this.ruleForm.pass,
                            'email': this.ruleForm.email
                        })
                    })

                    const data = await response.json()

                    if(data.status !== "success"){
                        this.$message.error("Can't find existing user")
                    } else {
                        this.toogleHidden(0)
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
            },

            toogleHidden(state) {
                if (state === 1){
                    this.edit = true;
                } else {
                    this.edit = false;
                }
            }
        }
    
}
</script>

<style scoped>
    .container{
        text-align: left;
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