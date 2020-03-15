package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GerenciadorConexaoMysql implements GerenciadorConexao {

	private String url, usuario, senha;
	private static GerenciadorConexaoMysql instancia;
	
	public GerenciadorConexaoMysql() {
		ResourceBundle rb = ResourceBundle.getBundle("util.banco");
		url=rb.getString("url");
		usuario= rb.getString("usuario");
		senha = rb.getString("senha");
	}
	public static GerenciadorConexaoMysql getInstancia() {
		if(instancia==null){
			instancia = new GerenciadorConexaoMysql();
		}
		return instancia;
	}
	
	@Override
	public Connection conectar() throws SQLException {
		return DriverManager.getConnection(url,usuario, senha);
	}

	@Override
	public void desconectar(Connection conexao) throws SQLException {
		conexao.close();

	}

}
