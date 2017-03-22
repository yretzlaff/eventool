package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import service.AnwenderSessionService;
import service.VeranstaltungService;

@RequestScoped
@ManagedBean
public class AnwendereventdetailsView {
	@ManagedProperty("#{veranstaltungService}")
	private VeranstaltungService veranstaltungService;
	
	@ManagedProperty("#{anwenderSessionService}")
	private AnwenderSessionService anwenderSessionService;
	

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}

	public void setVeranstaltungService(VeranstaltungService veranstaltungService) {
		this.veranstaltungService = veranstaltungService;
	}

	public AnwenderSessionService getAnwenderSessionService() {
		return anwenderSessionService;
	}

	public void setAnwenderSessionService(
			AnwenderSessionService anwenderSessionService) {
		this.anwenderSessionService = anwenderSessionService;
	}
	
}
