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

import com.fdmgroup.marketplace.model.transaction.purchase.PurchaseItem;
import com.fdmgroup.marketplace.repository.transaction.purchase.PurchaseItemDAO;

public class PurchaseItemDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static PurchaseItemDAO purchaseItemDao;
	private PurchaseItem purchaseItem;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		purchaseItemDao = new PurchaseItemDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getTransactionItem() {
		purchaseItem = purchaseItemDao.retrieveOne(1L);
		assertEquals(2, purchaseItem.getQuantity());
	}
	
	@Test
	public void test_getAllTransactionItems() {
		List<PurchaseItem> purchaseItems = purchaseItemDao.retrieveAll();
		assertEquals(2, purchaseItems.size());
	}
	
	@Test
	public void test_updateTransactionItem() {
		PurchaseItem purchaseItem = purchaseItemDao.retrieveOne(1L);
		purchaseItem.setQuantity(2);
		purchaseItemDao.update(purchaseItem);
		purchaseItem = purchaseItemDao.retrieveOne(1l);
		Assert.assertEquals(2, purchaseItem.getQuantity());
	}
	
	@Test
	public void test_deleteTransactionItem() {
		purchaseItemDao.delete(1L);
		purchaseItem = purchaseItemDao.retrieveOne(1L); 
		assertNull(purchaseItem);
	}
}
