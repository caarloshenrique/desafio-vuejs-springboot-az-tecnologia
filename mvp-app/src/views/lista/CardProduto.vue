<template>
    <div>
        <v-layout align-center justify-center row reverse wrap fill-height>
            <v-spacer></v-spacer>
            <v-flex xs12 sm6 md4 v-for="produto of produtos" :key="produto.id">
                <v-container fluid grid-list-md>
                    <v-hover>
                        <v-card class="responsivo" slot-scope="{ hover }">
                            <v-img src="https://www.hypeness.com.br/wp-content/uploads/2018/11/charles-eames-tokstok-2.png" height="300px">
                                <v-expand-transition>
                                    <div
                                            v-if="hover"
                                            class="d-flex transition-fast-in-fast-out indigo darken-1 v-card--reveal display-3 white--text"
                                            style="height: 100%;"
                                    >
                                    </div>
                                </v-expand-transition>
                                <v-layout column fill-height>
                                    <v-card-title>
                                        <v-btn dark icon>
                                            <v-icon>expand_more</v-icon>
                                        </v-btn>
                                        <v-spacer></v-spacer>
                                        <v-btn @click="abrirModalEdicao(produto)" dark icon>
                                            <v-icon>edit</v-icon>
                                        </v-btn>
                                        <v-btn @click="abrirModalExclusao(produto)" dark icon>
                                            <v-icon>delete</v-icon>
                                        </v-btn>
                                    </v-card-title>
                                    <v-spacer></v-spacer>
                                    <v-card-title class="white--text pl-5 pt-5">
                                        <div class="transpor-nome-produto display-1">{{ produto.nome }}</div>
                                    </v-card-title>
                                </v-layout>
                            </v-img>
                            <v-list two-line class="espacamento">
                                <v-list-tile>
                                    <v-list-tile-action>
                                        <v-icon color="indigo">style</v-icon>
                                    </v-list-tile-action>
                                    <v-list-tile-content>
                                        <v-list-tile-title>Estoque Atual: {{ produto.quantidade }}</v-list-tile-title>
                                    </v-list-tile-content>
                                </v-list-tile>
                                <v-divider></v-divider>
                                <v-list-tile>
                                    <v-list-tile-action>
                                        <v-icon color="indigo">attach_money</v-icon>
                                    </v-list-tile-action>
                                    <v-list-tile-content>
                                        <v-list-tile-title>Preço de Venda: R${{ produto.preco }}</v-list-tile-title>
                                    </v-list-tile-content>
                                </v-list-tile>
                                <v-divider></v-divider>
                                <v-list-tile>
                                    <v-list-tile-action>
                                        <v-icon color="indigo">description</v-icon>
                                    </v-list-tile-action>
                                    <v-list-tile-content>
                                        <v-list-tile-title>Descrição: </v-list-tile-title>
                                        <v-list-tile-title>{{ produto.descricao }}</v-list-tile-title>
                                    </v-list-tile-content>
                                </v-list-tile>
                                <v-divider></v-divider>
                                <v-list-tile>
                                    <v-list-tile-action>
                                        <v-icon color="indigo">check_box</v-icon>
                                    </v-list-tile-action>
                                    <v-list-tile-content>
                                        <v-list-tile-title>Status: Produto Ativo</v-list-tile-title>
                                    </v-list-tile-content>
                                </v-list-tile>
                            </v-list>
                        </v-card>
                    </v-hover>
                </v-container>
            </v-flex>
        </v-layout>
    </div>
</template>

<script>
    import _ from 'lodash'

    export default {
        name: 'card-produto',
        props: {
            produtos: {
                type: Array,
                required: false,
                default: () => []
            }
        },
        data(){
            return {
                modalEdicao: false
            }
        },
        methods: {
            abrirModalEdicao(produto) {
                const produtoClonado = this.getProdutoEdicao(produto)
                this.$emit('abrirModalEdicao', produtoClonado)
            },
            abrirModalExclusao(produto){
                this.$emit('abrirModalExclusao', produto)
            },
            getProdutoEdicao(produto) {
                return _.cloneDeep(produto)
            }
        }
    };
</script>

<style lang="stylus">
    .v-sheet
        border-radius 10px

    .v-card--reveal
        align-items center
        bottom 0
        justify-content center
        opacity .7
        position: absolute
        width 100%

    .transpor-nome-produto
        z-index 1

    .espacamento
        padding-right 14px
        padding-left 14px
        padding-top 0px
        padding-bottom 0px
</style>
