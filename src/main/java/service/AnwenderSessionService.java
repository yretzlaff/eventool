package service;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Veranstaltung;

@ManagedBean
@SessionScoped
public class AnwenderSessionService {
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
