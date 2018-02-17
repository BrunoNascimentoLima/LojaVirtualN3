package edu.fatec.lojaVirtualN3.entidades;



public class ProdutoEmEstoque {

	private int id;
    private float quantidade;
    private Produto produto;

    public ProdutoEmEstoque(){}
    
    public ProdutoEmEstoque(int id, float quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }


    public ProdutoEmEstoque(int id, float quantidade, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
    }
   
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
    
    
    
}
