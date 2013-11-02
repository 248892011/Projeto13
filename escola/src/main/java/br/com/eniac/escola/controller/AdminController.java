package br.com.eniac.escola.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.eniac.escola.dao.DaoGenerico;
import br.com.eniac.escola.model.Admin;
import br.com.eniac.escola.util.FacesUtils;

@Controller("adminController")
@Scope("session")
public class AdminController {

	private Admin admin;

	private String originalViewId;

	@Resource
	private  DaoGenerico<Admin, Integer> adminDao;


	public AdminController(){
		admin = new Admin();
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	//pega a viewid
	public String getOriginalViewId() {
		String temp = originalViewId;
		originalViewId = null;
		return temp;
	}

	public void setOriginalViewId(String originalViewId) {
		this.originalViewId = originalViewId;
	}


	//verifica a existência do administrador e o retorna
	private Admin verificaAdmin(String usuario){
		String query = "SELECT a FROM Admin a WHERE a.usuario=:usuario";
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("usuario", usuario);    	
		return adminDao.pesqParam(query , params);

	}


	//executa o login no sistema
	//direcionando o usuário ao local indicado
	public String login() {

		Admin a = verificaAdmin(admin.getUsuario());
		//verifica se a senha resultante é 
		//igual a senha encontrada no banco de dados
		if (a != null && a.getSenha().equals(admin.getSenha())) {

			//deixa o objeto usuario agora com os 
			//valores encontrados no banco
			setAdmin(a);

			//caso não seja nulo
			//redireciona onde o usuário tentou entrar
			//via URL
			if (originalViewId != null) {
				FacesContext context = FacesContext.getCurrentInstance();
				ViewHandler viewHandler = 
					context.getApplication().getViewHandler();
				UIViewRoot viewRoot = 
					viewHandler.createView(context,originalViewId);
				context.setViewRoot(viewRoot);
				return null;
			}           

			//redireciona para a área do usuário 
			return "autorizado";

		} else {
			FacesUtils.mensErro("Problema encontrado no usuário ou senha");
		}

		return null;

	}


	//sai da área administrativa
	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Object session = externalContext.getSession(false);
		HttpSession httpSession = (HttpSession) session;
		httpSession.invalidate();
		return null;

	}



}