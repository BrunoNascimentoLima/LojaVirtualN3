package edu.fatec.lojaVirtualN3.calculoImposto;

import edu.fatec.lojaVirtualN3.entidades.ProdutoComprado;

public class ImpostoFactory extends FactoryMethod {
	ProdutoComprado pc;

	public ImpostoFactory(ProdutoComprado pc){		
		this.pc=pc;
	}  
	
	@Override
	public Imposto criaImposto(String cidade,String estado){
		
       System.out.println(pc.calculaImposto()); 
        
        Imposto ipi = new IPI(pc);
        System.out.println(ipi.calculaImposto());
        
        Imposto icms = new ICMS(ipi);
          if ("SP".equalsIgnoreCase(estado))
           System.out.println(icms.calculaImposto()*1.4);
          else if("RJ".equalsIgnoreCase(estado))
              System.out.println(icms.calculaImposto()*1.3);
          else if("RS".equalsIgnoreCase(estado))
              System.out.println(icms.calculaImposto()*1.2);
          else if("MG".equalsIgnoreCase(estado))
              System.out.println(icms.calculaImposto()*1.02);
            else if("ES".equalsIgnoreCase(estado))
               System.out.println(icms.calculaImposto()*1.5);
            else if("SC".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.3);
            else if("PR".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.2);
            else if("MS".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.07);
            else if("MT".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.02);
            else if("GO".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.33);
            else if("DF".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.22);
            else if("BA".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.24);
            else if("SE".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.29);
            else if("AL".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.12);
            else if("PE".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.7);
            else if("RN".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.23);
            else if("CE".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.5);
            else if("PA".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1);
            else if("MA".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.3);
            else if("AM".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.8);
            else if("AC".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1);
            else if("RR".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1);
            else if("RO".equalsIgnoreCase(estado))
                System.out.println(icms.calculaImposto()*1.2);
          
       
          Imposto iss = new ISS(icms);
          if ("São Paulo".equalsIgnoreCase(cidade))
              System.out.println(iss.calculaImposto()*1.4);
             else if("Rio de Janeiro".equalsIgnoreCase(cidade))
                 System.out.println(iss.calculaImposto()*1.3);
             else if("Rio Grande do Sul".equalsIgnoreCase(cidade))
                 System.out.println(iss.calculaImposto()*1.2);
             else if("Belo Horizonte".equalsIgnoreCase(cidade))
                 System.out.println(iss.calculaImposto()*1.02);
             else if("Manaus".equalsIgnoreCase(cidade))
                 System.out.println(iss.calculaImposto()*1.9);
           
	   
        return iss;
	}
}
