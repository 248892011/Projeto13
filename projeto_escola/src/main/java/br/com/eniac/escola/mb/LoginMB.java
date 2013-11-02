package br.com.eniac.escola.mb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.eniac.escola.model.Usuario;

@ManagedBean
@ViewScoped
public class LoginMB implements Serializable{

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	
	public String logar(){
		
		if (getUsuario().getLogin().equals("") || getUsuario().getSenha().equals("")) {
			FacesUtils.mensErro("Login e/ou senha não podem ser vazios");
			return "/pages/login.jsf";
		} else {
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("login", getUsuario().getLogin());
			params.put("senha", getUsuario().getSenha());
			usuario = new Usuario();
			usuario.setLogin(params.get("login").toString());
			usuario.setSenha(params.get("senha").toString());
			usuario.setNome("ADMINISTRADOR");
			if (!usuario.getLogin().equalsIgnoreCase("ADMIN") && !usuario.getSenha().equalsIgnoreCase("manager")){
				usuario = new Usuario();
				FacesUtils.mensErro("Usuário e senha inválidos");
				return "/pages/login.jsf";
			}
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().
					getExternalContext().getSession(false);
			session.setAttribute("usuario", usuario);
			return "/admin/index.jsp?faces-redirect=true";
		}	
	}
	
	public String logout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().
				getExternalContext().getSession(false);
		usuario = new Usuario();
		session.removeAttribute("usuario");
		session.invalidate();
		return "/pages/login.jsf?faces-redirect=true";
	}
	
	//Getters e Setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
