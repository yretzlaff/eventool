package service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import model.User;


@ApplicationScoped
public class UserService implements Serializable{


	
	@Inject
	private EntityManager entityManager;

	@Produces 
	@ApplicationScoped
	EntityManager createEntityManager(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
		System.out.println(">>>>>>>>>>>entitymanag erzeugt");
		return emf.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Transactional
	public User addUser(User user) throws Exception {
		this.entityManager.persist(user);
		return user;
	}
	
	
	public Optional<User> getUserByName(String name) {
	
		TypedQuery<User> query = entityManager.createQuery(
				"SELECT u FROM User u where u.name = :name", User.class);
		query.setParameter("name", name);
		try{
			User user = query.getSingleResult();
			return Optional.of(user);
		} catch (NoResultException e){
			return Optional.empty();
		}
	}

	
	public List<User> getAll() {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}
	
	
	
/**	
	
	private List<User> users;

	public UserService() {
		users = new ArrayList<User>();
 		addUser(new User("admin", "admin", "admintest.de"));
	}
 * 
 * 
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

**/
}
