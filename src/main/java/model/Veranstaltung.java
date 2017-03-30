package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Veranstaltung {

	@Id
	@GeneratedValue()
	private long id;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	private String name;
	private String ort;
	private String beschreibung;
	private double preis;
	private User manager;
	private Date veranstaltungsDatum;
	private Date anlageDatum;
	private boolean oeffentlich;
	private int gesamtTicketanzahl;

	
	
	public Veranstaltung(){
		
		
	}
	
	
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


	/**
	 * @return the preis
	 */
	public double getPreis() {
		return preis;
	}


	/**
	 * @param preis the preis to set
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

}
