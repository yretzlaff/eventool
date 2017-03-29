package view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;



import javax.inject.Inject;
import javax.inject.Named;

import model.Veranstaltung;
import service.ManagerSessionService;
import service.VeranstaltungService;

//@ManagedBean
@Named
@RequestScoped
public class ManagereventsView {

	//@ManagedProperty("#{veranstaltungService}")
	@Inject
	private VeranstaltungService veranstaltungService;
	
	@Inject
	private ManagerSessionService managerSessionService;


	public String neueVeranstaltung() {
		managerSessionService.setVeranstaltungsAuswahl(new Veranstaltung());
		return "managereventadministration.jsf";
	}

	/**
	 * @return the veranstaltungen
	 */
	public List<Veranstaltung> getVeranstaltungen() {
		
		// hier muss eigentlich "veranstaltungService.getToManager(manager)" hin, da ja nur die Events des
		// Managers angezeigt werden sollen. Manager kann man sich dann aus dem Session Context holen, ist
		// aber noch nicht implementiert.
		return veranstaltungService.getToManager(managerSessionService.getActiveUser());
	}
	
	public String bearbeiten(Veranstaltung veranstaltung){
		managerSessionService.setVeranstaltungsAuswahl(veranstaltung);
		System.out.println("Bearbeiten: " + veranstaltung.getName());
		return "managereventadministration.jsf";
	}
	
	public String registrierungen(Veranstaltung veranstaltung){
		managerSessionService.setVeranstaltungsAuswahl(veranstaltung);
		System.out.println("Registrierungen ansehen: " + veranstaltung.getName());
		return "managereventregistrierungen.jsf";
	}

	public void setVeranstaltungService(VeranstaltungService service) {
		this.veranstaltungService = service;
	}

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}

	public ManagerSessionService getManagerSessionService() {
		return managerSessionService;
	}

	public void setManagerSessionService(ManagerSessionService managerSessionService) {
		this.managerSessionService = managerSessionService;
	}

}
