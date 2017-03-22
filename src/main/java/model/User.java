package model;

public class User {

	private String name;
	private String password;
	private String email;

	public User(String user, String password, String email) {
		this.name = user;
		this.password = password;
		this.email = email;
	}
	
	public boolean checkPassword(String password) {
		// TODO: Hier sollte natuerlich mehr als nur der String verglichen werden -> Hashing
		return this.password.equals(password);
	}
	
	public String getName() {
		return name;
	}

	public void setUser(String user) {
		this.name = user;
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
}
