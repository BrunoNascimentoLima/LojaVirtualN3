package edu.fatec.lojaVirtualN3.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.fatec.lojaVirtualN3.entidades.Categoria;


public class CategoriaDAO implements DAO{

private static EntityManagerFactory emf = null;
	
	public CategoriaDAO(){
		if(emf==null){
			emf=Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		}
	}
	
	@Override
	public void inserir(Object obj) throws SQLException {
		Categoria cat;
		if(obj instanceof Categoria){
			cat=(Categoria)obj;
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(cat);
			em.getTransaction().commit();
			em.close();
		}
		
	}

	@Override
	public void remover(long id, Object obj) throws SQLException {
		if(obj instanceof Categoria){
		EntityManager em = emf.createEntityManager();
		Categoria cat = em.getReference(Categoria.class, id);
		em.getTransaction().begin();
		em.remove(cat);
		em.getTransaction().commit();
		em.close();
		}
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {
		if(obj instanceof Categoria){
			Categoria cat =(Categoria)obj;
			EntityManager em = emf.createEntityManager();
			Categoria catAntigo= em.getReference(Categoria.class, id);
			em.getTransaction().begin();
			catAntigo.setNome(cat.getNome());
		    em.getTransaction().commit();
		    em.close();
		}
		
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Categoria> qry = em.createQuery(
				"select categoria from Categoria categoria where categoria.nome like :nome"
				,Categoria.class);
		qry.setParameter("nome", "%"+nome+"%");
		Categoria resultado= qry.getSingleResult();
	    em.close();
		return resultado;
	}

	@Override
	public List pesquisarTodos() throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Categoria> qry = em.createQuery(
				"select categoria from Categoria categoria"
				,Categoria.class);
		List<Categoria> resultado= qry.getResultList();
	    em.close();
		return resultado;
		
	}

	@Override
	public Object pesquisarPorId(long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Categoria> qry = em.createQuery(
				"select categoria from Categoria categoria where categoria.id = :id"
				,Categoria.class);
		qry.setParameter("id", id);
		Categoria resultado= qry.getSingleResult();
	    em.close();
		return resultado;
	}

	@Override
	public List pesquisarPorCategoria(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
