package edu.fatec.lojaVirtualN3.managedBeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import edu.fatec.lojaVirtualN3.dao.FacadeDAO;
import edu.fatec.lojaVirtualN3.entidades.ProdutoComprado;

@ManagedBean
@SessionScoped
public class ProdutoCompradoMB implements Serializable{

	private static final long serialVersionUID = 3704798663571876733L;
	private FacesContext ctx;
    private ProdutoComprado produtoComprado;
	private ProdutoMB produtoMB;
	private UsuarioMB usuarioMB;
	private FacesContext mensagem;
	private List<ProdutoComprado> produtos;
	
	public ProdutoCompradoMB(){
        produtoComprado= new ProdutoComprado();
        produtos = new ArrayList<ProdutoComprado>();
       
    }
    
  
	 public String comprar(){
		 ctx =  FacesContext.getCurrentInstance();
	      
		 Application app = ctx.getApplication();	    
		    produtoMB=app.evaluateExpressionGet(ctx, "${produtoMB}", ProdutoMB.class);
		    usuarioMB=app.evaluateExpressionGet(ctx,"${usuarioMB}", UsuarioMB.class);
	       produtoComprado.setCustoUnitario(produtoMB.getProduto().getPreco());
	       produtoComprado.setEstadoPedidoDestino(usuarioMB.getUsuario().getEnderecos().get(0).getEstado());
	       produtoComprado.setFrete((int)(1+Math.random()*20));
	       produtoComprado.setCustoTotal(produtoMB.getProduto().getPreco());
		 
		 return("./efetuarCompra.xhtml?faces-redirect=true");
	    }

	 public String efetuarCompra(){
			produtoComprado.setCustoTotal(produtoComprado.getCustoTotal()*produtoComprado.getQuantidade());
			produtoComprado.setImpostos(produtoComprado.pegaImposto(usuarioMB.getUsuario()));
			 produtoComprado.setPrecofinal(produtoComprado.getCustoTotal()
					 +produtoComprado.getImpostos()+produtoComprado.getFrete());
		        
		        
		        	 return ("./confirmarCompra.xhtml?faces-redirect=true");	
		}
	 
	 public String confirmarCompra(){
		    
	       FacadeDAO fDAO = new FacadeDAO();
	    
	         try {
	        	 produtoComprado.setUsuario(usuarioMB.getUsuario());
	        	produtoComprado.setProduto(produtoMB.getProduto());
	        	 usuarioMB.getUsuario().getProdutos().add(produtoComprado);
	        
	       fDAO.getProdutoCompradoDAO().inserir(produtoComprado); 
	       FacesContext context = FacesContext.getCurrentInstance();
	       	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto "+produtoMB.getProduto().getNome()+" comprado com sucesso!", "")); 
				this.setMensagem(context);
	       produtoComprado=new ProdutoComprado();
	       
	       return("./menu.xhtml");
	       
	         
	         }catch(SQLException e){
	        	 e.printStackTrace();
	         }
		 
		return("./menu.xhtml");
	}
	 
	 public String meusProdutos(){
		 ctx =  FacesContext.getCurrentInstance();
	        Application app = ctx.getApplication();	    
		    usuarioMB=app.evaluateExpressionGet(ctx,"${usuarioMB}", UsuarioMB.class);
		 produtos=usuarioMB.getUsuario().getProdutos();
		 return("./produtosComprados.xhtml?faces-redirect=true");
	 }
	 
	 public ProdutoComprado getProdutoComprado() {
		return produtoComprado;
	}


	public void setProdutoComprado(ProdutoComprado produtoComprado) {
		this.produtoComprado = produtoComprado;
	}


	public ProdutoMB getProdutoMB() {
		return produtoMB;
	}


	public void setProdutoMB(ProdutoMB produtoMB) {
		this.produtoMB = produtoMB;
	}


	public UsuarioMB getUsuarioMB() {
		return usuarioMB;
	}


	public void setUsuarioMB(UsuarioMB usuarioMB) {
		this.usuarioMB = usuarioMB;
	}


	public FacesContext getMensagem() {
		return mensagem;
	}


	public void setMensagem(FacesContext mensagem) {
		this.mensagem = mensagem;
	}


	public List<ProdutoComprado> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<ProdutoComprado> produtos) {
		this.produtos = produtos;
	}
	
	
}
