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

import com.fdmgroup.marketplace.model.item.Item;

public class ItemDAOTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static ItemDAO itemDao;

	private static Item item;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		itemDao = new ItemDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getItem() {
		item = itemDao.retrieveOne(1L);
		assertEquals("book", item.getName());
	}
	
	@Test
	public void test_getAllItems() {
		List<Item> items = itemDao.retrieveAll();
		assertEquals(2, items.size());
	}
	
	@Test
	public void test_updateItem() {
		Item item = itemDao.retrieveOne(1L);
		item.setName("REPLACED");
		itemDao.update(item);
		item = itemDao.retrieveOne(1l);
		Assert.assertEquals("REPLACED", item.getName());
	}
	
	@Test
	public void test_deleteItem() {
		itemDao.delete(1L);
		item = itemDao.retrieveOne(1L); 
		assertNull(item);
	}
}
