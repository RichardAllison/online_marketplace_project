package com.fdmgroup.marketplace.service.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CreateTestData;
import com.fdmgroup.marketplace.repository.user.UserAccountCRUD;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class UserAccountProductServiceTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserAccountProductService userAccountProductService;
	private static UserAccountCRUD userAccountDao;
	private static UserAccount user;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		userAccountDao = new UserAccountDAO(entityManager);
		userAccountProductService = new DefaultUserAccountProductService(userAccountDao);
		CreateTestData.insertData(entityManager);
	}

	
	@Test
	public void test_addNewUserProduct() {
		
	}

	@Test
	public void test_getAllUserProducts() {
	}

	@Test
	public void test_updateUserProduct() {
	}

	@Test
	public void test_removeUserProduct() {
		
	}

}
