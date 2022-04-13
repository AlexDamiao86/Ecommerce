package br.com.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_PEDIDO")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQITEMPED")
	private Integer codigoItemPedido;
	
	@EmbeddedId
	private ItemPedidoPK itemPedidoPK;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_produto_fk",referencedColumnName = "codigo")
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_pedido_fk", referencedColumnName = "codigo")
	private Pedido pedido;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false, precision = 7, scale = 2)
	BigDecimal valor;

	// Construtores
	public ItemPedido() {};
	public ItemPedido(Produto produto, Pedido pedido, Integer quantidade, BigDecimal valor) {
		super();
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.valor = valor;
		this.itemPedidoPK = new ItemPedidoPK(pedido.getCodigo(), produto.getCodigo());
	}
	
	
	public Integer getCodigoItemPedido() {
		return codigoItemPedido;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produtos) {
		this.produto = produtos;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
