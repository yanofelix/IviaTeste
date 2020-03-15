package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Usuario;

public interface UsuarioDao {

	public void inserir(Usuario usu) throws SQLException;
	
	public void editar(Usuario usu) throws SQLException;
	
	public void remover(Integer id) throws SQLException;

	public Usuario getById(Integer id) throws SQLException;
		
	public ArrayList<Usuario> getAll() throws SQLException;
}
