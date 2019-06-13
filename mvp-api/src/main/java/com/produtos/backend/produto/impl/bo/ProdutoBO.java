package com.produtos.backend.produto.impl.bo;

import com.produtos.backend.produto.impl.repository.ProdutoRepository;
import com.produtos.backend.produto.spec.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoBO {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void atualizarProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll(Sort.by("nome").ascending());
    }

    public Produto buscarProdutoPorId(Integer id){
        return produtoRepository.findById(id);
    }

    public void inserirProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public void removerProduto(Produto produto){ produtoRepository.delete(produto); }
}
