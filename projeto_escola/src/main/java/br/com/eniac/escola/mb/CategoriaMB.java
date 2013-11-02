package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.eniac.escola.model.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Categoria categoria;	
	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
