package edu.fatec.lojaVirtualN3.entidades;

import java.util.List;

public class Estoque {
    
    private ProdutoEmEstoque produto;
    private List<ProdutoEmEstoque> listaProdutos ;


    public Estoque(){}
    
    public Estoque(ProdutoEmEstoque produto) {
        this.produto = produto;
    }

   
    public List<ProdutoEmEstoque> getListaProdutos() {
        return listaProdutos;
    }


    public void setListaProdutos(List<ProdutoEmEstoque> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
    public void add(ProdutoEmEstoque e){
     this.getListaProdutos().add(e);
     }
    
    public void remove(ProdutoEmEstoque e){
    this.getListaProdutos().remove(e);
    
    }
}
