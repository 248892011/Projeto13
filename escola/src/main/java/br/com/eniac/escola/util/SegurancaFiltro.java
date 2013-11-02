package br.com.eniac.escola.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SegurancaFiltro implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession sessao = ((HttpServletRequest) request).getSession();
		
		//tenta capturar a sessao chamada user
		String logado = (String)sessao.getAttribute("user");
		
		//verifica se a sessao existe
		if(logado != null){
			chain.doFilter(request, response);
		}
		else{
			//envia uma mensagem caso o usuario
			//nao tenha se logado
			sessao.setAttribute("msg", "Entre com o usuário e a senha");
			
			//redireciona para a pagina de login
			((HttpServletResponse)response).sendRedirect("login.jsf");		
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
