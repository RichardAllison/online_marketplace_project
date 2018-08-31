package com.fdmgroup.marketplace.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

	private static final EntityManagerFactory entityManagerFactory;
	private static final ThreadLocal<EntityManager> threadLocal;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject"); 
		threadLocal = new ThreadLocal<EntityManager>();
	}
	
	public static EntityManager getEntityManager() {
		EntityManager manager = threadLocal.get();
		if (manager == null) {
			manager = entityManagerFactory.createEntityManager();
			threadLocal.set(manager);
		}
		return manager;
	}
	
	public static void closeEntityManager() {
		EntityManager manager = threadLocal.get();
		if (manager != null) {
			manager.close();
			threadLocal.set(null);
		}
	}
	
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
	
	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}
	
	public static void rollback(){
		getEntityManager().getTransaction().begin();
	}
	
	public static void commit() {
		getEntityManager().getTransaction().commit();
	}
}
