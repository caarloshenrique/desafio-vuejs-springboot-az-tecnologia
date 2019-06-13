import Vue from 'vue'
import Router from 'vue-router'

import ListaProdutos from './views/lista/ListaProdutos'
import CadastroProdutos from './views/cadastro/CadastroProdutos'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            component: ListaProdutos
        },
        {
            path: '/cadastro',
            component: CadastroProdutos
        }
    ]
})
