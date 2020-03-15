package entities;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

public class Usuario {
	
	private Integer id;
	@NotNull
	private String nome;
	@NotNull
	private String email;	
	@NotNull
	private String senha;
	private ArrayList<Telefone> telefones;
	
	public Usuario() {}
	
	public Usuario(Integer id, String nome, String senha, String email, ArrayList<Telefone> telefones) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefones = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}
	
}
