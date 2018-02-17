
package edu.fatec.lojaVirtualN3.calculoImposto;



public abstract class DecoratorProdutoComprado implements Imposto {
  private Imposto cnp;
  
  public DecoratorProdutoComprado(Imposto c){
     this.cnp=c;
    }
  
  @Override
    public float calculaImposto() { 
      return cnp.calculaImposto();
    }
    
}
