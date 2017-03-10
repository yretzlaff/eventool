import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.print.attribute.standard.Severity;

@ManagedBean
@RequestScoped
public class RegisterForm {

	private String username;
	private String password;
	private String email;

	@ManagedProperty("#{userService}")
	private UserService userService;
	
	public RegisterForm() {

	}

	public String register() {
		if(password.length() > 4){
			User user = new User(username, password, email);
			return userService.addUser(user) ? "index.jsf" : "register.jsf";
		}
		else{
			FacesMessage passwordToShort = new FacesMessage("Das Passwort muss mindestens 4 Zeichen lang sein.", null);
			FacesContext.getCurrentInstance().addMessage(null, passwordToShort);
			return "register.jsf";
		}	
	}

	public String cancel() {
		return "index.jsf";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserService getUserService(){
		return this.userService;
	}
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
}
