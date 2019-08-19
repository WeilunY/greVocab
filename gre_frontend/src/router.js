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
                path: '/wordList.html',
                name: 'wordList',
                meta: {
                    title: 'Word List',
                    author: 'WY'
                },
                component: (resolve) => {
                    require.ensure([], () => {
                        return resolve(require('./views/wordList/wordList.vue'))
                    }, 'wordList/wordList')
                }
            },
            {
                path: '/flashCard.html',
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
                path: '/msgCenter.html',
                name: 'msgCenter',
                meta: {
                    title: '消息中心',
                    author: 'luohao'
                },
                component: (resolve) => {
                    require.ensure([], () => {
                        return resolve(require('./views/msgCenter/msgCenter.vue'))
                    }, 'msgCenter/msgCenter')
                }
            },
            {
                path: '/orderCenter.html',
                name: 'orderCenter',
                meta: {
                    title: '订单管理',
                    author: 'luohao'
                },
                component: (resolve) => {
                    require.ensure([], () => {
                        return resolve(require('./views/orderCenter/orderCenter.vue'))
                    }, 'orderCenter/orderCenter')
                }
            }
        ]
    }
]