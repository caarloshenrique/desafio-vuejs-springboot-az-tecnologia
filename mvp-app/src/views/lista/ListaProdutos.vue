<template>
    <div>
        <CardProduto :produtos="produtos"
                     @abrirModalEdicao="abrirModalEdicao"
                     @abrirModalExclusao="abrirModalExclusao"/>
        <ModalProduto :abrirModal="modalEdicao"
                      :produto="produto"
                      @fecharModalEdicao="fecharModalEdicao"
                      @limparCampos="limparCampos"
                      @atualizarProduto="atualizarProduto(produto)"/>
        <ModalExclusao :abrirModal="modalExclusao"
                       :produto="produto"
                       @fecharModalExclusao="fecharModalExclusao"
                       @remover="remover"/>
    </div>
</template>

<script>
    import {actionTypes} from "../../commons/constants"
    import CardProduto from './CardProduto'
    import ModalProduto from './ModalProduto'
    import ModalExclusao from './ModalExclusao'

    export default {
        name: "ListaProdutos",
        components: {CardProduto, ModalProduto, ModalExclusao},
        data() {
            return {
                modalEdicao: false,
                modalExclusao: false,
                produtos: [],
                produto: {}
            }
        },
        mounted() {
            this.buscarProdutos()
        },
        methods: {
            abrirModalEdicao(produto) {
                this.modalEdicao = true
                this.produto = produto
            },
            abrirModalExclusao(produto) {
                this.modalExclusao = true
                this.produto = produto
            },
            async atualizarProduto(produto) {
                this.produto = await this.$store.dispatch(actionTypes.ATUALIZAR_PRODUTO, produto)
                this.buscarProdutos()
                this.fecharModalEdicao()
            },
            async buscarProdutos() {
                this.produtos = await this.$store.dispatch(actionTypes.BUSCAR_PRODUTOS)
            },
            fecharModalEdicao() {
                this.modalEdicao = false
            },
            fecharModalExclusao() {
                this.modalExclusao = false
            },
            limparCampos(produto) {
                produto.nome = ''
                produto.quantidade = ''
                produto.preco = null
                produto.descricao = ''
                this.$validator.reset()
            },
            async remover(produtoId) {
                await this.$store.dispatch(actionTypes.REMOVER_PRODUTO, {produtoId})
                this.buscarProdutos()
                this.fecharModalExclusao()
            }
        }
    }
</script>
