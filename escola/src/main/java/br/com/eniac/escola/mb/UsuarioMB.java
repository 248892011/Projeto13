package br.com.eniac.escola.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.eniac.escola.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {
	
	private Usuario usuario;

			
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
