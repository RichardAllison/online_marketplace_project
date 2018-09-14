package com.fdmgroup.marketplace.service.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CreateTestData;
import com.fdmgroup.marketplace.repository.user.UserAccountCRUD;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class UserAccountServiceTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserAccountService userAccountService;
	private static UserAccountCRUD userAccountDao;
	private static UserAccount user;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		userAccountDao = new UserAccountDAO(entityManager);
		userAccountService = new DefaultUserAccountService(userAccountDao);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getUserAccount() {
		user = userAccountService.retrieveOne(1L);
		assertEquals("username1", user.getUsername());
	}
	
	@Test
	public void test_getAllUserAccounts() {
		List<UserAccount> users = userAccountService.retrieveAll();
		assertEquals(2, users.size());
	}
	
	@Test
	public void test_updateUserAccount() {
		UserAccount user = userAccountService.retrieveOne(1L);
		user.setUsername("REPLACED");
		userAccountService.update(user);
		user = userAccountService.retrieveOne(1l);
		Assert.assertEquals("REPLACED", user.getUsername());
	}
	
	@Test
	@Ignore
	public void test_deleteUserAccount() {
		userAccountService.delete(1L);
		user = userAccountService.retrieveOne(1L); 
		assertNull(user);
	}

}

