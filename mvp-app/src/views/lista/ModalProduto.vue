<template>
    <v-layout row justify-center>
        <v-dialog v-model="abrirModal" persistent max-width="600px">
            <v-card>
                <v-card-title>
                    <span class="headline">Edição de Produto</span>
                    <v-spacer></v-spacer>
                    <v-btn icon @click="submit">
                        <v-icon>close</v-icon>
                    </v-btn>
                </v-card-title>
                <v-container grid-list-md>
                    <v-card-text>
                        <Form :produto="produto" @salvar="atualizar(produto)" @limpar="limparCampos"/>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                    </v-card-actions>
                </v-container>
            </v-card>
        </v-dialog>
    </v-layout>
</template>

<script>
    import Form from '../comun/FormProduto'

    export default {
        name: "ModalProduto",
        components: {Form},
        data() {
            return {
                modalEdicao: false
            }
        },
        props: {
            produto: {
                required: true
            },
            abrirModal: {
                required: true
            }
        },
        mounted() {
            this.verificarModal()
            this.verificarProdutos()
        },
        methods: {
            atualizar(produto) {
                this.produto = produto
                this.$emit('atualizarProduto', this.produto)
            },
            clear() {
                this.produto.nome = ''
                this.produto.quantidade = null
                this.produto.preco = ''
                this.produto.descricao = ''
                this.$validator.reset()
            },
            fecharModal() {
                this.$emit('fecharModalEdicao')
            },
            limparCampos(){
                this.$emit('limparCampos', this.produto)
            },
            submit() {
                this.$validator.validateAll().then(result => {
                    if (result) {
                        this.fecharModal()
                    }
                })
            },
            verificarModal(){
                this.abrirModal = this.modalEdicao
            },
            verificarProdutos() {
                if (this.item) {
                    this.produto = this.item
                }
            }
        }
    }
</script>

<style>

</style>

