package view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Veranstaltung;
import service.AnwenderSessionService;
import service.VeranstaltungService;

//@ManagedBean
@Named
@RequestScoped
public class AnwendersuchergebnisseView {

	

	@Inject
	private VeranstaltungService veranstaltungService;

	@Inject
	private AnwenderSessionService anwenderSessionService;
	
	private List<Veranstaltung> treffer;

	public String suchen() {
		
		return "anwendersuchergebnisse.jsf";
	}
	
	public String eventdetails(Veranstaltung event)	{
		anwenderSessionService.setVeranstaltungsAuswahl(event);
		return "anwendereventdetails.jsf";
	}

	public List<Veranstaltung> getTreffer() {
		System.out.println(">>>>>>>>Treffer neu gesetzt!");
		if(veranstaltungService.getSuchergebnisse(anwenderSessionService.getSuchbegriff())!= null){
			setTreffer(veranstaltungService.getSuchergebnisse(anwenderSessionService.getSuchbegriff()));
			return treffer;
		}
		
		return null;
		
	}
	
	public void setTreffer(List<Veranstaltung> treffer)	{
		this.treffer = treffer;
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
