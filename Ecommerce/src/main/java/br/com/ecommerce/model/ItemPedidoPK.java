package br.com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class ItemPedidoPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codigoItemPedido;
	@Column
	private Integer codigoPedido;
	@Column
	private Integer codigoProduto;
	
	public ItemPedidoPK() {};
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
