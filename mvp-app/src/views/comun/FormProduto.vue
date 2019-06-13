<template>
    <div>
        <form>
            <v-flex xs12 sm12>
                <v-text-field
                        v-model="produto.nome"
                        v-validate="'required|max:25'"
                        :counter="25"
                        :error-messages="errors.collect('nome')"
                        label="Nome"
                        data-vv-name="nome"/>
            </v-flex>
            <v-layout wrap>
                <v-flex xs12 sm6>
                    <v-select
                            class="teste-2"
                            v-model="produto.quantidade"
                            v-validate="'required'"
                            :items="items"
                            :error-messages="errors.collect('quantidade')"
                            label="Quantidade"
                            data-vv-name="quantidade"/>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            class="teste"
                            v-model="produto.preco"
                            v-validate="'required'"
                            :error-messages="errors.collect('preço')"
                            label="Preço (R$)"
                            type="number"
                            data-vv-name="preço"/>
                </v-flex>
            </v-layout>
            <v-flex xs12 sm12>
                <v-textarea
                        v-model="produto.descricao"
                        v-validate="'required|max:25'"
                        :counter="25"
                        :error-messages="errors.collect('descrição')"
                        name="input-7-1"
                        label="Descrição"
                        data-vv-name="descrição"/>
            </v-flex>
            <v-flex xs12 sm12>
                <v-checkbox
                        v-model="checkbox"
                        value="1"
                        label="Produto Ativo?"
                        data-vv-name="checkbox"
                        type="checkbox"/>
            </v-flex>
            <v-btn color="success" @click="salvar">enviar</v-btn>
            <v-btn @click="clear">limpar</v-btn>
        </form>
    </div>
</template>

<script>

    export default {
        data: () => ({
            id: '',
            nome: '',
            select: null,
            preco: '',
            descricao: '',
            items: [
                1,
                2,
                3,
                4,
                5
            ],
            checkbox: null
        }),
        props: {
            produto: {
                required: true
            }
        },
        methods: {
            salvar() {
                this.$validator.validateAll().then(result => {
                    if (result) {
                        this.$emit('salvar')
                    }
                })
            },
            clear(){
                this.$emit('limpar')
            }
        }
    }
</script>

<style>

</style>