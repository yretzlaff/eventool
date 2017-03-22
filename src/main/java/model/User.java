package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@GeneratedValue
	@Id
	private Long id;
	
	private String name;
	private String password;
	private String email;

	public User(String user, String password, String email) {
		this.name = user;
		this.password = password;
		this.email = email;
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
