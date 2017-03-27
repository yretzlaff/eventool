package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Registrierung {

	
	@Id
	@GeneratedValue
	private int id;
	private String KundenName;
	private int anzahlTickets;
	private Veranstaltung veranstaltung;

	public Registrierung(int id, String name, int tickets,
			Veranstaltung veranstaltung) {
		this.id = id;
		this.KundenName = name;
		this.anzahlTickets = tickets;
		this.veranstaltung = veranstaltung;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the kundenName
	 */
	public String getKundenName() {
		return KundenName;
	}

	/**
	 * @param kundenName
	 *            the kundenName to set
	 */
	public void setKundenName(String kundenName) {
		KundenName = kundenName;
	}

	/**
	 * @return the anzahlTickets
	 */
	public int getAnzahlTickets() {
		return anzahlTickets;
	}

	/**
	 * @param anzahlTickets
	 *            the anzahlTickets to set
	 */
	public void setAnzahlTickets(int anzahlTickets) {
		this.anzahlTickets = anzahlTickets;
	}

	/**
	 * @return the veranstaltung
	 */
	public Veranstaltung getVeranstaltung() {
		return veranstaltung;
	}

	/**
	 * @param veranstaltung
	 *            the veranstaltung to set
	 */
	public void setVeranstaltung(Veranstaltung veranstaltung) {
		this.veranstaltung = veranstaltung;
	}

}
