package edu.fatec.lojaVirtualN3.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Telefone implements Serializable{
    

	private static final long serialVersionUID = -1948266804166465302L;
	private long id;
    private String ddd,numero,operadora;

    public Telefone(){}
    
    public Telefone(String ddd, String numero, String operadora) {
        this.ddd = ddd;
        this.numero = numero;
        this.operadora = operadora;
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
    public String getDdd() {
        return ddd;
    }

   
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

  @Column
    public String getNumero() {
        return numero;
    }

   
    public void setNumero(String numero) {
        this.numero = numero;
    }

   @Column
    public String getOperadora() {
        return operadora;
    }

   
    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
    
}
