package view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import service.VeranstaltungService;
import model.Veranstaltung;

@ManagedBean
@RequestScoped
public class StartseiteView {

	private String suchbegriff;

	public String suchen() {
		return "anwendersuchergebnisse.jsf";
	}


	@ManagedProperty("#{veranstaltungService}")
	private VeranstaltungService veranstaltungService;

	public List<Veranstaltung> getVeranstaltungen() {
		return veranstaltungService.getAll();
	}

	public void setVeranstaltungService(VeranstaltungService service) {
		this.veranstaltungService = service;
	}

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}

	public String getSuchbegriff() {
		return suchbegriff;
	}

	public void setSuchbegriff(String suchbegriff) {
		this.suchbegriff = suchbegriff;
	}

}
