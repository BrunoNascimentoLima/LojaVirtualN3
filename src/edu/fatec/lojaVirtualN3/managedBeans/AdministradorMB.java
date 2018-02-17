package edu.fatec.lojaVirtualN3.managedBeans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.fatec.lojaVirtualN3.dao.FacadeDAO;
import edu.fatec.lojaVirtualN3.entidades.Administrador;

@ManagedBean(name = "administradorMB")
@SessionScoped
public class AdministradorMB implements Serializable {

	private static final long serialVersionUID = -6106281352868457916L;
	private Administrador administrador;
	private FacesContext mensagem;
	private int logado = 0;

	public AdministradorMB() {
		administrador = new Administrador();
	}

	public String logarAdmin() {
		Administrador a;
		FacadeDAO fDAO = new FacadeDAO();
		try {
			a = (Administrador) fDAO.getAdministradorDAO().pesquisarPorNome(
					administrador.getUsuario());
			if (a != null && a.getSenha().equals(administrador.getSenha())) {
				administrador = a;
				this.logado = 2;
				FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().put("ADMINISTRADOR", a);

				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null,
						new FacesMessage("Login efetuado com Sucesso", "Olá "
								+ administrador.getUsuario()));

				this.setMensagem(context);

				return "./menuAdmin.xhtml";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Erro ao efetuar login", ""));
		this.setMensagem(context);

		return "./loginAdmin.xhtml";
	}

	public String voltar() {

		return ("./menuAdmin.xhtml?faces-redirect=true");
	}
	public String cancela(){
		
		return("./menuAdmin.xhtml?faces-redirect=true");
	}

	public String sair() {
		administrador = new Administrador();
		this.logado = 0;
		return ("loginAdmin.xhtml?faces-redirect=true");
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public FacesContext getMensagem() {
		return mensagem;
	}

	public void setMensagem(FacesContext mensagem) {
		this.mensagem = mensagem;
	}

	public int getLogado() {
		return logado;
	}

	public void setLogado(int logado) {
		this.logado = logado;
	}

}
