package bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.Usuario;
import services.MyException;
import services.UsuarioService;

@SuppressWarnings("serial")
@Named @RequestScoped
public class UsuarioCadastraBean implements Serializable {
	
	private Usuario usu;
	private UsuarioService service;
	
	public UsuarioCadastraBean() {
		this.usu = new Usuario();
		this.service = new UsuarioService();
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
	
	public String cadastrar() {
		try {
			service.executeInserir(this.usu);
		}
		catch(MyException e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu ruim" + e.getMessage(),"");
			fc.addMessage(null, msg);
			return null;
		}
		return "listaUsuario.xhtml";
	}
	
}
