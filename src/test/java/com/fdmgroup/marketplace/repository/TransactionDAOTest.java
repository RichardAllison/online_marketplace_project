package com.fdmgroup.marketplace.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.transactions.Transaction;

public class TransactionDAOTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static TransactionDAO transactionDao;
	private Transaction transaction;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		transactionDao = new TransactionDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getTransaction() {
		transaction = transactionDao.retrieveOne(1L);
		assertEquals("username1", transaction.getBuyer().getUsername());
	}
	
	@Test
	public void test_getAllTransactions() {
		List<Transaction> transactions = transactionDao.retrieveAll();
		assertEquals(2, transactions.size());
	}
	
	@Test
	public void test_updateTransaction() {
		Transaction transaction = transactionDao.retrieveOne(1L);
		Date time = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault())
			      .toInstant());
		transaction.setTime(time);
		transactionDao.update(transaction.getId(), transaction);
		transaction = transactionDao.retrieveOne(1l);
		Assert.assertEquals(time, transaction.getTime());
	}
	
	@Test
	public void test_deleteTransaction() {
		transactionDao.delete(1L);
		transaction = transactionDao.retrieveOne(1L); 
		assertNull(transaction);
	}
	
}
