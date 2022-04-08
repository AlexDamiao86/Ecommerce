package br.com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemPedidoPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "CD_PED")
	private Integer codigoPedido;
	@Column(name = "CD_PRD")
	private Integer codigoProduto;
	
	public ItemPedidoPK(Integer codigoPedido, Integer codigoProduto) {
		this.codigoPedido = codigoPedido;
		this.codigoProduto = codigoProduto;
	}

	public Integer getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Integer getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
}
