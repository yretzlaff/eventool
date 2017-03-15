package model;

import java.util.Date;

public class Veranstaltung {

	private String name;
	private String ort;
	private String beschreibung;
	private Date datum;
	private int gesamtTicketanzahl;

	
	public Veranstaltung(String name, String ort, String beschreibung, Date datum){
		this.name = name;
		this.ort = ort;		
		this.beschreibung = beschreibung;
		this.datum = datum;
		
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
	public Date getDatum() {
		return datum;
	}

	/**
	 * @param datum
	 *            the datum to set
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
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

}
