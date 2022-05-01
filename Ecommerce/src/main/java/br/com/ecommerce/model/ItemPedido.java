package br.com.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="item_pedido")
@IdClass(ItemPedidoPK.class)
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Seq_IP")
	@Column
	private Integer codigoItemPedidoPK;
	
	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "codigoProdutoPK",referencedColumnName = "codigo", insertable = false, updatable = false)
	private Produto produto;
	
	@Id
	@JsonManagedReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "codigoPedidoPK", referencedColumnName = "codigo", insertable = false, updatable = false)
	private Pedido pedido;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false, precision = 7, scale = 2)
	BigDecimal valor;

	// Construtores
	public ItemPedido() {};
	public ItemPedido(Produto produto, Pedido pedido, Integer quantidade) {
		setProduto(produto);
		this.valor = produto.getPreco();
		setQuantidade(quantidade);
		setPedido(pedido);
//		this.pedido.vinculaItemPedido(this);
	}
	
	// Getters and Setters
	public Integer getCodigoItemPedidoPK() {
		return codigoItemPedidoPK;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	//@JsonIgnore
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
	
	@Override
	public String toString() {
	return "\nItemPedido (codigo: " + codigoItemPedidoPK + 
			", Produto: " + this.getProduto().getNome() +
			", Pedido: " + this.getPedido().getCodigo() +
			", Quantidade: " + this.getQuantidade() + 
			", Valor: " + this.getValor() + ")";
	}
}
