// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import index from './views/index';
import routers from './router.js';
import VueRouter from 'vue-router';
import ElementUI from 'element-ui';
import locale from 'element-ui/lib/locale/lang/en'
import 'element-ui/lib/theme-chalk/index.css';
import Vuex from 'vuex'


Vue.use(Vuex)
Vue.use(VueRouter);
Vue.use(ElementUI, {locale,});
Vue.config.productionTip = false

let router = new VueRouter({
  routes: routers,
  mode: 'history'
});


var firstRouter = null;
router.beforeEach((to, from, next) => {
  if (!firstRouter) {
    firstRouter = to;
    next(false);
  } else {
    next();
  }
});

const store = new Vuex.Store({
  state: {
    adminCurrentMenu:"",
    adminUserId: -1, 
  },

  mutations: {
    login(state, userId){
      state.adminUserId = userId
    }, 

    navigate(state, menu){
      state.adminCurrentMenu = menu
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,

  // start app with property as first route
  render: (h) => {
    return h(index, {
      props: {
        firstRouter: firstRouter
      }
    });
  }
})
