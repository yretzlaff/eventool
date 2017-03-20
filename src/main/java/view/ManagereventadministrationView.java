package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Veranstaltung;
import service.VeranstaltungService;


@ManagedBean
@RequestScoped
public class ManagereventadministrationView {

	private Veranstaltung veranst;
	
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


	/**
	 * @return the veranst
	 */
	public Veranstaltung getVeranst() {
		return veranst;
	}


	/**
	 * @param veranst the veranst to set
	 */
	public void setVeranst(Veranstaltung veranst) {
		this.veranst = veranst;
	}

}
