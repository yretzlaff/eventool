package view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import service.AnwenderSessionService;
import service.VeranstaltungService;
import model.Veranstaltung;

@ManagedBean
@RequestScoped
public class StartseiteView {
	
	@ManagedProperty("#{veranstaltungService}")
	private VeranstaltungService veranstaltungService;
	
	@ManagedProperty("#{anwenderSessionService}")
	private AnwenderSessionService anwenderSessionService;
	

	public String suchen() {
		return "anwendersuchergebnisse.jsf";
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
