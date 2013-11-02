package br.com.eniac.escola.cart;

import br.com.eniac.escola.model.ItensPedido;

/*
 * O Item do carrinho armazena o produto
 * adicionado ao carrinho
 */


public class ItemCarrinho {

	private ItensPedido item;
	
	
	
	public void setItem(ItensPedido item) {
		this.item = item;
	}

	public ItensPedido getItem() {
		return item;
	}

	
	
	
}
