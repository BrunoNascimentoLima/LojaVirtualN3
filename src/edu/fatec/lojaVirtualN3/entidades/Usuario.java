package edu.fatec.lojaVirtualN3.entidades;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.mapping.Bag;



@Entity
public class Usuario implements Serializable{
    
  
	private static final long serialVersionUID = -2277771516899625533L;
	private long id;
    private String nome,userId,password,email;
    private List <Endereco> enderecos;
    private List<Telefone> telefones;
    private List<ProdutoComprado> produtos ;

    public Usuario(){
        enderecos = new ArrayList<Endereco>();
     	telefones = new ArrayList<Telefone>();
     	produtos = new ArrayList<ProdutoComprado>();
    }
    
    
    public Usuario(String nome, String userId, String password, String email, Endereco endereco,
            Telefone telefone) {
        this.nome = nome;
        this.userId = userId;
        this.password = password;
        this.email = email;
        enderecos = new ArrayList<Endereco>();
    	telefones = new ArrayList<Telefone>();
    	produtos = new ArrayList<ProdutoComprado>();
    	enderecos.add(endereco);
    	telefones.add(telefone);
    	this.setEnderecos(enderecos);
    	this.setTelefones(telefones); 
    	
    
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
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

   @Column
    public String getUserId() {
        return userId;
    }

  
    public void setUserId(String userId) {
        this.userId = userId;
    }

   @Column
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    public String getEmail() {
        return email;
    }

   
    public void setEmail(String email) {
        this.email = email;
    }

  
 
  
   

    @OneToMany(targetEntity=Endereco.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@OneToMany(targetEntity=Telefone.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id")
	public List<Telefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@OneToMany(targetEntity=ProdutoComprado.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id")
	public List<ProdutoComprado> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<ProdutoComprado> produtos) {
		this.produtos = produtos;
	}


	
    
 }
