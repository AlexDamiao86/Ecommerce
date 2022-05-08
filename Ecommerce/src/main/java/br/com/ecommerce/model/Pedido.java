package br.com.ecommerce.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private Date data_pedido;
	private BigDecimal valor_total;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "codigoPedido_FK")
	private Set<ItemPedido> itemPedidos = new LinkedHashSet<ItemPedido>();
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "IdEndereco_FK")
	private Endereco enderecoEntrega;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "codigo_cliente_FK",referencedColumnName = "codigo", nullable=false)
	private Cliente cliente;
	
	private EstadoPedido estado;
	
	public Pedido() {
		
	}
	public Pedido(Integer codigo, Date data_pedido, Cliente cliente,Endereco endereco_entrega, Set<ItemPedido> itemPedido, EstadoPedido estado) {
		super();
		this.codigo = codigo;
		this.data_pedido = data_pedido;
		this.setItemPedidos(itemPedido);
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	public void adicionarItem(ItemPedido item) {
		BigDecimal quantidade = new BigDecimal(item.getQuantidade());
		this.valor_total = this.valor_total.add(item.getValor().multiply(quantidade));
	}
	
	
	public Set<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}
	
	public void setItemPedidos(Set<ItemPedido> itemPedido) {
		this.itemPedidos = itemPedido;
	}
	
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}
	
	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

