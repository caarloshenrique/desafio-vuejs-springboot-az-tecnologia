package com.produtos.backend.produto.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.backend.produto.spec.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    Produto findById(Integer produtoDTOId);
}
