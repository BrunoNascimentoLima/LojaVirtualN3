package edu.fatec.lojaVirtualN3.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.fatec.lojaVirtualN3.entidades.Produto;
import edu.fatec.lojaVirtualN3.entidades.ProdutoComprado;

public class ProdutoCompradoDAO implements DAO {
	
	private static EntityManagerFactory emf = null;

	public ProdutoCompradoDAO(){
		if(emf==null){
			emf=Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		}
	}

	@Override
	public void inserir(Object obj) throws SQLException {
      ProdutoComprado pc;
      if(obj instanceof ProdutoComprado){
    	  pc=(ProdutoComprado)obj;
    	  EntityManager em = emf.createEntityManager();
    	  em.getTransaction().begin();
    	  em.persist(pc);
    	  em.getTransaction().commit();
    	  em.close();
      }
		
	}

	@Override
	public void remover(long id, Object obj) throws SQLException {
		if(obj instanceof ProdutoComprado){
			EntityManager em = emf.createEntityManager();
			ProdutoComprado pc = em.getReference(ProdutoComprado.class, id);
			em.getTransaction().begin();
			em.remove(pc);
			em.getTransaction().commit();
			em.close();
		}
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {
		if(obj instanceof ProdutoComprado){
			ProdutoComprado pc =(ProdutoComprado)obj;
			EntityManager em = emf.createEntityManager();
			ProdutoComprado pcAntigo = em.getReference(ProdutoComprado.class, id);
			pcAntigo.setEstadoPedidoDestino(pc.getEstadoPedidoDestino());
			pcAntigo.setCustoTotal(pc.getCustoTotal());
			pcAntigo.setCustoUnitario(pc.getCustoUnitario());
			pcAntigo.setFrete(pc.getFrete());
			pcAntigo.setImpostos(pc.getImpostos());
			pcAntigo.setQuantidade(pc.getQuantidade());
			pcAntigo.setPrecofinal(pc.getPrecofinal());
			em.getTransaction().commit();
			em.close();
		}
		
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		
	
		return null;
	}

	@Override
	public List pesquisarTodos() throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<ProdutoComprado> qry = em.createQuery( 
				"SELECT * FROM ProdutoComprado produtoComprado"
				, ProdutoComprado.class);
		List<ProdutoComprado> pcs = qry.getResultList();
		em.close();
		return pcs;
	}

	@Override
	public Object pesquisarPorId(long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<ProdutoComprado> qry = em.createQuery( 
				"SELECT produtoComprado FROM ProdutoComprado produtoComprado WHERE" +
				" produtoComprado.id = :id"
				, ProdutoComprado.class);
		qry.setParameter("id", id);
		ProdutoComprado pc = qry.getSingleResult();
		em.close();
		return pc;
	}

	@Override
	public List pesquisarPorCategoria(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
