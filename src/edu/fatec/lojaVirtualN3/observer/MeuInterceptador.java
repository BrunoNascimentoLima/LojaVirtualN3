package edu.fatec.lojaVirtualN3.observer;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import edu.fatec.lojaVirtualN3.entidades.Administrador;
import edu.fatec.lojaVirtualN3.managedBeans.AdministradorMB;
import edu.fatec.lojaVirtualN3.managedBeans.UsuarioMB;

public class MeuInterceptador implements PhaseListener {

	private static final long serialVersionUID = -4040778940413271197L;

	@Override
	public void afterPhase(PhaseEvent e) {
		PhaseId fase = e.getPhaseId();

		FacesContext ctx = e.getFacesContext();
		String pagina = ctx.getViewRoot().getViewId();
		UsuarioMB uMB = ctx.getApplication().evaluateExpressionGet(ctx, "#{usuarioMB}",
				UsuarioMB.class);
		System.out.println(uMB.getLogado());

		System.out.println(pagina);
		System.out.println(fase);		
		
		if (pagina.equals("/compra.xhtml") 
				||pagina.equals("/confirmarCompra.xhtml")
				||pagina.equals("/efetuarCompra.xhtml")
				||pagina.equals("/menu.xhtml")
				||pagina.equals("/editarUsuario.xhtml")
				||pagina.equals("/produto.xhtml")
				||pagina.equals("/produtosComprados.xhtml")){
			UsuarioMB userMB = ctx.getApplication().evaluateExpressionGet(ctx, "#{usuarioMB}",
					UsuarioMB.class);
			System.out.println(userMB.getLogado());
			NavigationHandler nav = ctx.getApplication().getNavigationHandler();
			if (userMB.getLogado()!=1) {
				nav.handleNavigation(ctx, null, "login?faces-redirect=true");
				ctx.renderResponse();

			} 
			
		}  else if (pagina.equalsIgnoreCase("/menuAdmin.xhtml")
				||pagina.equalsIgnoreCase("/cadastroProduto.xhtml")
				||pagina.equalsIgnoreCase("/gestaoProduto.xhtml")){
			AdministradorMB admMB = ctx.getApplication().evaluateExpressionGet(ctx,
					"#{administradorMB}", AdministradorMB.class);
			System.out.println(admMB.getLogado());
			NavigationHandler nav = ctx.getApplication().getNavigationHandler();	
			if	(admMB.getLogado() != 2) {
				nav.handleNavigation(ctx, null,
						"loginAdmin?faces-redirect=true");
				ctx.renderResponse();

			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent e) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
