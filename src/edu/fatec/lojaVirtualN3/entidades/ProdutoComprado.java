

package edu.fatec.lojaVirtualN3.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.ForeignKey;

import edu.fatec.lojaVirtualN3.calculoImposto.Imposto;
import edu.fatec.lojaVirtualN3.calculoImposto.ImpostoFactory;

@Entity
public class ProdutoComprado implements Imposto,Serializable{
    
    private static final long serialVersionUID = -6541056495042064965L;
	private long id,quantidade;
    private float custoUnitario,custoTotal,frete,impostos, precofinal;
    private String estadoPedidoDestino;
    private Produto produto;
    private Usuario usuario;
    
public ProdutoComprado(){}

    public ProdutoComprado(long quantidade, float custoUnitario, float custoTotal, 
            float frete, float impostos, float precofinal, String estadoPedidoDestino) {
       
        this.quantidade = quantidade;
        this.custoUnitario = custoUnitario;
        this.custoTotal = custoTotal;
        this.frete = frete;
        this.impostos = impostos;
        this.precofinal = precofinal;
        this.estadoPedidoDestino = estadoPedidoDestino;
      
    }

    
    public float pegaImposto(Usuario usuario){
		ImpostoFactory imf = new ImpostoFactory(this);
		Imposto imp;
        imp=imf.criaImposto(usuario.getEnderecos().get(0).getCidade(),usuario.getEnderecos().get(0).getEstado());
	    return imp.calculaImposto();
    }
   
    @Override
	public float calculaImposto() {
		
		return this.custoTotal;
	}
    
    
 @Id
 @GeneratedValue
    public long getId() {
        return id;
    }

   
    public void setId(long id) {
        this.id = id;
    }



    @Column
    public long getQuantidade() {
        
        return quantidade;
    }

  
    public void setQuantidade(long quantidade) {
    
        this.quantidade = quantidade;
    }

    @Column
    public float getCustoUnitario() {
        return custoUnitario;
    }

 
    public void setCustoUnitario(float custoUnitario) {
        this.custoUnitario = custoUnitario;
    }
    @Column
    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    @Column
    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    @Column
    public float getImpostos() {
        return impostos;
    }

  
    public void setImpostos(float impostos) {
        this.impostos = impostos;
    }

    @Column
    public float getPrecofinal() {
        return precofinal;
    }

 
    public void setPrecofinal(float precofinal) {
        this.precofinal = precofinal;
    }

    @Column
    public String getEstadoPedidoDestino() {
        return estadoPedidoDestino;
    }

    
    public void setEstadoPedidoDestino(String estadoPedidoDestino) {
        this.estadoPedidoDestino = estadoPedidoDestino;
    }

    @ManyToOne(targetEntity=Produto.class)
    public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@ManyToOne(targetEntity=Usuario.class)
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    

  
    }
