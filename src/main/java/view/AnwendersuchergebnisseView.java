package view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Veranstaltung;
import service.AnwenderSessionService;
import service.VeranstaltungService;

@ManagedBean
@RequestScoped
public class AnwendersuchergebnisseView {

	

	@ManagedProperty("#{veranstaltungService}")
	private VeranstaltungService veranstaltungService;

	@ManagedProperty("#{anwenderSessionService}")
	private AnwenderSessionService anwenderSessionService;
	
	private Map<String, String> orte = new HashMap<String, String>();
	private List<Veranstaltung> treffer;

	public String suchen() {
		return "anwendersuchergebnisse.jsf";
	}
	
	public String eventdetails(Veranstaltung event)	{
		anwenderSessionService.setVeranstaltungsAuswahl(event);
		System.out.println("Testausgabe, ob Funktion ausgeführt wird!");
		return "anwendereventdetails.jsf";
	}

	public List<Veranstaltung> getTreffer() {
		//später hier die treffer
		return veranstaltungService.getAll();
	}
	
	public void setTreffer(List<Veranstaltung> treffer)	{
		this.treffer = treffer;
	}

	public Map<String, String> getOrte() {
		for (Veranstaltung ver : veranstaltungService.getAll()) {
			orte.put(ver.getOrt(), ver.getOrt());
		}

		return orte;
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
