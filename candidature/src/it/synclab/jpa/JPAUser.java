package it.synclab.jpa;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.*;

import it.synclab.business.User;
import it.synclab.database.EntityManagerUtil;
import it.synclab.service.IUserService;

public class JPAUser implements IUserService {

	private static JPAUser instance = new JPAUser();

	public static JPAUser getInstance() {
		if (instance == null)
			instance = new JPAUser();
		return instance;
	}

	private JPAUser() {
	}

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@SuppressWarnings("unchecked")
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
	}
	
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
