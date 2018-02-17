package edu.fatec.lojaVirtualN3.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.fatec.lojaVirtualN3.entidades.Administrador;

public class AdministradorDAO implements DAO{
	
	private static EntityManagerFactory emf = null;

	public AdministradorDAO(){
		if(emf==null){
			emf=Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		}
	}

	@Override
	public void inserir(Object obj) throws SQLException {
		Administrador a;
		if(obj instanceof Administrador){
			a=(Administrador)obj;
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			em.close();
		}
	}

	@Override
	public void remover(long id, Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Administrador> qry = em.createQuery( 
				"SELECT administrador FROM Administrador administrador WHERE administrador.usuario = :nome"
				, Administrador.class);
          qry.setParameter("nome", nome);
        try{  
          Administrador resultado = qry.getSingleResult();
          em.close();
          return resultado;
          
        }catch(NoResultException e){
        	e.printStackTrace();
        	   em.close();
        	return null;
        }
	}

	@Override
	public List pesquisarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object pesquisarPorId(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List pesquisarPorCategoria(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
