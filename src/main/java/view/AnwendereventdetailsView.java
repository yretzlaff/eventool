package view;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import service.AnwenderSessionService;
import service.RegistrierungService;
import service.VeranstaltungService;

@Named
@RequestScoped
//@ManagedBean
public class AnwendereventdetailsView {
	//@ManagedProperty("#{veranstaltungService}")
	@Inject
	private VeranstaltungService veranstaltungService;
	
	@Inject
	private RegistrierungService registrierungService;
	
	//@ManagedProperty("#{anwenderSessionService}")
	@Inject
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

	public RegistrierungService getRegistrierungService() {
		return registrierungService;
	}

	public void setRegistrierungService(RegistrierungService registrierungService) {
		this.registrierungService = registrierungService;
	}
	
	public String reservieren()	{
		return "anwendereventdetailsView.jsf";
	}
	
}
