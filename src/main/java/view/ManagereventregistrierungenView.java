package view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.ManagerSessionService;
import service.RegistrierungService;
import model.Registrierung;

@Named
@RequestScoped
public class ManagereventregistrierungenView {

	private List<Registrierung> registrierungen;
	
	@Inject
	private ManagerSessionService managerSessionService;
	
	@Inject
	private RegistrierungService registrierungService;

	public List<Registrierung> getRegistrierungen() {
		return registrierungService.getRegistrierungenFürVeranstaltung(managerSessionService.getVeranstaltungsAuswahl());
	}

	public void setRegistrierungen(
			List<Registrierung> registrierungen) {
		this.registrierungen = registrierungen;
	}

	public ManagerSessionService getManagerSessionService() {
		return managerSessionService;
	}

	public void setManagerSessionService(ManagerSessionService managerSessionService) {
		this.managerSessionService = managerSessionService;
	}
	
}
