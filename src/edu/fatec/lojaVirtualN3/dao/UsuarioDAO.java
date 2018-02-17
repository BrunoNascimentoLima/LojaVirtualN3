package edu.fatec.lojaVirtualN3.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.fatec.lojaVirtualN3.entidades.Usuario;

public class UsuarioDAO implements DAO{
	
	private static EntityManagerFactory emf = null;

	public UsuarioDAO(){
		if(emf==null){
			emf=Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		}
	}

	@Override
	public void inserir(Object obj) throws SQLException {
		Usuario u;
		if(obj instanceof Usuario){
			u=(Usuario)obj;
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			em.close();
		}
		
	}

	@Override
	public void remover(long id, Object obj) throws SQLException {
	   if(obj instanceof Usuario){
		   EntityManager em = emf.createEntityManager();
		   Usuario u= em.getReference(Usuario.class, id);
		   em.getTransaction().begin();
		   em.remove(u);
		   em.getTransaction().begin();
		   em.close();
	   }
		
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {
	     if(obj instanceof Usuario){
	      Usuario u = (Usuario)obj;
	      EntityManager em = emf.createEntityManager();
	      Usuario uAntigo = em.getReference(Usuario.class, id);
	      em.getTransaction().begin();
	      uAntigo.setNome(u.getNome());
	      uAntigo.setPassword(u.getPassword());
	      uAntigo.setEmail(u.getEmail());
	      uAntigo.setUserId(u.getUserId());
	     em.getTransaction().commit();
	     em.close();
	     }
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Usuario> qry = em.createQuery( 
				"SELECT usuario FROM Usuario usuario WHERE usuario.userId = :nome"
				, Usuario.class);
          qry.setParameter("nome", nome);
        try{  
          Usuario resultado = qry.getSingleResult();
         // em.close();
          return resultado;
          
        }catch(NoResultException e){
        	e.printStackTrace();
        	 //  em.close();
        	return null;
        }
       
	
	}

	@Override
	public List pesquisarTodos() throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Usuario> qry = em.createQuery( 
				"SELECT * FROM Usuario usuario "
				, Usuario.class);
          List<Usuario> resultado = qry.getResultList();
          em.close();
		return resultado;

	}

	@Override
	public Object pesquisarPorId(long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Usuario> qry = em.createQuery( 
				"SELECT usuario FROM Usuario usuario WHERE usuario.id = :id"
				, Usuario.class);
          qry.setParameter("id", id);
          Usuario resultado = qry.getSingleResult();
          em.close();
		
          return resultado;
		
		
	}

	@Override
	public List pesquisarPorCategoria(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
