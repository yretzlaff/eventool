package view;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import model.Registrierung;
import service.AnwenderSessionService;
import service.RegistrierungService;
import service.VeranstaltungService;

@Named
@RequestScoped
//@ManagedBean
public class AnwendereventdetailsView {
	//@ManagedProperty("#{veranstaltungService}")
	@Inject
	private VeranstaltungService veranstaltungService;
	
	@Inject
	private RegistrierungService registrierungService;
	
	//@ManagedProperty("#{anwenderSessionService}")
	@Inject
	private AnwenderSessionService anwenderSessionService;

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}

	public void setVeranstaltungService(VeranstaltungService veranstaltungService) {
		this.veranstaltungService = veranstaltungService;
	}

	public AnwenderSessionService getAnwenderSessionService() {
		return anwenderSessionService;
	}

	public void setAnwenderSessionService(
			AnwenderSessionService anwenderSessionService) {
		this.anwenderSessionService = anwenderSessionService;
	}

	public RegistrierungService getRegistrierungService() {
		return registrierungService;
	}

	public void setRegistrierungService(RegistrierungService registrierungService) {
		this.registrierungService = registrierungService;
	}
	
	private String reservierungsName;
	private int auswahlTicketAnzahl;
	
	public String reservieren()	{
		Registrierung newReg = new Registrierung();
		newReg.setKundenName(reservierungsName);
		newReg.setAnzahlTickets(auswahlTicketAnzahl);
		newReg.setVeranstaltung(anwenderSessionService.getVeranstaltungsAuswahl());
		registrierungService.addReservierung(newReg);
		return "anwendereventdetailsView.jsf";
	}

	public String getReservierungsName() {
		return reservierungsName;
	}

	public void setReservierungsName(String reservierungsName) {
		this.reservierungsName = reservierungsName;
	}

	public int getAuswahlTicketAnzahl() {
		return auswahlTicketAnzahl;
	}

	public void setAuswahlTicketAnzahl(int auswahlTicketAnzahl) {
		this.auswahlTicketAnzahl = auswahlTicketAnzahl;
	}
	
}
