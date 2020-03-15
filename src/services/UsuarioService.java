package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import entities.Usuario;

public class UsuarioService {
	
	private UsuarioDao dao;
	
	public UsuarioService() {
		this.dao = new UsuarioDaoImpl();
	}
	

	public void executeInserir(Usuario usu) throws MyException{
		try {
			this.dao.inserir(usu);
		}
		catch(SQLException e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public ArrayList<Usuario> executeListar() throws MyException {
		UsuarioDao dao = new UsuarioDaoImpl();
		try {
			return dao.getAll();
		}
		catch(SQLException e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void executeRemover(Integer id)throws MyException {
		UsuarioDao dao = new UsuarioDaoImpl();
		try {
			dao.remover(id);
		}catch(SQLException exception) {
			throw new MyException(exception.getMessage());
		}
	}
	
	public void executeEditar(Usuario usu) throws MyException{
		UsuarioDao dao = new UsuarioDaoImpl();
		try {
			dao.editar(usu);
		} catch (SQLException exception) {
			throw new MyException(exception.getMessage());
		}
	}
	
}
