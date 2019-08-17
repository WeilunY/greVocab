import Vue from 'vue';
import router from './router'
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'


new Vue({
  el: '#app',
  router,

  render: h => h(App)
});