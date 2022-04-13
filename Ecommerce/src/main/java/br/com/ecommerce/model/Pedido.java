package br.com.ecommerce.model;

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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date data_pedido;
	private BigDecimal valor_total;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
	@JoinColumn(name = "sequencial_endereco_entrega", referencedColumnName = "idEndereco"),
	@JoinColumn(name = "cod_cliente_pk_fk", referencedColumnName = "codCliente")
	})
	private Endereco endereco_entrega;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido")
	private Set<ItemPedido> itemPedido = new LinkedHashSet<ItemPedido>();
	private EstadoPedido estado;
	
	public Pedido(Integer codigo, Date data_pedido, BigDecimal valor_total, Cliente cliente,
			Endereco endereco_entrega, Set<ItemPedido> itemPedido, EstadoPedido estado) {
		super();
		this.codigo = codigo;
		this.data_pedido = data_pedido;
		this.valor_total = valor_total;
		this.cliente = cliente;
		this.endereco_entrega = endereco_entrega;
		this.itemPedido = itemPedido;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco_entrega() {
		return endereco_entrega;
	}

	public void setEndereco_entrega(Endereco endereco_entrega) {
		this.endereco_entrega = endereco_entrega;
	}

	public Set<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(Set<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
}

