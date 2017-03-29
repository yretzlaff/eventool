package service;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Registrierung;
import model.Veranstaltung;


@ApplicationScoped
public class RegistrierungService implements Serializable{

	public void addReservierung(String reservierungsName,
			int auswahlTicketAnzahl, Veranstaltung veranstaltungsAuswahl) {
		// TODO Hier müssen noch Prüfmechanismen für die Registrierungsanlage hin, zB anzahlTickets.
		// Dann muss die Persistierung angestoßen werden
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Veranstaltung erstellt. Name:" + reservierungsName + " Anzahl: " + auswahlTicketAnzahl));
	}

	public List<Registrierung> getRegistrierungenFürVeranstaltung(
			Veranstaltung veranstaltungsAuswahl) {
		// TODO Auto-generated method stub
		return null;
	}

}
