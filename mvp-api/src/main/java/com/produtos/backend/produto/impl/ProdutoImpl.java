package com.produtos.backend.produto.impl;

import com.produtos.backend.produto.impl.usecase.AtualizarProduto;
import com.produtos.backend.produto.impl.usecase.BuscarProdutos;
import com.produtos.backend.produto.impl.usecase.InserirProduto;
import com.produtos.backend.produto.impl.usecase.RemoverProduto;
import com.produtos.backend.produto.spec.IProduto;
import com.produtos.backend.produto.spec.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoImpl implements IProduto {

    @Autowired
    private AtualizarProduto atualizarProduto;

    @Autowired
    private BuscarProdutos buscarProdutos;

    @Autowired
    private InserirProduto inserirProduto;

    @Autowired
    private RemoverProduto removerProduto;

    @Override
    public void atualizarProduto(ProdutoDTO produtoDTO){
        atualizarProduto.atualizarProduto(produtoDTO);
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        return buscarProdutos.buscarProdutos();
    }

    @Override
    public void inserirProduto(ProdutoDTO produtoDTO) {
        inserirProduto.inserirProduto(produtoDTO);
    }

    @Override
    public void removerProduto(Integer produtoId) {
        removerProduto.removerProduto(produtoId);
    }

}
