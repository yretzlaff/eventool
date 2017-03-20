package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import service.VeranstaltungService;


@ManagedBean
@RequestScoped
public class ManagereventadministrationView {

	
	@ManagedProperty("#{veranstaltungService}")
	private VeranstaltungService veranstaltungService;
	
	public String speichern(){
		return "managerevents.jsf";
	}
	
	
	public void setVeranstaltungService(VeranstaltungService service) {
		this.veranstaltungService = service;
	}

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}

}
