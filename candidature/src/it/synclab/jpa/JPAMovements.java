package it.synclab.jpa;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.*;

import it.synclab.business.Movement;
import it.synclab.database.EntityManagerUtil;
import it.synclab.service.IMovementsLogService;

public class JPAMovements implements IMovementsLogService {

	private static JPAMovements instance = new JPAMovements();

	public static JPAMovements getInstance() {
		if (instance == null)
			instance = new JPAMovements();
		return instance;
	}

	private JPAMovements() {
	}

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	
	@Override
	public Movement create(Movement movement) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.createNativeQuery("INSERT INTO MOVEMENTS (id, id_user, action, description, ts_operation) "+
            "VALUES (SEQ_MOVEMENTS.nextval, :idUser, :action, :descr, CURRENT_TIMESTAMP)").setParameter("idUser", movement.getIdUser()).setParameter("action", movement.getAction()).setParameter("descr", movement.getDescription()).executeUpdate();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return movement;
	}

	@Override
	public ArrayList<Movement> read() {
		return null;
	}
	
	

	/*@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> read(String userName) {
		ArrayList<User> userList = new ArrayList<User>();
		try {
			entityManager.getTransaction().begin();
			userList = (ArrayList<User>) entityManager.createQuery("FROM User WHERE userName = :username").setParameter("username", userName).getResultList();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		if (userList == null || userList.isEmpty()) {
			return userList;
		}
		return userList;
	}

	@Override
	public void create(User user) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.createNativeQuery("INSERT INTO USERS (id, username, password, TS_REGISTRATION) "+
            "VALUES (SEQ_USERS.nextval, :username, :psw, CURRENT_TIMESTAMP)").setParameter("username", user.getUserName()).setParameter("psw", user.getPassWord()).executeUpdate();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}*/
	
	/*@Override
	public void create(User user) throws ClassNotFoundException, SQLException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}*/

}
