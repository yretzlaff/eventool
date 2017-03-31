package view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Veranstaltung;
import service.ManagerSessionService;
import service.VeranstaltungService;


//@ManagedBean
@Named
@RequestScoped
public class ManagereventadministrationView {

	
	//@ManagedProperty("#{veranstaltungService}")
	@Inject
	private VeranstaltungService veranstaltungService;

	@Inject
	private ManagerSessionService managerSessionService;
	
	private Veranstaltung veranstaltung;
	
	public String speichern(){
		
		if(managerSessionService.getVeranstaltungsAuswahl().getId() > 0){
			
			veranstaltungService.updateVeranstaltung(managerSessionService.getVeranstaltungsAuswahl());
			managerSessionService.setVeranstaltungsAuswahl(null);
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Veranstaltungsinfos erfolgreich gespeichert", ""));
			return "managerevents.jsf";
		}else{
			try {
				managerSessionService.getVeranstaltungsAuswahl().setManager(managerSessionService.getActiveUser());
				veranstaltungService.addVeranstaltung(managerSessionService.getVeranstaltungsAuswahl());
				FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Veranstaltungsinfos erfolgreich gespeichert", ""));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "managerevents.jsf";
		}
		
		
	}
	
	public String zurueckZuEvents()	{
		return "managerevents.jsf";
	}
	
	
	public void setVeranstaltungService(VeranstaltungService service) {
		this.veranstaltungService = service;
	}

	public VeranstaltungService getVeranstaltungService() {
		return veranstaltungService;
	}


	/**
	 * @return the veranstaltung
	 */
	public Veranstaltung getVeranstaltung() {
		return veranstaltung;
	}


	/**
	 * @param veranstaltung the veranstaltung to set
	 */
	public void setVeranstaltung(Veranstaltung veranstaltung) {
		this.veranstaltung = veranstaltung;
	}


	public ManagerSessionService getManagerSessionService() {
		return managerSessionService;
	}


	public void setManagerSessionService(ManagerSessionService managerSessionService) {
		this.managerSessionService = managerSessionService;
	}

}
