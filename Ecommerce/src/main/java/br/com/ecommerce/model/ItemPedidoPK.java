package br.com.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemPedidoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column
	Integer codigoItemPedidoPK;
	@Column
	Integer codigoPedidoPK;
	@Column
	Integer codigoProdutoPK;
	
	public ItemPedidoPK() {};
	public ItemPedidoPK(Integer codigoItemPedido, Integer codigoPedido, Integer codigoProduto) {
		this.codigoItemPedidoPK = codigoItemPedido;
		this.codigoPedidoPK = codigoPedido;
		this.codigoProdutoPK = codigoProduto;
	}

	public Integer getcodigoItemPedido() {
		return this.codigoItemPedidoPK;
	}
	public Integer getCodigoPedido() {
		return codigoPedidoPK;
	}
	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedidoPK = codigoPedido;
	}
	public Integer getCodigoProduto() {
		return codigoProdutoPK;
	}
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProdutoPK = codigoProduto;
	}
	
	
	@Override
   public boolean equals(Object o) {
       if ( this == o ) {
           return true;
       }
       if ( o == null || getClass() != o.getClass() ) {
           return false;
       }
       ItemPedidoPK that = (ItemPedidoPK) o;
       return Objects.equals( codigoItemPedidoPK, that.codigoItemPedidoPK ) &&
               Objects.equals( codigoProdutoPK, that.codigoProdutoPK ) &&
               Objects.equals(codigoPedidoPK, that.codigoPedidoPK);
   }

   @Override
   public int hashCode() {
       return Objects.hash( codigoItemPedidoPK, codigoProdutoPK, codigoPedidoPK );
   }
}
