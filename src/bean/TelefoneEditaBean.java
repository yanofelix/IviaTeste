package bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.Telefone;
import services.MyException;
import services.TelefoneService;

@SuppressWarnings("serial")
@Named @SessionScoped
public class TelefoneEditaBean implements Serializable{
	
	private Telefone telefone;
	private TelefoneService service;
	
	public TelefoneEditaBean() {
		this.service = new TelefoneService();
		this.telefone = new Telefone();
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
	
	public String editar(Telefone fone) {
		telefone = fone;
		return "editaTelefone.xhtml";
	}
	
	public String cadastrar() {
		try {
			service.executeEditar(telefone);
		}
		catch(MyException e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu ruim" + e.getMessage(),"");
			fc.addMessage(null, msg);
			return null;
		}
		return "listaTelefone.xhtml";
	}

}
