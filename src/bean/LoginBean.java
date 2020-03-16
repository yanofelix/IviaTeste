package bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Named @RequestScoped
public class LoginBean implements Serializable{
	
	@NotNull
	private String usuario;
	@NotNull
	private String senha;
	private String msg = "";
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String verify() {
		if(usuario.equals("user")) {
			if(senha.equals("1234")) {
				msg = "Acertou mizeravi";
				return "acessoLiberado.xhtml";
			} 
			else {
				msg ="Senha invalida";
			}
		}
		else {
			msg ="Usuario invalido";
		}
		return null;
	}
	
	public String telaLogin() {
		return "login.xhtml";
	}
}
