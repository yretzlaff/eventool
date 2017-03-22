package service;
import java.io.Serializable;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.User;


@Named
@SessionScoped
public class ManagerSessionService implements Serializable{

	private User activeUser;

	
	public void login(User user) {
		
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login successful", ""));
		System.out.println("Login user with username " + user.getName());
		activeUser = user;
	}

	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}

}
