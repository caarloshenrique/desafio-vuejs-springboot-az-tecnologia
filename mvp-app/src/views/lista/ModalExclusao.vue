<template>
    <v-dialog v-model="abrirModal" persistent max-width="500">
        <v-card>
            <v-card-title class="headline">Tem certeza que deseja excluir esse produto?</v-card-title>
            <v-list class="espaco">
                <v-list-tile class="espaco-content">
                    <v-list-tile-action>
                        <v-icon color="indigo">local_offer</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>{{produto.nome}}</v-list-tile-title>
                        <v-list-tile-sub-title>Nome</v-list-tile-sub-title>
                    </v-list-tile-content>
                </v-list-tile>
                <v-divider></v-divider>
                <v-list-tile class="espaco-content">
                    <v-list-tile-action>
                        <v-icon color="indigo">style</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>{{produto.quantidade}}</v-list-tile-title>
                        <v-list-tile-sub-title>Quantidade</v-list-tile-sub-title>
                    </v-list-tile-content>
                </v-list-tile>
                <v-divider></v-divider>
                <v-list-tile class="espaco-content">
                    <v-list-tile-action>
                        <v-icon color="indigo">attach_money</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>R$ {{produto.preco}}</v-list-tile-title>
                        <v-list-tile-sub-title>Preço</v-list-tile-sub-title>
                    </v-list-tile-content>
                </v-list-tile>
                <v-divider></v-divider>
                <v-list-tile class="espaco-content">
                    <v-list-tile-action>
                        <v-icon color="indigo">description</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title> {{produto.descricao}} </v-list-tile-title>
                        <v-list-tile-sub-title>Descrição</v-list-tile-sub-title>
                    </v-list-tile-content>
                </v-list-tile>
                <v-divider></v-divider>
                <v-list-tile class="espaco-content">
                    <v-list-tile-action>
                        <v-icon color="indigo">check_box</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title>Produto Ativo</v-list-tile-title>
                        <v-list-tile-sub-title>Status</v-list-tile-sub-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="red darken-1" flat @click="fecharModal">Cancelar</v-btn>
                <v-btn color="green darken-1" @click="remover" flat>Confirmar</v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>
<script>
    export default {
        data () {
            return {
                modalExclusao: false
            }
        },
        props: {
            abrirModal: {
                required: true
            },
            produto: {
                required: true
            }
        },
        mounted() {
            this.verificarModal()
            this.verificarProdutos()
        },
        methods: {
            fecharModal() {
                this.$emit('fecharModalExclusao')
            },
            remover(){
                this.$emit('remover', this.produto.id)
            },
            verificarProdutos(){
                if (this.item){
                    this.produto = this.item
                }
            },
            verificarModal(){
                this.abrirModal = this.modalExclusao
            }
        }
    }
</script>

<style lang="stylus">
    .espaco
        padding-right 20px
        padding-left 20px

    .espaco-content
        padding 5px

</style>