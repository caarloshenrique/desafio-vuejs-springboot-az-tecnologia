package com.produtos.backend.produto.impl.usecase;

import com.produtos.backend.produto.impl.bo.ProdutoBO;
import com.produtos.backend.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoverProduto {

    @Autowired
    private ProdutoBO produtoBO;

    public void removerProduto(Integer produtoId){
        Produto produto = produtoBO.buscarProdutoPorId(produtoId);
        produtoBO.removerProduto(produto);
    }
}
