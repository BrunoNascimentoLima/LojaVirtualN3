package edu.fatec.lojaVirtualN3.dao;

public class FacadeDAO {

	private DAO categoriaDAO;
	private DAO enderecoDAO;
	private DAO produtoCompradoDAO;
	private DAO telefoneDAO;
	private DAO produtoDAO;
	private DAO usuarioDAO;
	private DAO administradorDAO;
	
public FacadeDAO(){
	categoriaDAO = new CategoriaDAO();
	enderecoDAO= new EnderecoDAO();
	produtoCompradoDAO = new ProdutoCompradoDAO();
	telefoneDAO = new TelefoneDAO();
	produtoDAO= new ProdutoDAO();
	usuarioDAO = new UsuarioDAO();
	administradorDAO = new AdministradorDAO();
}


public DAO getCategoriaDAO() {
	return categoriaDAO;
}


public void setCategoriaDAO(DAO categoriaDAO) {
	this.categoriaDAO = categoriaDAO;
}


public DAO getEnderecoDAO() {
	return enderecoDAO;
}


public void setEnderecoDAO(DAO enderecoDAO) {
	this.enderecoDAO = enderecoDAO;
}


public DAO getProdutoCompradoDAO() {
	return produtoCompradoDAO;
}


public void setProdutoCompradoDAO(DAO produtoCompradoDAO) {
	this.produtoCompradoDAO = produtoCompradoDAO;
}


public DAO getTelefoneDAO() {
	return telefoneDAO;
}


public void setTelefoneDAO(DAO telefoneDAO) {
	this.telefoneDAO = telefoneDAO;
}




public DAO getProdutoDAO() {
	return produtoDAO;
}


public void setProdutoDAO(DAO produtoDAO) {
	this.produtoDAO = produtoDAO;
}


public DAO getUsuarioDAO() {
	return usuarioDAO;
}


public void setUsuarioDAO(DAO usuarioDAO) {
	this.usuarioDAO = usuarioDAO;
}


public DAO getAdministradorDAO() {
	return administradorDAO;
}


public void setAdministradorDAO(DAO administradorDAO) {
	this.administradorDAO = administradorDAO;
}



}
