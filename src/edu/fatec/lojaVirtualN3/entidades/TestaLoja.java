package edu.fatec.lojaVirtualN3.entidades;

import java.sql.SQLException;


import edu.fatec.lojaVirtualN3.dao.FacadeDAO;


public class TestaLoja {

   
    public static void main(String[] args) {
     /*
        Categoria cat = new Categoria("Informática");
        
        Administrador adm= new Administrador();
        adm.setUsuario("Dani");
        adm.setSenha("1234");
        
        Telefone tel = new Telefone("11","8767-5432","TIM");
        Endereco end = new Endereco("rua joão batista","333","primeira quadra","vila industrial","São Paulo","SP","Brasil","04567-030");
        
        Produto prod = new Produto("Notebook Dell","Notebook","São Paulo","SP","Brasil","g",4300f,350f,cat);
        
        ProdutoComprado pc = new ProdutoComprado(3,prod.getPreco(),prod.getPreco(),0,0,0,"");
        
        Usuario usu= new Usuario("Bruno Nascimento Lima","Bruno","1234","bruno@hotmail.com",end,tel);
       
        pc.setEstadoPedidoDestino(usu.getEnderecos().get(0).getEstado());
        
        pc.setCustoTotal(pc.getCustoUnitario()*pc.getQuantidade());
        pc.setImpostos(pc.pegaImposto(usu));
        pc.setPrecofinal(pc.getCustoTotal()+pc.getImpostos()+pc.getFrete());
        
        usu.getProdutos().add(pc);
        
       FacadeDAO fDAO = new FacadeDAO();
    
         try {
      //  	fDAO.getProdutoDAO().inserir(prod);
     //   	 usu.getProdutos().get(0).setProduto(prod);
       // 	 fDAO.getUsuarioDAO().inserir(usu);
		  //   fDAO.getAdministradorDAO().inserir(adm);
    	Endereco ende=  (Endereco)fDAO.getEnderecoDAO().pesquisarPorNome("rua");
	//	System.out.println(ende.getLogradouro());
		//System.out.println(ende.getBairro());
	} catch (SQLException e) {
		 
	e.printStackTrace();
	}
       
       System.out.println("Preço Impostos:\n"+pc.getImpostos());
       */
    }
}
