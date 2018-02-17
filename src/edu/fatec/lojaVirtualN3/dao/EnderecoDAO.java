package edu.fatec.lojaVirtualN3.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import edu.fatec.lojaVirtualN3.entidades.Endereco;
import edu.fatec.lojaVirtualN3.entidades.Produto;
import edu.fatec.lojaVirtualN3.entidades.Usuario;




public class EnderecoDAO implements DAO {

private static EntityManagerFactory emf = null;
	
	public EnderecoDAO(){
		
		if(emf==null){
			emf=Persistence.createEntityManagerFactory("LOJAVIRTUAL");
		}
		
	}
	
	
	@Override
	public void inserir(Object obj) throws SQLException {
		Endereco end;
		if(obj instanceof Endereco){
			end=(Endereco)obj;
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(end);
			em.getTransaction().commit();
			em.close();
		}
		
	}

	@Override
	public void remover(long id, Object obj) throws SQLException {
		if(obj instanceof Endereco){
			EntityManager em = emf.createEntityManager();
		    Endereco end = em.getReference(Endereco.class, id);
			em.getTransaction().begin();
			em.remove( end );
			em.getTransaction().commit();
			em.close();
			
			}
	}

	@Override
	public void atualizar(long id, Object obj) throws SQLException {
		if(obj instanceof Endereco){
			Endereco end =(Endereco)obj;
			EntityManager em = emf.createEntityManager();
		    Endereco endAntigo = em.getReference(Endereco.class, id);
			em.getTransaction().begin();
			endAntigo.setBairro(end.getBairro());
			endAntigo.setCep(end.getCep());
			endAntigo.setCidade(end.getCidade());
			endAntigo.setComplemento(end.getComplemento());
			endAntigo.setEstado(end.getEstado());
			endAntigo.setLogradouro(end.getLogradouro());
			endAntigo.setNumero(end.getNumero());
			endAntigo.setPais(end.getPais());
			em.getTransaction().commit();
			em.close();
			
			}
		
	}

	@Override
	public Object pesquisarPorNome(String nome) throws SQLException {

		EntityManager em = emf.createEntityManager();
		TypedQuery<Endereco> qry = em.createQuery(
				"select endereco from Endereco endereco where endereco.logradouro like :logradouro",
				Endereco.class);
		qry.setParameter("logradouro", "%" + nome + "%");
		Endereco resultado = qry.getSingleResult();
		em.close();
		return resultado;
	}

	@Override
	public List pesquisarTodos() throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Endereco> qry = em.createQuery(
				"select endereco from Endereco endereco  ",
				Endereco.class);
	
		List<Endereco> resultado = qry.getResultList();
		em.close();
		return resultado;
		
	}


	@Override
	public Object pesquisarPorId(long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Endereco> qry = em.createQuery(
				"select endereco from Endereco endereco where endereco.id = :id",
				Endereco.class);
		qry.setParameter("id",   id );
		Endereco resultado = qry.getSingleResult();
		em.close();
		return resultado;
	
	}


	@Override
	public List pesquisarPorCategoria(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
