package br.com.eniac.escola.mb;

import javax.faces.bean.ManagedBean;

import br.com.eniac.escola.model.Categoria;

@ManagedBean

public class CategoriaMB {
	
	private Categoria categoria;

		
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
