package bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.Telefone;
import services.MyException;
import services.TelefoneService;

@SuppressWarnings("serial")
@Named @RequestScoped
public class TelefoneListaBean implements Serializable{
	
	private Telefone telefone;
	private TelefoneService service;
	
	public TelefoneListaBean() {	
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
	
	public ArrayList<Telefone> getFone() {
		try {
			return service.executeListar();
		}
		catch (MyException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO!", e.getMessage());
			context.addMessage(null, msg);
			return null;
		}
	}
	

	public String paginaListar() {
		return "listaTelefone.xhtml";
	}
	
	public String paginaListarUsuario() {
		return "listaUsuario.xhtml";
	}
	
}
