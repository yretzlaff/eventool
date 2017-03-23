package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Veranstaltung {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String ort;
	private String beschreibung;
	private User manager;
	private Date veranstaltungsDatum;
	private Date anlageDatum;
	//Wofür Uhrzeit, ist das nicht in Date mit drin?
	private int uhrzeit;
	private boolean oeffentlich;
	private int gesamtTicketanzahl;

	
	public Veranstaltung(String name, String ort, String beschreibung, Date datum){
		this.name = name;
		this.ort = ort;		
		this.beschreibung = beschreibung;
		this.veranstaltungsDatum = datum;
		this.anlageDatum = new Date();
		
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * @param ort
	 *            the ort to set
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/**
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * @param beschreibung
	 *            the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * @return the datum
	 */
	public Date getVeranstaltungsDatum() {
		return veranstaltungsDatum;
	}

	/**
	 * @param datum
	 *            the datum to set
	 */
	public void setVeranstaltungsDatum(Date datum) {
		this.veranstaltungsDatum = datum;
	}
	public Date getAnlageDatum() {
		return anlageDatum;
	}
	public void setAnlageDatum(Date anlageDatum) {
		this.anlageDatum = anlageDatum;
	}
	/**
	 * @return the gesamtTicketanzahl
	 */
	public int getGesamtTicketanzahl() {
		return gesamtTicketanzahl;
	}
	/**
	 * @param gesamtTicketanzahl the gesamtTicketanzahl to set
	 */
	public void setGesamtTicketanzahl(int gesamtTicketanzahl) {
		this.gesamtTicketanzahl = gesamtTicketanzahl;
	}
	/**
	 * @return the manager
	 */
	public User getManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(User manager) {
		this.manager = manager;
	}
	/**
	 * @return the uhrzeit
	 */
	public int getUhrzeit() {
		return uhrzeit;
	}
	/**
	 * @param uhrzeit the uhrzeit to set
	 */
	public void setUhrzeit(int uhrzeit) {
		this.uhrzeit = uhrzeit;
	}
	/**
	 * @return the oeffentlich
	 */
	public boolean isOeffentlich() {
		return oeffentlich;
	}
	/**
	 * @param oeffentlich the oeffentlich to set
	 */
	public void setOeffentlich(boolean oeffentlich) {
		this.oeffentlich = oeffentlich;
	}

}
