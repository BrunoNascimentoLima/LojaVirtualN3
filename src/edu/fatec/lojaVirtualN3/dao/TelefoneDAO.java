package edu.fatec.lojaVirtualN3.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.fatec.lojaVirtualN3.entidades.Telefone;

public class TelefoneDAO implements DAO{

	private static EntityManagerFactory emf = null;
	
	public TelefoneDAO(){
		if(emf==null){
			emf=Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		}
		
	}
	
	@Override
	public void inserir(Object obj) throws SQLException {
		Telefone tel;
		if(obj instanceof Telefone){
			tel=(Telefone)obj;
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(tel);
			em.getTransaction().commit();
			em.close();
		}
		
	}

	@Override
	public void remover(long id, Object obj) throws SQLException {
		 Telefone tel;
		 if(obj instanceof Telefone){
			 EntityManager em = emf.createEntityManager();
			 tel=em.getReference(Telefone.class, id);
			 em.getTransaction().begin();
			 em.remove(tel);
			 em.getTransaction().commit();
			 em.close();
		 }
		
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {
		if(obj instanceof Telefone){
			Telefone tel = (Telefone)obj;
			EntityManager em = emf.createEntityManager();
			Telefone telAntigo = em.getReference(Telefone.class, id);
			em.getTransaction().begin();
			telAntigo.setDdd(tel.getDdd());
			telAntigo.setNumero(tel.getNumero());
			telAntigo.setOperadora(tel.getOperadora());
			em.getTransaction().commit();
			em.close();
		}
		
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Telefone> qry =em.createQuery(
				"select telefone FROM Telefone telefone WHERE telefone.numero like :nome"
				,Telefone.class);
		qry.setParameter("nome", "%"+nome+"%");
		Telefone resultado = qry.getSingleResult();
		em.close();
		return resultado;
	}

	@Override
	public List pesquisarTodos() throws SQLException {
		EntityManager em= emf.createEntityManager();
		TypedQuery<Telefone> qry = em.createQuery( 
				"SELECT telefone FROM Telefone telefone"
				,Telefone.class);
		List<Telefone> resultado = qry.getResultList();
		em.close();
		
				return resultado;
	}

	@Override
	public Object pesquisarPorId(long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Telefone> qry =em.createQuery(
				"select telefone FROM Telefone telefone WHERE telefone.id = :id"
				,Telefone.class);
		qry.setParameter("nome",id);
		Telefone resultado = qry.getSingleResult();
		em.close();
		return resultado;
	}

	@Override
	public List pesquisarPorCategoria(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
