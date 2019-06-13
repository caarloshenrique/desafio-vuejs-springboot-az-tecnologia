package com.produtos.backend.produto.impl.usecase;

import com.produtos.backend.produto.impl.bo.ProdutoBO;
import com.produtos.backend.produto.spec.dto.ProdutoDTO;
import com.produtos.backend.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InserirProduto {

    @Autowired
    private ProdutoBO produtoBO;

    public void inserirProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        preencherproduto(produto, produtoDTO);
        produtoBO.inserirProduto(produto);
    }

    public static void preencherproduto(Produto produto, ProdutoDTO produtoDTO){
        produto.setNome(produtoDTO.getNome());
        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setPreco(produtoDTO.getPreco());
        produto.setDescricao(produtoDTO.getDescricao());
    }
}
