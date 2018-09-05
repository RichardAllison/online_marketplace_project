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

import com.fdmgroup.marketplace.models.transactions.TransactionItem;

public class TransactionItemDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static TransactionItemDAO transactionItemDao;
	private TransactionItem transactionItem;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		transactionItemDao = new TransactionItemDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getTransactionItem() {
		transactionItem = transactionItemDao.retrieveOne(1L);
		assertEquals(2, transactionItem.getQuantity());
	}
	
	@Test
	public void test_getAllTransactionItems() {
		List<TransactionItem> transactionItems = transactionItemDao.retrieveAll();
		assertEquals(2, transactionItems.size());
	}
	
	@Test
	public void test_updateTransactionItem() {
		TransactionItem transactionItem = transactionItemDao.retrieveOne(1L);
		transactionItem.setQuantity(2);
		transactionItemDao.update(transactionItem.getId(), transactionItem);
		transactionItem = transactionItemDao.retrieveOne(1l);
		Assert.assertEquals(2, transactionItem.getQuantity());
	}
	
	@Test
	public void test_deleteTransactionItem() {
		transactionItemDao.delete(1L);
		transactionItem = transactionItemDao.retrieveOne(1L); 
		assertNull(transactionItem);
	}
}
