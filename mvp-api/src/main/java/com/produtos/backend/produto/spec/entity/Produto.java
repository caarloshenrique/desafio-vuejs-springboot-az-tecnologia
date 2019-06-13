package com.produtos.backend.produto.spec.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="TB_PRODUTO")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PR_ID")
	private Integer id;

	@Column(name = "PR_NOME", nullable = false)
	private String nome;

	@Column(name = "PR_QUANTIDADE", nullable = false)
	private BigDecimal quantidade;

	@Column(name = "PR_PRECO", nullable = false)
	private BigDecimal preco;

	@Column(name = "PR_DESCRICAO", nullable = false)
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
