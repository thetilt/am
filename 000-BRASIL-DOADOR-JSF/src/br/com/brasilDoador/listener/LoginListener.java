package br.com.brasilDoador.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class LoginListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		FacesContext context = arg0.getFacesContext();
		
		//Verifica a p�gina que o usu�rio vai acessar
		String pagina = context.getViewRoot().getViewId();
		//if (pagina.contains("cadastro-usuario")) return;
			
		
		//Recuperar a sess�o do usu�rio
		HttpSession sessao = (HttpSession) context
				.getExternalContext().getSession(false);
		
		//Validar a sess�o do usu�rio
		if (sessao == null || sessao.getAttribute("usuario") == null){
			//Redirecionar para a tela de login
			NavigationHandler navegacao = context
					.getApplication().getNavigationHandler();
			navegacao.handleNavigation(context, null, "login");
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
