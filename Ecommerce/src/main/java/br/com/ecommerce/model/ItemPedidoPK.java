package br.com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class ItemPedidoPK implements Serializable{

	private static final long serialVersionUID = 1L;
	//@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_ITEM_PED")
	private Integer codigoItemPedido;
	@Column(name = "CD_PED")
	private Integer codigoPedido;
	@Column(name = "CD_PRD")
	private Integer codigoProduto;
	
	public ItemPedidoPK(Integer codigoPedido, Integer codigoProduto) {
		this.codigoPedido = codigoPedido;
		this.codigoProduto = codigoProduto;
	}

	public Integer getcodigoItemPedido() {
		return this.codigoItemPedido;
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
