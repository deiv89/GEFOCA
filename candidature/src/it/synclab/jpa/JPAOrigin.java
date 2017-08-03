package it.synclab.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import it.synclab.business.Candidate;
import it.synclab.business.Origin;
import it.synclab.database.EntityManagerUtil;
import it.synclab.service.IOriginService;

public class JPAOrigin implements IOriginService {

	private static JPAOrigin instance = new JPAOrigin();

	public static JPAOrigin getInstance() {
		if (instance == null)
			instance = new JPAOrigin();
		return instance;
	}

	private JPAOrigin() {
	}

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@Override
	public Origin create(Origin origin) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(origin);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return origin;

	}

	@Override
	public void updateIdOriginCandidate(int idCandidate, int idOrigin) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			Candidate candidate = entityManager.find(Candidate.class, idCandidate);
			candidate.setIdOrigin(idOrigin);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	@Override
	public Origin read(int idOrigin) throws ClassNotFoundException, SQLException {
		Origin origin = new Origin();
		try {
			entityManager.getTransaction().begin();
			origin = entityManager.find(Origin.class, idOrigin);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return origin;
	}

	@Override
	public void update(Origin origin) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			Origin currentOrigin = entityManager.find(Origin.class, origin.getIdOrigin());
			currentOrigin.setIdOrigin(origin.getIdOrigin());
			currentOrigin.setDescription(origin.getDescription());
			currentOrigin.setAddress(origin.getAddress());
			currentOrigin.setPhone(origin.getPhone());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	@Override
	public void delete(int idOrigin) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			Origin origin = entityManager.find(Origin.class, idOrigin);
			entityManager.remove(origin);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

}
