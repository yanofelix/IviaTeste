package bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.Usuario;
import services.MyException;
import services.UsuarioService;

@SuppressWarnings("serial")
@Named @SessionScoped
public class UsuarioListaBean implements Serializable {
	
	private Usuario usu;
	private UsuarioService service;
	
	UsuarioListaBean(){
		usu = new Usuario();
		service = new UsuarioService();
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public UsuarioService getService() {
		return service;
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}
	
	public ArrayList<Usuario> getUsuario() {
		try {
			return service.executeListar();
		}catch (MyException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO!", e.getMessage());
			context.addMessage(null, msg);
			return null;
		}
	}
	
	public String paginaListar() {
		return "listaUsuario.xhtml";
	}

	public String paginaCadastrar() {
		return "cadastraUsuario.xhtml";
	}
		
	
}
