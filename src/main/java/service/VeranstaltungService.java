package service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.*;


@ApplicationScoped
public class VeranstaltungService implements Serializable{

	@SuppressWarnings("deprecation")
	public VeranstaltungService() throws InterruptedException {
		
// Testweise Veranstaltungen hinzufügen!
// Zzt. noch Thread.sleep drin, da der sonst auf der Startseite mit den Sortierungen für Neueste veranstaltung durcheinanderkommt bei fast gleichen Zeitstempeln
		
		Veranstaltung veranst = new Veranstaltung("KIZ-Konzert", "Dortmund",
				"Das ist ein Konzert", new Date(2017, 11, 29, 21, 0));
		addVeranstaltung(veranst);
		
		Thread.sleep(2000);
		
		veranst = new Veranstaltung("Party bei Hendrik", "Langweilighausen",
				"Das ist eine lahme Party", new Date(2017, 5, 18, 21, 21));
		addVeranstaltung(veranst);
		
		Thread.sleep(2000);
		
		veranst = new Veranstaltung("Sünninghauser Dorffest", "Sünninghausen - Im Nattkamp",
				"Freier Eintritt für Ü65 - HIGHLIGHT: Die Kastelruther Spatzen-Double", new Date(2017, 7, 1, 10, 30));
		addVeranstaltung(veranst);
		
		Thread.sleep(2000);
		
		veranst = new Veranstaltung("Absolventenball 2017", "Rattenfängerhalle Hameln",
				"Yannick wird Retzevoll sein", new Date(2017, 7, 15, 18, 0));
		addVeranstaltung(veranst);
		
		
	}

	private List<Veranstaltung> veranstaltungen = new LinkedList<Veranstaltung>();

	public List<Veranstaltung> getAll() {
		return this.veranstaltungen;
	}
	
	public List<Veranstaltung> getToManager(User manager){
		return this.veranstaltungen;
	}
	
	
	public Veranstaltung addVeranstaltung(Veranstaltung veranst) {
		
		System.out.println("Add Event with Name: " + veranst.getName());
		veranstaltungen.add(veranst);
		return veranst;
	}

	public List<Veranstaltung> getAllNextFirst() {
		List<Veranstaltung> nextVeranstaltungen = this.veranstaltungen;
		nextVeranstaltungen.sort(new Comparator<Veranstaltung>() {
			@Override
			public int compare(Veranstaltung o1, Veranstaltung o2) {
				return o1.getVeranstaltungsDatum().compareTo(o2.getVeranstaltungsDatum());
			};
		});
		return nextVeranstaltungen;
	}

	public List<Veranstaltung> getAllNewestFirst() {
		List<Veranstaltung> newestVeranstaltungen = this.veranstaltungen;
		newestVeranstaltungen.sort(new Comparator<Veranstaltung>() {
			@Override
			public int compare(Veranstaltung o1, Veranstaltung o2) {
				return o2.getAnlageDatum().compareTo(o1.getAnlageDatum());
			};
		});
		return newestVeranstaltungen;
	}

}
