package br.com.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_PEDIDO")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK itemPedidoPK;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codigoItemPedido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "codigoProduto",referencedColumnName = "codigo", insertable = false, updatable = false)
	private Produto produto;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "codigoPedido", referencedColumnName = "codigo", insertable = false, updatable = false)
	private Pedido pedido;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false, precision = 7, scale = 2)
	BigDecimal valor;

	// Construtores
	public ItemPedido() {};
	public ItemPedido(Produto produto, Pedido pedido, Integer quantidade) {
		this.itemPedidoPK = new ItemPedidoPK(this.codigoItemPedido, pedido.getCodigo(), produto.getCodigo());
		setProduto(produto);
//		this.produto.vinculaItemPedido(this);
		this.valor = produto.getPreco();
		setQuantidade(quantidade);
		setPedido(pedido);
//		this.pedido.vinculaItemPedido(this);
	}
	
	// Getters and Setters
	public Integer getCodigoItemPedido() {
		return codigoItemPedido;
	}
	
	public ItemPedidoPK getItemPedidoPK() {
		return itemPedidoPK;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produtos) {
		this.produto = produtos;
//		this.produto.getItemPedidos().add(this);
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
//		this.pedido.getItemPedido().add(this);
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		int disponivel = this.produto.getQuantidade_estoque();
		
		if (disponivel < 1) {
			System.out.println("*** NÃO HÁ ESTOQUE DISPONÍVEL PARA ESTE PRODUTO ***");
			this.quantidade = 0;
		} else if (quantidade <= disponivel) {
			this.quantidade = quantidade;
			this.produto.setQuantidade_estoque(disponivel - quantidade);
		} else {
			this.quantidade = disponivel;
			this.produto.setQuantidade_estoque(0);
		}
		
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}	
}
