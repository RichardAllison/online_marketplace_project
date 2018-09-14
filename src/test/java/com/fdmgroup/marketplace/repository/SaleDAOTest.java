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
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.repository.transaction.sale.SaleDAO;

public class SaleDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static SaleDAO saleDao;
	private Sale sale;

	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		saleDao = new SaleDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	public void test_getTransaction() {
		sale = saleDao.retrieveOne(1L);
		assertEquals("username1", sale.getBuyer().getUsername());
	}

	@Test
	public void test_getAllTransactions() {
		List<Sale> sales = saleDao.retrieveAll();
		assertEquals(2, sales.size());
	}

	@Test
	public void test_updateTransaction() {
		Sale sale = saleDao.retrieveOne(1L);
		LocalDateTime time = LocalDateTime.now();
		sale.setTime(time);
		saleDao.update(sale);
		sale = saleDao.retrieveOne(1l);
		assertEquals(time, sale.getTime());
	}

	@Test
	public void test_deleteTransaction() {
		saleDao.delete(1L);
		sale = saleDao.retrieveOne(1L); 
		assertNull(sale);
	}

}
