package edu.fatec.lojaVirtualN3.managedBeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.fatec.lojaVirtualN3.dao.FacadeDAO;
import edu.fatec.lojaVirtualN3.entidades.Endereco;
import edu.fatec.lojaVirtualN3.entidades.Telefone;
import edu.fatec.lojaVirtualN3.entidades.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMB implements Serializable {
	
	private static final long serialVersionUID = -2021432536560247442L;
    private Usuario usuario;
    private Telefone telefone;
    private Endereco endereco;
    private FacesContext mensagem;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;
    private List<Usuario> usuarios;
    private int logado =0;
    
	public UsuarioMB(){
	   usuario= new Usuario();
	   telefone=new Telefone();
	   endereco= new Endereco();
	   usuarios = new ArrayList<Usuario>();
	   telefones = new ArrayList<Telefone>();
	   enderecos = new ArrayList<Endereco>();
	}
	
	 public String logar(){
	    	Usuario u;
	        FacadeDAO fDAO = new FacadeDAO();	
	        try {	        	
				u = (Usuario)fDAO.getUsuarioDAO().pesquisarPorNome(usuario.getUserId());
				if(u!=null && u.getPassword().equals(usuario.getPassword())){
					usuario=u;
                     this.logado=1;					
					
					System.out.println(usuario.getEnderecos().get(0).getBairro());
				
					FacesContext context = FacesContext.getCurrentInstance(); 
		        	context.addMessage(null, new FacesMessage("Login efetuado com Sucesso", "Olá " + usuario.getNome())); 
	                	        	        	
		        	this.setMensagem(context);
		        	
		        	        	
		        	return "./menu.xhtml";
				}
	        
	        } catch (SQLException e) {
				e.printStackTrace();
			}
	        
	        FacesContext context = FacesContext.getCurrentInstance(); 
	    	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR ,"Erro ao efetuar login", "")); 
	    	this.setMensagem(context);
	    	
	    	return"./login.xhtml";
	    }
	    
	   
	 
	    public String cadastro(){
	    	 usuario= new Usuario();
	    	return "./cadastroUsuario.xhtml?faces-redirect=true";
	    }
	    
	    public String cancela(){
	    	
	    	
	    	return("");
	    }
	    
	    

	public String cadastrar(){
		usuario.getEnderecos().add(endereco);
	    usuario.getTelefones().add(telefone);
	     Usuario u = usuario;
	     
	     if(u!=null){
	    	 FacadeDAO fdao= new FacadeDAO();
	    	 try {
	    		Usuario usu=(Usuario)fdao.getUsuarioDAO()
	    				.pesquisarPorNome(u.getUserId());
	    		if((usu==null)||(usu.getEmail()==u.getEmail())||(usu.getPassword()==u.getPassword())){
				fdao.getUsuarioDAO().inserir(u);
				FacesContext.getCurrentInstance()
	        	.getExternalContext().getSessionMap().put("USUARIO", usuario);
				 
				FacesContext context = FacesContext.getCurrentInstance();
	        	context.addMessage(null, new FacesMessage("Login efetuado com Sucesso", "Olá " + usuario.getNome())); 
				this.setMensagem(context);
	        	this.logado=1;
				 return "./menu.xhtml";
	    		}
	    		FacesContext context = FacesContext.getCurrentInstance();
	        	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuário já cadastrado!", "")); 
				this.setMensagem(context);
	    	 return "./cadastroUsuario.xhtml";
	    	 } catch (SQLException e) {
				e.printStackTrace();
			}
	     }
		
		return "./cadastroUsuario.xhtml";
	}
	
	public String editarPerfil(){
		
		return("./editarUsuario.xhtml?faces-redirect=true");
	
	}
	
	public String atualizar() {
        FacadeDAO fdao = new FacadeDAO();
        try {
			fdao.getUsuarioDAO().atualizar(usuario.getId(), usuario);
			FacesContext context = FacesContext.getCurrentInstance();
        	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Alterado com sucesso!", "")); 
			this.setMensagem(context);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ("./editarUsuario.xhtml");
	}
	
	public String sair(){
		this.logado=0;
		usuario= new Usuario();
		return("./login.xhtml");
	}
	
	public String cancelar(){
		
		return"./login.xhtml?faces-redirect=true";
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public FacesContext getMensagem() {
		return mensagem;
	}

	public void setMensagem(FacesContext mensagem) {
		this.mensagem = mensagem;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public int getLogado() {
		return logado;
	}

	public void setLogado(int logado) {
		this.logado = logado;
	}

	
	
	

}
