package view;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.User;
import service.ManagerSessionService;

@ManagedBean
@RequestScoped
public class LoginForm {

	private User user;
	private String password;

	@ManagedProperty("#{managerSessionService}")
	private ManagerSessionService managerSessionService;

	public String login() {
		System.out.println("<< doLogin() " + (user != null ? user.getName() : "KEIN USER") + " " + password);
		
		if (user != null) {
			if (user.checkPassword(this.password)) {
				getManagerSessionService().login(user);
				System.out.println("<< Login erfolgreich!");
				return "managerevents.jsf";
			}
			
		}
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed",
						""));
		System.out.println("Login failed!");
		return "managerlogin.jsf";
	}

	public String register() {
		return "register.jsf";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public ManagerSessionService getManagerSessionService() {
		return managerSessionService;
	}

	public void setManagerSessionService(ManagerSessionService managerSessionService) {
		this.managerSessionService = managerSessionService;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
