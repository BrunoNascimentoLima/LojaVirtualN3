package edu.fatec.lojaVirtualN3.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
	public void inserir( Object obj ) throws SQLException;
	public void remover( long id,Object obj ) throws SQLException;
	public void atualizar(long id, Object obj) throws SQLException ;
	public Object pesquisarPorNome(String nome) throws SQLException;
	public List pesquisarTodos() throws SQLException;
	public Object pesquisarPorId(long id)throws SQLException;
	public List pesquisarPorCategoria(long id) throws SQLException ;
}
