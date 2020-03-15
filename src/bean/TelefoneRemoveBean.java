package bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.Telefone;
import services.MyException;
import services.TelefoneService;

@SuppressWarnings("serial")
@Named @RequestScoped
public class TelefoneRemoveBean implements Serializable {
	
	private Telefone telefone;
	private TelefoneService service;
	
	public TelefoneRemoveBean() {
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
	
	public String remover(Integer id) {
		try {
			service.executeRemover(id);
		}catch(MyException e) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!",e.getMessage());
			contexto.addMessage(null, mensagem);
		}
		return "listaTelefone.xhtml";
	}
	
}
