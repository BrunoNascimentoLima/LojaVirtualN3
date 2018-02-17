package edu.fatec.lojaVirtualN3.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable {
    
   
	private static final long serialVersionUID = 7940264097385977295L;
	private long id;
    private String nome;

   public Categoria(){}

    
    public Categoria( String nome) {
        this.nome = nome;
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
    
    
}
