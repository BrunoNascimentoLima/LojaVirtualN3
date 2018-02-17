package edu.fatec.lojaVirtualN3.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Endereco implements Serializable {
    
	private static final long serialVersionUID = -6357654635114759525L;
	private long id;
    private String logradouro,numero,complemento,bairro,cidade,estado,pais,cep;

   public Endereco(){}
    
    
    public Endereco( String logradouro, String numero, String complemento, 
            String bairro, String cidade, String estado, String pais,String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep=cep;
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
    public String getLogradouro() {
        return logradouro;
    }

  
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }



    @Column
    public String getNumero() {
        return numero;
    }

   
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    @Column
    public String getComplemento() {
        return complemento;
    }

    
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Column
    public String getBairro() {
        return bairro;
    }

    
    public void setBairro(String bairro) {
        this.bairro = bairro;
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
    public String getPais() {
        return pais;
    }

    
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Column
    public String getCep() {
        return cep;
    }

  
    public void setCep(String cep) {
        this.cep = cep;
    }
}
