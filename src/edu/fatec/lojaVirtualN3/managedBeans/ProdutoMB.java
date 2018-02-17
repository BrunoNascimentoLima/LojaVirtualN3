package edu.fatec.lojaVirtualN3.managedBeans;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;


import edu.fatec.lojaVirtualN3.dao.DAO;
import edu.fatec.lojaVirtualN3.dao.FacadeDAO;
import edu.fatec.lojaVirtualN3.dao.ProdutoDAO;
import edu.fatec.lojaVirtualN3.entidades.Categoria;
import edu.fatec.lojaVirtualN3.entidades.Produto;



@ManagedBean
@SessionScoped
public class ProdutoMB implements Serializable {

	
	private static final long serialVersionUID = -9162393912105315905L;
    private Produto produto;
    private Categoria categoria;
    private StreamedContent imagem;
    private FacesMessage mensagem;
	private List<Produto> produtos;
	private List<Categoria> categorias;
    private List<StreamedContent> imagens;
    
	 public ProdutoMB(){
    	produto= new Produto(); 
    	categoria=new Categoria();
    	categorias = new ArrayList();
        imagens= new ArrayList();
    	FacadeDAO fdao= new FacadeDAO();
    	  try {
	    	categorias=	fdao.getCategoriaDAO().pesquisarTodos();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
	 
	 
    
    public String pesquisar(){
    	FacadeDAO fdao= new FacadeDAO();
    	 try {
			Produto prod=(Produto)fdao.getProdutoDAO()
					.pesquisarPorNome(produto.getNome());
			   
		     if(prod!=null){
		    	 produto=prod;
		     }
    	 
    	 } catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return ("");
    }
    
    
    public String pesquisarPorCategoria(){
    	Categoria cat;
    	FacadeDAO fdao= new FacadeDAO();
    	try {
			cat=(Categoria)fdao.getCategoriaDAO().pesquisarPorNome(categoria.getNome());
		    produtos =fdao.getProdutoDAO().pesquisarPorCategoria(cat.getId());
    	      
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return("");
    }
    
    public String pesquisarPorCategoriaCompra(){
    	Categoria cat;
    	FacadeDAO fdao= new FacadeDAO();
    	try {
			cat=(Categoria)fdao.getCategoriaDAO().pesquisarPorNome(categoria.getNome());
		    produtos =fdao.getProdutoDAO().pesquisarPorCategoria(cat.getId());
		    
		    
		    return("./produto.xhtml?faces-redirect=true");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    		catch(NullPointerException e){
			e.printStackTrace();
		}
    	return("./produto");
    }
    
    public String selecionar(Produto prod){
     	produto= prod;
     	pesquisarFoto();
    	return("");
    }
    
    public String fotoProduto(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Successo!", event.getFile().getFileName() + " foi atualizado.");  
   
        try{	
            imagem = new DefaultStreamedContent(event.getFile().getInputstream());
        	byte[] foto = event.getFile().getContents();
        	 produto.setFoto(foto);
        	
         
        	} catch (IOException e) {
				e.printStackTrace();
        	}
        return("./cadastroProduto.xhtml");
    }
    
    public String pesquisarFoto(){
    	DAO pdao = new ProdutoDAO();
    	try {
    	     produto=(Produto)pdao.pesquisarPorId(produto.getId());
    	     imagem = new DefaultStreamedContent(new ByteArrayInputStream(produto.getFoto()));
    	} catch (SQLException e) {
			e.printStackTrace();
    	}
    	
    	return("./cadastroProduto.xhtml?faces-redirect=true");
    }
    
    public String cadastrar(){
	     Produto p = produto;
	     p.setId(0);
	     if(p!=null){
	    	 FacadeDAO fdao= new FacadeDAO();
	    	 try {
	    		Produto prod=(Produto)fdao.getProdutoDAO()
	    				.pesquisarPorNome(p.getNome());
	    		if((prod==null)||(prod.getDescricao()==p.getDescricao())||(prod.getPreco()==p.getPreco())){
			      categoria=(Categoria)fdao.getCategoriaDAO().pesquisarPorNome(categoria.getNome());
			      p.setCategoria(categoria);
			      fdao.getProdutoDAO().inserir(p);
				  p=(Produto)fdao.getProdutoDAO().pesquisarPorNome(p.getNome());   
				  fdao.getProdutoDAO().atualizar(p.getId(), p);
				 
	        	mensagem= new FacesMessage("Produto " + p.getNome()+ " cadastrado com sucesso!",""); 
				
	        	
				 return "./cadastroProduto.xhtml?faces-redirect=true";
	    		}
	    		mensagem= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro ao cadastrar produto! ","");
	    		
	    	 return "./cadastroProduto.xhtml?faces-redirect=true";
	    	 } catch (SQLException e) {
				e.printStackTrace();
			}
	     }
		
	     return "./cadastroProduto.xhtml";
	}
    
    public String remover(Produto prod) { 
		DAO pDao = new ProdutoDAO();
		try {
			pDao.remover( prod.getId(),prod );
			mensagem= new FacesMessage("Produto " + produto.getNome()+ " removido!","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pesquisarPorCategoria();
		return "./gestaoProduto.xhtml?faces-redirect=true";
	}
    
    public String atualizar() { 
		ProdutoDAO pDao = new ProdutoDAO();
		try {
			pDao.atualizar(produto.getId(), produto);
			mensagem= new FacesMessage("Produto " + produto.getNome()+ " atualizado com sucesso!",""); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
    public String cancela(){
    	
    	
    	return("/menuAdmin.xhtml?faces-redirect=true");
    }
 
    public String visualizar(Produto p){
    	produto=p;
    	pesquisarFoto();
    	return("./compra.xhtml");
    	
    }
    
   
    
   
    
    public String cancelar(){
    	return("./produto.xhtml?faces-redirect=true");
    }
    
    public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public StreamedContent getImagem() {
		return imagem;
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

	public FacesMessage getMensagem() {
		return mensagem;
	}

	public void setMensagem(FacesMessage mensagem) {
		this.mensagem = mensagem;
	}



	public List<StreamedContent> getImagens() {
		return imagens;
	}



	public void setImagens(List<StreamedContent> imagens) {
		this.imagens = imagens;
	}

	

	
	

}
