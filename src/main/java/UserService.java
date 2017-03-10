import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class UserService {

	private List<User> users;

	public UserService() {
		users = new ArrayList<User>();
	}

	public Optional<User> getUserByName(String name) {
		return users.stream().filter(user -> user.getName().equals(name)).findFirst();
	}

	public boolean addUser(User user) {
		if (getUserByName(user.getName()).isPresent() == false) {
			return users.add(user);
		}
		return false;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
