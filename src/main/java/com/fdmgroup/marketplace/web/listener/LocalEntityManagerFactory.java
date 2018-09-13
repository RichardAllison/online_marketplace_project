package com.fdmgroup.marketplace.web.listener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LocalEntityManagerFactory implements ServletContextListener {

	private static EntityManagerFactory entityManagerFactory;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		entityManagerFactory.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
	}

	public static EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
}
