package br.com.eniac.escola.util;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.eniac.escola.controller.AdminController;

public class ForcarLoginPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	public void afterPhase(PhaseEvent event) {
	}
	
	//executa antes de qualquer renderizar ao usu�rio
	public void beforePhase(PhaseEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		String viewId = context.getViewRoot().getViewId();
		System.out.println("View ID:" + viewId);
		
		//verifica as p�ginas que n�o possuem acesso externo
		if (viewId.equals("/admin/formCategoria.xhtml") ||
				viewId.equals("/admin/formProduto.xhtml") ||	
				viewId.equals("/admin/home.xhtml") ||
				viewId.equals("/admin/mostrarCategorias.xhtml") ||
				viewId.equals("/admin/mostrarProdutos.xhtml") ||
				viewId.equals("/admin/mostrarCompras.xhtml")
		) {
			
			// recupera os dados que est�o em 
			//sessao em adminController
			Application app = context.getApplication();
			AdminController adminEmSessao = (AdminController) app
			.evaluateExpressionGet(context, 
					"#{adminController}", AdminController.class);
			
		
			//se nao houver administrador logado
			if (adminEmSessao.getAdmin().getId() == null) {
				
				//armazena a pagina ao qual o usuario esta
				//tentando entrar em sessao
				//atraves da classe AdminController
				adminEmSessao.setOriginalViewId(viewId);
				//em seguida, cria a arvore de componentes
				//para a pagina admin.jsf
				//que exigira o login e senha
				ViewHandler viewHandler = app.getViewHandler();
				UIViewRoot viewRoot = viewHandler.createView(context,
						"/admin/admin.xhtml");
				context.setViewRoot(viewRoot);
			}
		}
	}
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
}
