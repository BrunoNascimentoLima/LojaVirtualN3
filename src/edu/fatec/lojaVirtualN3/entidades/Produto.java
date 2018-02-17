package edu.fatec.lojaVirtualN3.entidades;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;






@Entity
public class Produto implements Serializable{
	
    
	private static final long serialVersionUID = 8081778107404207485L;
	private long id;
    private String nome,descricao,cidade,estado,paisOrigem,unidMedida;
    private byte[] foto;
    private float preco,medida;
    private Categoria categoria; 
    
    public Produto(){}
    
    
    public Produto(String nome, String descricao,
			String cidade, String estado, String paisOrigem, String unidMedida,
			float preco, float medida,Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.cidade = cidade;
		this.estado = estado;
		this.paisOrigem = paisOrigem;
		this.unidMedida = unidMedida;
		this.preco = preco;
		this.medida = medida;
        this.categoria=categoria;		
		
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
    public String getDescricao() {
        return descricao;
    }

    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column
    public String getCidade() {
        return cidade;
    }

   
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Column
    public String getEstado() {
        return estado;
    }

  
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column
    public String getPaisOrigem() {
        return paisOrigem;
    }

    
    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }


    @Column
    public String getUnidMedida() {
        return unidMedida;
    }

    
    public void setUnidMedida(String unidMedida) {
        this.unidMedida = unidMedida;
    }

    @Column
    public float getPreco() {
        return preco;
    }

  
    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Column
    public float getMedida() {
        return medida;
    }

    @Column(columnDefinition="Blob",length=1000)
    public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	public void setMedida(float medida) {
        this.medida = medida;
    }

    @ManyToOne(targetEntity=Categoria.class)
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

    
    
    
}
