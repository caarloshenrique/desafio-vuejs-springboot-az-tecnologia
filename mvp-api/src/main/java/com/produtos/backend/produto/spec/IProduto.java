package com.produtos.backend.produto.spec;

import com.produtos.backend.produto.spec.dto.ProdutoDTO;

import java.util.List;

public interface IProduto {
    List<ProdutoDTO> buscarProdutos();

    void removerProduto(Integer produtoId);

    void inserirProduto(ProdutoDTO produtoDTO);

    void atualizarProduto(ProdutoDTO produtoDTO);
}
