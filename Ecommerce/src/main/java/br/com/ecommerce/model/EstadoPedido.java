package br.com.ecommerce.model;

public enum EstadoPedido {
		EM_ANDAMENTO("Em andamento"),
		PENDENTE_PAGAMENTO("Pendente de pagamento"),
		PENDENTE_ENTREGA("Pendente de entrega"),
		ENTREGUE("Entregue"),
		DEVOLVIDO("Devolvido"),
		CANCELADO("Cancelado");	

		private String descricao;
		
	 	EstadoPedido(String descricao){
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

}
