import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginForm {

	private String username;
	private String password;
	
	@ManagedProperty("#{loginService}")
	private LoginService loginService;
	
	public String login(){
		if(loginService.login(username, password)){
			return "home.jsf";
		}
		return "index.jsf";
	}

	public String register(){
		return "register.jsf";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public LoginService getLoginService(){
		return loginService;
	}
	
	public void setLoginService(LoginService loginService){
		this.loginService = loginService;
	}
}
