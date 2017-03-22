package service;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import model.Veranstaltung;


@Named
@SessionScoped
public class AnwenderSessionService implements Serializable{
	private String suchbegriff;
	private String suchort;
	private Date suchdatum;
	private Veranstaltung veranstaltungsAuswahl;
	
	public String getSuchbegriff() {
		return suchbegriff;
	}
	public void setSuchbegriff(String suchbegriff) {
		this.suchbegriff = suchbegriff;
	}
	public String getSuchort() {
		return suchort;
	}
	public void setSuchort(String suchort) {
		this.suchort = suchort;
	}
	public Date getSuchdatum() {
		return suchdatum;
	}
	public void setSuchdatum(Date suchdatum) {
		this.suchdatum = suchdatum;
	}
	public Veranstaltung getVeranstaltungsAuswahl() {
		return veranstaltungsAuswahl;
	}
	public void setVeranstaltungsAuswahl(Veranstaltung veranstaltungsAuswahl) {
		this.veranstaltungsAuswahl = veranstaltungsAuswahl;
	}
	
	
}
