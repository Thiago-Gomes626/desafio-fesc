package com.fesc.desafio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private String descricao;
	
	@OneToMany(mappedBy = "produto")
	@JsonIgnore
	private List<MovimentoEstoque> movimentoList;
	
	@Column
	private String tipo;
	
	@Column
	private Double valorforn;
	
	@Column
	private Integer estoque;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<MovimentoEstoque> getMovimentoList() {
		return movimentoList;
	}

	public void setMovimentoList(List<MovimentoEstoque> movimentoList) {
		this.movimentoList = movimentoList;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValorForn() {
		return valorforn;
	}

	public void setValorForn(Double valorForn) {
		this.valorforn = valorForn;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	
	
}
