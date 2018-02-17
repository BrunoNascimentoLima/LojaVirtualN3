package edu.fatec.lojaVirtualN3.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.fatec.lojaVirtualN3.entidades.Produto; 
import edu.fatec.lojaVirtualN3.dao.DAO; 

public class ProdutoDAO implements DAO {
	
	private static EntityManagerFactory emf = null;

	public ProdutoDAO(){
		if(emf==null){
			emf=Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		}
	}

	@Override
	public void inserir(Object obj) throws SQLException {
		Produto p ;
		 if(obj instanceof Produto){
			 p=(Produto)obj;
		//emf = Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		 }
	}

	@Override
	public void remover(long id,Object obj) throws SQLException {
		if(obj instanceof Produto){
		EntityManager em = emf.createEntityManager();
	    Produto p = em.getReference(Produto.class, id);
		em.getTransaction().begin();
		em.remove( p );
		em.getTransaction().commit();
		em.close();
		
		}
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {

		if(obj instanceof Produto){
        Produto	p=(Produto)obj;	
	
        EntityManager em = emf.createEntityManager();
	    Produto prodAntigo = em.getReference(Produto.class, id); // cria uma instancia do produto do id 1
		em.getTransaction().begin(); //vou atualizar
		prodAntigo.setNome(p.getNome()); //pega o produto antigo e atualiza com os dados novos
		prodAntigo.setDescricao(p.getDescricao());
		prodAntigo.setCidade(p.getCidade());
		prodAntigo.setEstado(p.getEstado());
		prodAntigo.setMedida(p.getMedida());
		prodAntigo.setPaisOrigem(p.getPaisOrigem());
		prodAntigo.setUnidMedida(p.getUnidMedida());
		prodAntigo.setPreco(p.getPreco());
		prodAntigo.setFoto(p.getFoto());
		em.getTransaction().commit();
		em.close();
		}
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {		
		EntityManager em = emf.createEntityManager();
		TypedQuery<Produto> qry = em.createQuery(
				"select produto from Produto produto where produto.nome  = :nome",
				Produto.class);
		qry.setParameter("nome",  nome );
		try{
		Produto resultado = qry.getSingleResult();		
		em.close();
		return resultado;
		}catch(Exception e){
			em.close();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List pesquisarTodos() throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Produto> qry = em.createQuery(
				"select * from Produto prod ",
				Produto.class);
		List<Produto> resultado = qry.getResultList();
		em.close();
		return resultado;
	}

	@Override
	public Object pesquisarPorId(long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Produto> qry = em.createQuery(
				"select produto from Produto produto where produto.id = :id",
				Produto.class);
		qry.setParameter("id", id);
		Produto resultado = qry.getSingleResult();
		em.close();
		return resultado;
		
	}
	public List pesquisarPorCategoria(long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Produto> qry = em.createQuery(
				"select produto from  Produto produto where categoria_id = :id",
				Produto.class);
		qry.setParameter("id", id);
		List<Produto> resultado = qry.getResultList();
		em.close();
		return resultado;
		
	}
	

}
