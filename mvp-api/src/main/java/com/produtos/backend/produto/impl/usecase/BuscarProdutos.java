package com.produtos.backend.produto.impl.usecase;

import com.produtos.backend.produto.impl.bo.ProdutoBO;
import com.produtos.backend.produto.spec.dto.ProdutoDTO;
import com.produtos.backend.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuscarProdutos {

    @Autowired
    private ProdutoBO produtoBO;

    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = produtoBO.buscarProdutos();
        return converterProdutoParaDTO(produtos);
    }

    private List<ProdutoDTO> converterProdutoParaDTO(List<Produto> produtos) {
        List<ProdutoDTO> produtoDTO = new ArrayList<>();
        produtos.forEach(produto -> produtoDTO.add(montarProdutoDTO(produto)));
        return produtoDTO;
    }

    private static ProdutoDTO montarProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO(produto);
        return produtoDTO;
    }
}
