package br.edu.uerr.fruta.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compras")
public class Compras implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="fornecedor_id")
	private Integer fornecedor_id;
	@Column(name="produtos_id")
	private Integer produtos_id;
	private String quantidade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(Integer fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
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
	
}
	