import axios from 'axios'
import {actionTypes} from '../constants'

const http = axios.create({
    baseURL: 'http://localhost:8081/api/'
})

export default {
    async [actionTypes.ATUALIZAR_PRODUTO](context, produto){
        return await http.put('produtos', produto)
    },

    async [actionTypes.BUSCAR_PRODUTOS](){
        const {data} = await http.get('produtos')
        return data
    },

    async [actionTypes.INSERIR_PRODUTO](context, {produto}){
        return await http.post('produtos', produto)
    },

    async [actionTypes.REMOVER_PRODUTO](context, {produtoId}){
        return await http.delete(`produtos/${produtoId}`)
    }
}