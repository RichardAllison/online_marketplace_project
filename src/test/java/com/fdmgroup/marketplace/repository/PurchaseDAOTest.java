package com.fdmgroup.marketplace.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.repository.transaction.purchase.PurchaseDAO;

public class PurchaseDAOTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static PurchaseDAO purchaseDao;
	private Purchase transaction;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		purchaseDao = new PurchaseDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getPurchase() {
		transaction = purchaseDao.retrieveOne(1L);
		assertEquals("username1", transaction.getBuyer().getUsername());
	}
	
	@Test
	public void test_getAllPurchases() {
		List<Purchase> transactions = purchaseDao.retrieveAll();
		assertEquals(2, transactions.size());
	}
	
	@Test
	public void test_updatePurchase() {
		Purchase transaction = purchaseDao.retrieveOne(1L);
		LocalDateTime time = LocalDateTime.now();
		transaction.setTime(time);
		purchaseDao.update(transaction);
		transaction = purchaseDao.retrieveOne(1l);
		Assert.assertEquals(time, transaction.getTime());
	}
	
	@Test
	public void test_deletePurchase() {
		purchaseDao.delete(1L);
		transaction = purchaseDao.retrieveOne(1L); 
		assertNull(transaction);
	}
	
}
