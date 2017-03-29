package view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import service.AnwenderSessionService;
import service.VeranstaltungService;
import model.Veranstaltung;

//@ManagedBean
@Named
@RequestScoped
public class StartseiteView {
	
	//@ManagedProperty("#{veranstaltungService}")
	@Inject
	private VeranstaltungService veranstaltungService;
	
	//@ManagedProperty("#{anwenderSessionService}")
	@Inject
	private AnwenderSessionService anwenderSessionService;
	

	public String suchen() {
		return "anwendersuchergebnisse.jsf";
	}
	
	public String login()	{
		return "managerlogin.jsf";
	}


	public List<Veranstaltung> getVeranstaltungen() {
		return veranstaltungService.getAll();
	}
	
	public List<Veranstaltung> getNaechsteVeranstaltungen() {
		return veranstaltungService.getAllNextFirst();
	}
	
	public List<Veranstaltung> getNeuesteVeranstaltungen() {
		return veranstaltungService.getAllNewestFirst();
	}

	public void setVeranstaltungService(VeranstaltungService service) {
		this.veranstaltungService = service;
	}

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}

	public AnwenderSessionService getAnwenderSessionService() {
		return anwenderSessionService;
	}


	public void setAnwenderSessionService(
			AnwenderSessionService anwenderSessionService) {
		this.anwenderSessionService = anwenderSessionService;
	}

}
