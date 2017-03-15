package view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Veranstaltung;
import service.VeranstaltungService;

@ManagedBean
@RequestScoped
public class AnwendersuchergebnisseView {

	private String suchbegriff;

	@ManagedProperty("#{veranstaltungService}")
	private VeranstaltungService veranstaltungService;

	private String ort;
	private Map<String, String> orte = new HashMap<String, String>();

	public String suchen() {

		return "anwendersuchergebnisse.jsf";
	}

	public List<Veranstaltung> getVeranstaltungen() {
		return veranstaltungService.getAll();
	}

	public Map<String, String> getOrte() {
		for (Veranstaltung ver : veranstaltungService.getAll()) {
			orte.put(ver.getOrt(), ver.getOrt());
		}

		return orte;
	}

	public void setVeranstaltungService(VeranstaltungService service) {
		this.veranstaltungService = service;
	}

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}

	public String getSuchbegriff() {
		return suchbegriff;
	}

	public void setSuchbegriff(String suchbegriff) {
		this.suchbegriff = suchbegriff;
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

}
