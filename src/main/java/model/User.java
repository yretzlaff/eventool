package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "NAME",length=255)
	private String name;
	
	@Column(name="PASSWORD",length=255)
	private String password;
	
	@Column(name="EMAIL",length=255)
	private String email;

	public User(String user, String password, String email) {
		this.name = user;
		this.password = password;
		this.email = email;
	}
	
	public User(){
		
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
