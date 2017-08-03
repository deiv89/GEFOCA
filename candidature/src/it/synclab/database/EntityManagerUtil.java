package it.synclab.database;

import javax.persistence.*;

public class EntityManagerUtil {
	
	 private static final EntityManagerFactory entityManagerFactory;
	  static {
	    try {
	      entityManagerFactory = Persistence.createEntityManagerFactory("CANDIDATE");

	    } catch (Throwable ex) {
	      System.err.println("Initial SessionFactory creation failed." + ex);
	      throw new ExceptionInInitializerError(ex);
	    }
	  }

	  public static EntityManager getEntityManager() {
	    return entityManagerFactory.createEntityManager();

	  }

}
