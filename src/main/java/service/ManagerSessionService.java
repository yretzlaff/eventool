package service;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.User;

@ManagedBean
@SessionScoped
public class ManagerSessionService {

	private User activeUser;
	
	@ManagedProperty("#{userService}")
	private UserService userService;
	
	@ManagedProperty("#{veranstaltungService}")
	private VeranstaltungService veranstaltungService;
	
	public boolean login(String username, String password) {
		Optional<User> userToLogin = userService.getUserByName(username);
		if (userToLogin.isPresent()) {
			if (password.equals(userToLogin.get().getPassword())) {
				activeUser = userToLogin.get();
				return true;
			}
		}
		return false;
	}

	public User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
