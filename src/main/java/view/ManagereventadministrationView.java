package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Veranstaltung;
import service.VeranstaltungService;


@ManagedBean
@RequestScoped
public class ManagereventadministrationView {

	
	@ManagedProperty("#{veranstaltungService}")
	private VeranstaltungService veranstaltungService;

	
	private Veranstaltung veranstaltung;
	
	public String speichern(){
		return "managerevents.jsf";
	}
	
	
	public void setVeranstaltungService(VeranstaltungService service) {
		this.veranstaltungService = service;
	}

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}


	/**
	 * @return the veranstaltung
	 */
	public Veranstaltung getVeranstaltung() {
		return veranstaltung;
	}


	/**
	 * @param veranstaltung the veranstaltung to set
	 */
	public void setVeranstaltung(Veranstaltung veranstaltung) {
		this.veranstaltung = veranstaltung;
	}

}
