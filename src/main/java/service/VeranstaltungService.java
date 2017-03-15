package service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Veranstaltung;

@ManagedBean(name = "veranstaltungService")
@ApplicationScoped
public class VeranstaltungService {

	public VeranstaltungService() {
		
// Testweise Veranstaltungen hinzufügen!
		
		Veranstaltung veranst = new Veranstaltung("KIZ-Konzert", "Dortmund",
				"Das ist ein Konzert", new Date());
		addVeranstaltung(veranst);
		
		veranst = new Veranstaltung("Party bei Hendrik", "Langweilighausen",
				"Das ist eine lahme Party", new Date());
		addVeranstaltung(veranst);
		
	}

	private List<Veranstaltung> veranstaltungen = new LinkedList<Veranstaltung>();

	public List<Veranstaltung> getAll() {
		return this.veranstaltungen;
	}
	
	public Veranstaltung addVeranstaltung(Veranstaltung veranst) {
		
		System.out.println("Add Event with Name: " + veranst.getName());
		veranstaltungen.add(veranst);
		return veranst;
	}

}
