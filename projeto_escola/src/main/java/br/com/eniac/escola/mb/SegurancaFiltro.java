package br.com.eniac.escola.mb;

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

import br.com.eniac.escola.model.Usuario;

public class SegurancaFiltro implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request	= (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		final HttpSession session = request.getSession(false);
		final boolean telaLogin = (request.getRequestURI().contains("login.jsf"));
		Usuario usuario = null;
		try {
			usuario = (Usuario)session.getAttribute("usuario");
		} catch (Exception e) {
			usuario = null;
		}
		if(usuario==null && !telaLogin) {
			if (session!=null) {
				session.invalidate();
			}
			response.sendRedirect(request.getContextPath());
		} else{
			chain.doFilter(request,response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {}
}
