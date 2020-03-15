package util;

import java.sql.Connection;
import java.sql.SQLException;

public interface GerenciadorConexao {
	/**
	 * Estabelece uma conexao com o BD 
	 * @return o objeto de conexao com a conexao ativa
	 * @throws SQLException
	 */
	public Connection conectar() throws SQLException;
	
	/**
	 * Encerra uma conexao ativa com o BD
	 * @param conexao objeto com a conexao ativa
	 * @throws SQLException
	 */
	public void desconectar(Connection conexao)throws SQLException;
}
