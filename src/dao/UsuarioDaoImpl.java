package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Usuario;
import util.GerenciadorConexao;
import util.GerenciadorConexaoMysql;



public class UsuarioDaoImpl implements UsuarioDao{
	
	private GerenciadorConexao gerenciador;
	
	public UsuarioDaoImpl() {
		gerenciador = new GerenciadorConexaoMysql();
	}
	@Override
	public void inserir(Usuario usu) throws SQLException {
		Connection conn = gerenciador.conectar();
		
		String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, usu.getNome());
		pst.setString(2, usu.getEmail());
		pst.setString(3, usu.getSenha());
		pst.executeUpdate();
		
		gerenciador.desconectar(conn);
	}

	@Override
	public void editar(Usuario usu) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String sql = "UPDATE usuarios set nome=?, email=?, senha=? WHERE id=?";
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setString(1, usu.getNome());
		pst.setString(2, usu.getEmail());
		pst.setString(3, usu.getSenha());
		pst.setInt(4, usu.getId());
		
		pst.executeUpdate();
		gerenciador.desconectar(conexao);
		
	}

	@Override
	public void remover(Integer id) throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "DELETE FROM usuarios WHERE id=?";

		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();

		gerenciador.desconectar(conn);
		
	}

	@Override
	public Usuario getById(Integer id) throws SQLException {
		Connection conn = gerenciador.conectar();
		
		String sql = "SELECT * FROM usuarios WHERE id =?";
		
		Statement stm = conn.createStatement();
	
		ResultSet rs = stm.executeQuery(sql);
		
		return null;
	}

	@Override
	public ArrayList<Usuario> getAll() throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "SELECT * FROM usuarios";
		Statement stm = conn.createStatement();

		ResultSet rs = stm.executeQuery(sql);
		ArrayList<Usuario> listUsuario = new ArrayList<>();
		
		Usuario usuario;
		while (rs.next()) {
			usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			
			listUsuario.add(usuario);
		}
		gerenciador.desconectar(conn);
		return listUsuario;
	}

}
