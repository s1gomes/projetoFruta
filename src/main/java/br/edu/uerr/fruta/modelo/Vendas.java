package br.edu.uerr.fruta.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendas")
public class Vendas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="cliente_id")
	private Integer cliente_id;
	@Column(name="produtos_id")
	private Integer produtos_id;
	private String quantidade;
	private Double valor_unitario;
	private Integer forma_pagamento;
	private Date nascimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Integer getProdutos_id() {
		return produtos_id;
	}
	public void setProdutos_id(Integer produtos_id) {
		this.produtos_id = produtos_id;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public Integer getForma_pagamento() {
		return forma_pagamento;
	}
	public void setForma_pagamento(Integer forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

}