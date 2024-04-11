<template>
    <!-- 登录容器 -->
    <div class="login-container">
      <!-- 登录内容 -->
      <div class="login-content">
        <!-- 登录标题 -->
        <h2 class="login-title">用户登录</h2>
        <!-- 登录表单 -->
        <el-form ref="loginForm" :model="loginForm" :rules="rules" label-width="0" class="login-form">
          <!-- 用户名输入框 -->
          <el-form-item prop="username">
            <el-input v-model="loginForm.username" placeholder="请输入用户名" prefix-icon="el-icon-user"></el-input>
          </el-form-item>
          <!-- 密码输入框 -->
          <el-form-item prop="password">
            <el-input v-model="loginForm.password" type="password" placeholder="请输入密码" prefix-icon="el-icon-lock"></el-input>
          </el-form-item>
          <!-- 登录按钮 -->
          <el-form-item>
            <el-button type="primary" @click="handleSubmit" class="login-btn">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        // 登录表单数据模型
        loginForm: {
          username: '',
          password: ''
        },
        // 登录表单验证规则
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      // 处理登录表单提交事件
      handleSubmit() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            // 使用axios发送登录请求
            axios.post('/api/login', this.loginForm)
              .then(response => {
                console.log(response.data);
              })
              .catch(error => {
                console.error('登录失败：', error);
              });
          } else {
            return false;
          }
        });
      }
    }
  };
  </script>
  
  <style scoped>
  /* 样式只在当前组件生效 */
  .login-container {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh; /* 设置高度为视口高度，实现垂直居中 */
    background-color: #f2f2f2; /* 设置背景色 */
  }
  
  .login-content {
    max-width: 400px; /* 设置内容区最大宽度 */
    padding: 30px; /* 设置内边距 */
    border-radius: 10px; /* 设置边框圆角 */
    box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1); /* 设置阴影效果 */
    background-color: #fff; /* 设置背景色 */
  }
  
  .login-title {
    font-size: 24px; /* 设置标题字体大小 */
    color: #333; /* 设置标题字体颜色 */
    text-align: center; /* 设置标题文本居中 */
    margin-bottom: 30px; /* 设置标题与表单之间的间距 */
  }
  
  .login-form .el-form-item__label {
    display: none; /* 隐藏表单项标签 */
  }
  
  .login-btn {
    width: 100%; /* 设置按钮宽度为100% */
    margin-top: 20px; /* 设置按钮与输入框之间的间距 */
  }
  
  .el-input__inner {
    border-radius: 25px; /* 设置输入框边框圆角 */
  }
  
  .el-input__prefix {
    color: #c0c4cc; /* 设置输入框前缀图标颜色 */
  }
  </style>
  