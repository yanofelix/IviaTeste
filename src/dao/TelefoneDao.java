package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Telefone;

public interface TelefoneDao {
	
	public void inserir(Telefone fone) throws SQLException;
	
	public void editar(Telefone fone) throws SQLException;
	
	public void remover(Integer id) throws SQLException;

	public Telefone getById(Integer id) throws SQLException;
		
	public ArrayList<Telefone> getAll() throws SQLException;

}
