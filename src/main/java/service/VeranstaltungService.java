package service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import model.*;


@ApplicationScoped
public class VeranstaltungService implements Serializable{
	
	@Inject
	private UserService userService;
	
	@Inject
	private EntityManager entityManager;
	
	@Produces 
	@ApplicationScoped
	EntityManager createEntityManager(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
		System.out.println(">>>>>>>>>>>entitymanag erzeugt");
		return emf.createEntityManager();
	}
	

	@SuppressWarnings("deprecation")
	public VeranstaltungService() throws Exception {	
		
	}

	private List<Veranstaltung> veranstaltungen = new LinkedList<Veranstaltung>();

	public List<Veranstaltung> getAll() {
		
		TypedQuery<Veranstaltung> query = entityManager.createQuery("SELECT v FROM Veranstaltung v", Veranstaltung.class);
		return query.getResultList();
		
		//return this.veranstaltungen;
	}

	
	@Transactional
	public Veranstaltung addVeranstaltung(Veranstaltung veranstalt) throws Exception {
		entityManager.getTransaction().begin();
	//	System.out.println(entityManager.getTransaction().isActive());
		
		this.entityManager.persist(veranstalt);
		entityManager.getTransaction().commit();
		return veranstalt;
	}
	
	
	
	public List<Veranstaltung> getToManager(User manager){
		
		TypedQuery<Veranstaltung> query = entityManager.createQuery(
				"SELECT v FROM Veranstaltung v where v.manager = :manager", Veranstaltung.class);
		query.setParameter("manager", manager);
		try{
			List<Veranstaltung> veranst = query.getResultList();
			return veranst;
		} catch (NoResultException e){
			return null;
		}

	}
	

	public List<Veranstaltung> getAllNextFirst(){
		List<Veranstaltung> nextVeranstaltungen = this.veranstaltungen;
		nextVeranstaltungen.sort(new Comparator<Veranstaltung>() {
			@Override
			public int compare(Veranstaltung o1, Veranstaltung o2) {
				return o1.getVeranstaltungsDatum().compareTo(o2.getVeranstaltungsDatum());
			};
		});
		return nextVeranstaltungen;
	}

	private void addTestVeranstaltungen() throws Exception {
		// TODO Auto-generated method stub
		
		
		Veranstaltung veranst = new Veranstaltung("Spaßfestival", "Sünninghausen - Im Nattkamp",
				"Freier Eintritt für Ü65 - HIGHLIGHT: Die Kastelruther Spatzen-Double", new Date(2017, 7, 1, 10, 30));
		veranst.setManager(userService.getUserByName("admin").get());
		veranst.setOeffentlich(false);
		veranst.setUhrzeit(21000);
		addVeranstaltung(veranst);
		
		
	}


	public List<Veranstaltung> getAllNewestFirst() {
		List<Veranstaltung> newestVeranstaltungen = this.veranstaltungen;
		newestVeranstaltungen.sort(new Comparator<Veranstaltung>() {
			@Override
			public int compare(Veranstaltung o1, Veranstaltung o2) {
				return o2.getAnlageDatum().compareTo(o1.getAnlageDatum());
			};
		});
		return newestVeranstaltungen;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
