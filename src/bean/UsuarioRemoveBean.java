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
public class UsuarioRemoveBean implements Serializable {
	
	private Usuario usu;
	private UsuarioService service;
	
	public UsuarioRemoveBean() {
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
	
	public String remover(Integer id) {
		try {
			service.executeRemover(id);
		}catch(MyException e) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!",e.getMessage());
			contexto.addMessage(null, mensagem);
		}
		return "listaUsuario.xhtml";
	}

}
