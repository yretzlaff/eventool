package view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.ManagerSessionService;

@Named
@RequestScoped
public class HeaderView {

	@Inject
	private ManagerSessionService managerSessionService;

	public String zurStartseite() {
		return "startseite.jsf";
	}

	public String login() {
		if (istManagerEingeloggt()) {
			return "managerevents.jsf";
		} else {
			return "managerlogin.jsf";
		}
	}

	public String logout() {
		managerSessionService.setActiveUser(null);
		managerSessionService.setVeranstaltungsAuswahl(null);
		return "startseite";
	}

	public boolean istManagerEingeloggt() {
		return managerSessionService.getActiveUser() != null;
	}

	public ManagerSessionService getManagerSessionService() {
		return managerSessionService;
	}

	public void setManagerSessionService(
			ManagerSessionService managerSessionService) {
		this.managerSessionService = managerSessionService;
	}
}
