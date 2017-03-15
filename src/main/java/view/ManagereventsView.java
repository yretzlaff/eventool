package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class ManagereventsView {
	
	public String neueVeranstaltung() {
		return "managereventadministration.jsf";
	}

}
