package view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HeaderView {
	public String zurStartseite()	{
		return "startseite.jsf";
	}
	
	public String login()	{
		return "managerlogin.jsf";
	}
}
