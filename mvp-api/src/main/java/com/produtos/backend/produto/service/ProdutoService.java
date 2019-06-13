package com.produtos.backend.produto.service;

import com.produtos.backend.produto.spec.IProduto;
import com.produtos.backend.produto.spec.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoService {

    @Autowired
    private IProduto iProduto;

    @CrossOrigin
    @PutMapping("/produtos")
    public void atualizarProduto(@RequestBody ProdutoDTO produtoDTO) { iProduto.atualizarProduto(produtoDTO); }

    @CrossOrigin
    @GetMapping("/produtos")
    public List<ProdutoDTO> buscarProdutos() {
        return iProduto.buscarProdutos();
    }

    @CrossOrigin
    @PostMapping("/produtos")
    public void inserirProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        iProduto.inserirProduto(produtoDTO);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/produtos/{produtoId}")
    public void removerProduto(@PathVariable("produtoId") Integer produtoId) {
        iProduto.removerProduto(produtoId);
    }
}