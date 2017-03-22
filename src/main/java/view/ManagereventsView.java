package view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;



import javax.inject.Inject;
import javax.inject.Named;

import model.Veranstaltung;
import service.VeranstaltungService;

//@ManagedBean
@Named
@RequestScoped
public class ManagereventsView {

	//@ManagedProperty("#{veranstaltungService}")
	@Inject
	private VeranstaltungService veranstaltungService;


	public String neueVeranstaltung() {
		return "managereventadministration.jsf";
	}

	/**
	 * @return the veranstaltungen
	 */
	public List<Veranstaltung> getVeranstaltungen() {
		
		// hier muss eigentlich "veranstaltungService.getToManager(manager)" hin, da ja nur die Events des
		// Managers angezeigt werden sollen. Manager kann man sich dann aus dem Session Context holen, ist
		// aber noch nicht implementiert.
		return veranstaltungService.getAll();
	}
	
	public String bearbeiten(Veranstaltung veranstaltung){
		System.out.println("Bearbeiten: " + veranstaltung.getName());
		return "managereventadministration.jsf";
	}

	public void setVeranstaltungService(VeranstaltungService service) {
		this.veranstaltungService = service;
	}

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}

}
