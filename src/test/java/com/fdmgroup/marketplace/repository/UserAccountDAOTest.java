package com.fdmgroup.marketplace.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.users.UserAccount;

public class UserAccountDAOTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static CRUD<UserAccount> userAccountDao;

	UserAccount user;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		userAccountDao = new UserAccountDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getUserAccount() {
		user = userAccountDao.retrieveOne(1L);
		assertEquals("username1", user.getUsername());
	}
	
	@Test
	public void test_getAllUserAccounts() {
		List<UserAccount> users = userAccountDao.retrieveAll();
		assertEquals(2, users.size());
	}
	
	@Test
	public void test_update() {
		UserAccount user = userAccountDao.retrieveOne(1L);
		user.setUsername("REPLACED");
		userAccountDao.update(user.getId(), user);
		user = userAccountDao.retrieveOne(1l);
		Assert.assertEquals("REPLACED", user.getUsername());
	}
	
	@Test
	public void test_delete() {
		userAccountDao.delete(1L);
		user = userAccountDao.retrieveOne(1L); 
		assertNull(user);
	}
	
}
