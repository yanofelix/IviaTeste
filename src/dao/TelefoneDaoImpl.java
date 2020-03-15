package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Telefone;
import entities.Usuario;
import util.GerenciadorConexao;
import util.GerenciadorConexaoMysql;

public class TelefoneDaoImpl implements TelefoneDao{

	private GerenciadorConexao gerenciador;
	
	public TelefoneDaoImpl() {
		gerenciador = new GerenciadorConexaoMysql();
	}

	@Override
	public void inserir(Telefone fone) throws SQLException {
		Connection conn = gerenciador.conectar();
		
		String sql = "INSERT INTO telefones (ddd, numero, tipo, id_usuario ) VALUES (?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, fone.getDdd());
		pst.setString(2, fone.getNumero());
		pst.setString(3, fone.getTipo());
		pst.setInt(4, fone.getUsu().getId());
		pst.executeUpdate();
		
		gerenciador.desconectar(conn);
		
	}

	@Override
	public void editar(Telefone fone) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String sql = "UPDATE telefones set ddd=?, numero=?, tipo=? WHERE id=?";
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setInt(1, fone.getDdd());
		pst.setString(2, fone.getNumero());
		pst.setString(3, fone.getTipo());
		pst.setInt(4, fone.getId());
		
		pst.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public void remover(Integer id) throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "DELETE FROM telefones WHERE id=?";

		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();

		gerenciador.desconectar(conn);
		
	}

	@Override
	public Telefone getById(Integer id) throws SQLException {
		return null;
	}

	@Override
	public ArrayList<Telefone> getAll() throws SQLException {
		
		Connection conn = gerenciador.conectar();

		String sql = "SELECT * FROM telefones";
		Statement stm = conn.createStatement();

		ResultSet rs = stm.executeQuery(sql);
		ArrayList<Telefone> listTelefone = new ArrayList<>();
		Usuario usu;

		Telefone fones;
		while (rs.next()) {
			fones = new Telefone();
			usu = new Usuario();
			fones.setId(rs.getInt("id"));
			fones.setDdd(rs.getInt("ddd"));
			fones.setNumero(rs.getString("numero"));
			fones.setTipo(rs.getString("tipo"));
			usu.setId(rs.getInt("id_usuario"));
			fones.setUsu(usu);  
			listTelefone.add(fones);
		}
		
		
		gerenciador.desconectar(conn);
		return listTelefone;
	}

}
