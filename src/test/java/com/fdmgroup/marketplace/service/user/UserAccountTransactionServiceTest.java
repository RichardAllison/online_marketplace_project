package com.fdmgroup.marketplace.service.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CreateTestData;
import com.fdmgroup.marketplace.repository.user.UserAccountCRUD;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class UserAccountTransactionServiceTest {
	
	private static UserAccountPurchaseService userPurchaseService;
	private static UserAccountSaleService userAccountSaleService;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserAccountCRUD userAccountDao;
	private static UserAccount user;

	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		userAccountDao = new UserAccountDAO(entityManager);
		userPurchaseService = new DefaultUserAccountTransactionService(userAccountDao);
		userAccountSaleService = new DefaultUserAccountTransactionService(userAccountDao);
		CreateTestData.insertData(entityManager);
	}
	
	@Test
	public void test_addNewUserSale() {

	}

	@Test
	public void test_getAllUserSales() {
	}

	@Test
	public void test_updateUserSale() {
	}

	@Test
	public void test_removeUserSale() {
	}

	@Test
	public void test_addNewUserPurchase() {
	}

	@Test
	public void test_getAllUserPurchases() {
	}

	@Test
	public void test_updateUserPurchase(UserAccount userAccount, Purchase purchase) {
	}

	@Test
	public void removeUserPurchase() {
	}
	
}
