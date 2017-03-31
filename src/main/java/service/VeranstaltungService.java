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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import model.*;

@ApplicationScoped
public class VeranstaltungService implements Serializable {

	@Inject
	private UserService userService;

	@Inject
	private EntityManager entityManager;

	@Produces
	@ApplicationScoped
	EntityManager createEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
		System.out.println(">>>>>>>>>>>entitymanag erzeugt");
		return emf.createEntityManager();
	}

	@SuppressWarnings("deprecation")
	public VeranstaltungService() throws Exception {

	}

	private List<Veranstaltung> veranstaltungen = new LinkedList<Veranstaltung>();

	public List<Veranstaltung> getAll() {

		TypedQuery<Veranstaltung> query = entityManager.createQuery(
				"SELECT v FROM Veranstaltung v", Veranstaltung.class);
		return query.getResultList();

		// return this.veranstaltungen;
	}

	@Transactional
	public Veranstaltung addVeranstaltung(Veranstaltung veranstalt)
			throws Exception {
		veranstalt.setAnlageDatum(new Date());
		entityManager.getTransaction().begin();
		// System.out.println(entityManager.getTransaction().isActive());

		this.entityManager.persist(veranstalt);
		entityManager.getTransaction().commit();
		return veranstalt;
	}

	public List<Veranstaltung> getToManager(User manager) {

		TypedQuery<Veranstaltung> query = entityManager.createQuery(
				"SELECT v FROM Veranstaltung v where v.manager = :manager",
				Veranstaltung.class);
		query.setParameter("manager", manager);
		try {
			List<Veranstaltung> veranst = query.getResultList();
			return veranst;
		} catch (NoResultException e) {
			return null;
		}

	}

	public List<Veranstaltung> getAllNextFirst() {

		TypedQuery<Veranstaltung> query = entityManager
				.createQuery(
						"SELECT v FROM Veranstaltung v WHERE v.veranstaltungsDatum > CURRENT_DATE AND v.oeffentlich = TRUE ORDER BY v.veranstaltungsDatum ASC",
						Veranstaltung.class);
		try {
			query.setMaxResults(10);
			List<Veranstaltung> veranst = query.getResultList();
			return veranst;
		} catch (NoResultException e) {
			return null;
		}

	}

	public List<Veranstaltung> getAllNewestFirst() {

		TypedQuery<Veranstaltung> query = entityManager
				.createQuery(
						"SELECT v FROM Veranstaltung v WHERE v.oeffentlich = TRUE ORDER BY v.anlageDatum DESC",
						Veranstaltung.class);
		try {
			query.setMaxResults(10);
			List<Veranstaltung> veranst = query.getResultList();
			return veranst;
		} catch (NoResultException e) {
			return null;
		}

	}

	public List<Veranstaltung> getSuchergebnisse(String suchbegriff) {
		suchbegriff = "%"+suchbegriff +"%";
		System.out.println(suchbegriff);

		TypedQuery<Veranstaltung> query = entityManager.createQuery(
				"SELECT v FROM Veranstaltung v WHERE UPPER(v.name) LIKE UPPER(:suchbegriff) OR UPPER(v.beschreibung) LIKE UPPER(:suchbegriff) OR UPPER(v.ort) LIKE UPPER(:suchbegriff) AND v.oeffentlich = TRUE",
				Veranstaltung.class);
		query.setParameter("suchbegriff", suchbegriff);
		try {
			List<Veranstaltung> veranst = query.getResultList();
			if (!veranst.isEmpty()) {
				return veranst;
			} else {
				
				FacesContext
						.getCurrentInstance()
						.addMessage(
								"",
								new FacesMessage(FacesMessage.SEVERITY_INFO,
										"Info",
										"Es konnte keine Veranstaltung mit diesem Namen gefunden werden."));
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}

	public boolean updateVeranstaltung(Veranstaltung veranst) {

		entityManager.getTransaction().begin();
		TypedQuery<Veranstaltung> query = entityManager
				.createQuery(
						"UPDATE Veranstaltung v SET v.name = :name, v.ort = :ort, v.beschreibung = :beschreibung, v.preis = :preis, v.veranstaltungsDatum = :veranstaltungsDatum, v.oeffentlich = :oeffentlich, v.gesamtTicketanzahl = :gesamtTicketanzahl WHERE v = :veranst",
						Veranstaltung.class);
		query.setParameter("name", veranst.getName());
		query.setParameter("veranst", veranst);
		query.setParameter("ort", veranst.getOrt());
		query.setParameter("beschreibung", veranst.getBeschreibung());
		query.setParameter("preis", veranst.getPreis());
		query.setParameter("veranstaltungsDatum",
				veranst.getVeranstaltungsDatum());
		query.setParameter("oeffentlich", veranst.isOeffentlich());
		query.setParameter("gesamtTicketanzahl",
				veranst.getGesamtTicketanzahl());
		query.executeUpdate();
		entityManager.getTransaction().commit();

		return true;
	}

	public int getAnzahlFreieTickets(Veranstaltung veranst) {

		TypedQuery<Long> query = entityManager
				.createQuery(
						"SELECT SUM(r.anzahlTickets) FROM Registrierung r WHERE r.veranstaltung = :veranstaltung",
						Long.class);
		query.setParameter("veranstaltung", veranst);

		Long verkaufteTickets = query.getSingleResult();

		if (verkaufteTickets != null) {
			return (veranst.getGesamtTicketanzahl() - verkaufteTickets
					.intValue());
		}

		return veranst.getGesamtTicketanzahl();
	}

	public int getAnzahlReservierungen(Veranstaltung veranst) {

		TypedQuery<Long> query = entityManager
				.createQuery(
						"SELECT SUM(r.anzahlTickets) FROM Registrierung r WHERE r.veranstaltung = :veranstaltung",
						Long.class);
		query.setParameter("veranstaltung", veranst);

		Long verkaufteTickets = query.getSingleResult();

		if (verkaufteTickets != null) {
			return (verkaufteTickets.intValue());
		}

		return 0;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
