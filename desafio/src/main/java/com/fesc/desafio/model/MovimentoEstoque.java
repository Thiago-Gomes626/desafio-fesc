package com.fesc.desafio.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimentoestoque")
public class MovimentoEstoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codprod")
	private Produto produto;
	
	@Column
	private String tipo;
	
	@Column
	private Double valorvenda;
	
	@Column
	private Date datavenda;
	
	@Column
	private Integer qntmovimentada;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValorVenda() {
		return valorvenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorvenda = valorVenda;
	}

	public Date getDataVenda() {
		return datavenda;
	}

	public void setDataVenda(Date datavenda) {
		this.datavenda = datavenda;
	}

	public Integer getQntMovimentada() {
		return qntmovimentada;
	}

	public void setQntMovimentada(Integer qntMovimentada) {
		this.qntmovimentada = qntMovimentada;
	}
	
	
	
}
