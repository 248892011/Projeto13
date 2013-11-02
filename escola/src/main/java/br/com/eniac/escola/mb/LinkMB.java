package br.com.eniac.escola.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * @author Ernande Linhares -> http://htmlcode.com.br/
 * */
@ManagedBean
@SessionScoped
public class LinkMB {
	
	public String linkUsuario(){
		return "usuario?faces-redirect=true";
	}
	
	public String listaLinkUsuario(){
		return "listaUsuario?faces-redirect=true";
	}
	
	public String linkProduto(){
		return "produto?faces-redirect=true";
	}
	
	public String listaLinkProduto(){
		return "listaProduto?faces-redirect=true";
	}
	
	public String linkCategoria(){
		return "categoria?faces-redirect=true";
	}
	
	public String listaLinkCategoria(){
		return "listaCategoria?faces-redirect=true";
	}
	
	public String listaLinkPesquisa(){
		return "listaPesquisa?faces-redirect=true";
	}
	
	public String detalhe(){
		return "detalhe?faces-redirect=true";
	}
	
}