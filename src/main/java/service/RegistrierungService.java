package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Registrierung;
import model.Veranstaltung;

@ApplicationScoped
public class RegistrierungService implements Serializable {

	@Inject
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void addReservierung(Registrierung registrierung) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(registrierung);
		this.entityManager.getTransaction().commit();

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"Erfolgreich " + registrierung.getAnzahlTickets() + " Tickets reserviert! Persönliche Buchungs-ID: "
								+ registrierung.getId()));
	}

	public List<Registrierung> getRegistrierungenFürVeranstaltung(
			Veranstaltung veranstaltungsAuswahl) {
		TypedQuery<Registrierung> query = entityManager.createQuery(
				"SELECT r FROM Registrierung r where r.veranstaltung = :veranstaltungsAuswahl", Registrierung.class);
		query.setParameter("veranstaltungsAuswahl", veranstaltungsAuswahl);
		try{
			List<Registrierung> reg = query.getResultList();
			return reg;
		} catch (NoResultException e){
			return null;
		}
	}

}
