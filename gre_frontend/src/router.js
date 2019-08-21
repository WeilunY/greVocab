export default  [
    {
        path: '/home.html',
        name: 'home',
        meta: {
            title: '--',
            author: 'luohao'
        },
        component: (resolve) => {
            require.ensure([], () => {
                return resolve(require('./views/home/home.vue'))
            }, 'home/home')
        },
        children: [
            {
                path: '/wordList',
                name: 'wordList',
                meta: {
                    title: 'Word List',
                    author: 'WY',
                },
                component: (resolve) => {
                    require.ensure([], () => {
                        return resolve(require('./views/wordList/wordList.vue'))
                    }, 'wordList/wordList')
                }
            },
            {
                path: '/flashCard',
                name: 'flashCard',
                meta: {
                    title: 'Flash Card',
                    author: 'WY'
                },
                component: (resolve) => {
                    require.ensure([], () => {
                        return resolve(require('./views/flashCard/flashCard.vue'))
                    }, 'flashCard/flashCard')
                }
            },

            {
                path: '/profile',
                name: 'profile',
                meta: {
                    title: 'Profile'
                },
                component: (resolve) => {
                    require.ensure([], () => {
                        return resolve(require('./views/profile/profile.vue'))
                    }, 'profile/profile')
                }
            }

        ]
    }, 
    {  
        path: '/login',
        name: 'login',
        meta: {
            title: 'Login',
        }, 
        component: (resolve) => {
            require.ensure([], () => {
                return resolve(require('./views/login/login.vue'))
            }, 'login/login')
        }
    },

    {  
        path: '/register',
        name: 'register',
        meta: {
            title: 'Register',
        }, 
        component: (resolve) => {
            require.ensure([], () => {
                return resolve(require('./views/login/register.vue'))
            }, 'login/register')
        }
    }
]