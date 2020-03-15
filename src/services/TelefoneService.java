package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.TelefoneDao;
import dao.TelefoneDaoImpl;
import entities.Telefone;

public class TelefoneService {
	
	private TelefoneDao dao;

	public TelefoneService() {
		dao = new TelefoneDaoImpl();
	}
	

	public void executeInserir(Telefone fone) throws MyException{
		try {
			this.dao.inserir(fone);
		}
		catch(SQLException e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public ArrayList<Telefone> executeListar() throws MyException {
		TelefoneDao dao = new TelefoneDaoImpl();
		try {
			return dao.getAll();
		}
		catch(SQLException e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void executeRemover(Integer id)throws MyException {
		TelefoneDao dao = new TelefoneDaoImpl();
		try {
			dao.remover(id);
		}catch(SQLException exception) {
			throw new MyException(exception.getMessage());
		}
	}
	
	public void executeEditar(Telefone fone) throws MyException{
		TelefoneDao dao = new TelefoneDaoImpl();
		try {
			dao.editar(fone);
		} catch (SQLException exception) {
			throw new MyException(exception.getMessage());
		}
	}
	
}
