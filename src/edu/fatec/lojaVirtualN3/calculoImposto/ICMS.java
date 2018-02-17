
package edu.fatec.lojaVirtualN3.calculoImposto;


public class ICMS  extends DecoratorProdutoComprado {
    public ICMS(Imposto c){
    super(c);
    }
  
    public float calculaImposto(){
     float a ;
        
        a=1.2f;
        
       
       System.out.println("Preço ICMS:");
       return((a*super.calculaImposto()));
   }    


}
    

