


package edu.fatec.lojaVirtualN3.calculoImposto;





public  class ISS extends DecoratorProdutoComprado {
    public ISS(Imposto c){
    super(c);
    }
   public float calculaImposto(){
   float a ;
        a=1.8f;
        
          
       System.out.println("Preço ISS:");
       return((a*super.calculaImposto()));
   }    


}
