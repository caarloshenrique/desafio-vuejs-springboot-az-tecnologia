<template>
    <v-layout align-center justify-center row wrap fill-height>
        <v-flex xs12 sm6>
            <v-card>
                <v-card-title primary-title>
                    <div>
                        <h3 class="headline mb-0">Cadastro de Produtos</h3>
                    </div>
                </v-card-title>
                <div>
                    <v-container grid-list-md text-xs-center>
                        <Form :produto="produto" v-model="produto" @salvar="salvar" @limpar="clear"/>
                    </v-container>
                </div>
            </v-card>
        </v-flex>
    </v-layout>
</template>

<script>
    import {actionTypes} from "../../commons/constants"
    import Form from '../comun/FormProduto'

    export default {
        name: "CadastroProdutos",
        components: {Form},
        data(){
            return{
                produto: {
                    nome: '',
                    quantidade: null,
                    preco: '',
                    descricao: ''
                }
            }
        },
        methods: {
            clear() {
                this.produto.nome = ''
                this.produto.quantidade = null
                this.produto.preco = ''
                this.produto.descricao = ''
                this.$validator.reset()
            },
            async salvar() {
                const produto = this.produto
                this.produto = await this.$store.dispatch(actionTypes.INSERIR_PRODUTO, {
                    produto
                })
                alert('Salvo com sucesso!')
                location.reload()
            }
        }
    }
</script>

<style scoped>

</style>