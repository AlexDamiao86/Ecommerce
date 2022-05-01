package br.com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ItemPedidoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	Integer produto;
	Integer pedido;
}
