package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.eniac.escola.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Usuario usuario;

		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
