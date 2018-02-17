/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fatec.lojaVirtualN3.calculoImposto;


/**
 *
 * @author Bruno
 */
public class IPI extends DecoratorProdutoComprado {
  
    
    public IPI(Imposto c){    
     super(c);
     
        }
   public float calculaImposto(){
   float a ;   
          a=1.33f;
          System.out.println("Preço IPI:");
       return((a*super.calculaImposto()));
   }    
}


