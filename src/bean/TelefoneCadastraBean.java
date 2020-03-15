package bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.Telefone;
import entities.Usuario;
import services.MyException;
import services.TelefoneService;

@SuppressWarnings("serial")
@Named @SessionScoped
public class TelefoneCadastraBean implements Serializable {
	
	private Telefone telefone;
	private TelefoneService service;
	private Usuario usu;
	
	public TelefoneCadastraBean() {
		this.service = new TelefoneService();
		this.telefone = new Telefone();
		this.usu = new Usuario();
	}
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public TelefoneService getService() {
		return service;
	}

	public void setService(TelefoneService service) {
		this.service = service;
	}
	
	public Usuario getUsuario() {
		return usu;
	}

	public void setUsuario(Usuario usuario) {
		this.usu = usuario;
	}


	public String paginaTelefone(Usuario usuario) {
		usu = usuario;
		telefone.setUsu(usuario);
		return "cadastraTelefone.xhtml";
	}
	
	public String cadastrar() {
		try {
			service.executeInserir(this.telefone);	
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
