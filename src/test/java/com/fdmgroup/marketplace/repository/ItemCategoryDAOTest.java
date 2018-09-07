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
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.marketplace.model.category.ItemCategory;

public class ItemCategoryDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static ItemCategoryDAO itemCategoryDAO;

	private static ItemCategory itemCategory;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		itemCategoryDAO = new ItemCategoryDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getItemCategory() {
		itemCategory = itemCategoryDAO.retrieveOne(1L);
		assertEquals("Books", itemCategory.getName());
	}
	
	@Test
	public void test_getAllItemCategories() {
		List<ItemCategory> categories = itemCategoryDAO.retrieveAll();
		assertEquals(2, categories.size());
	}
	
	@Test
	public void test_updateItemCategory() {
		ItemCategory itemCategory = itemCategoryDAO.retrieveOne(1L);
		itemCategory.setName("REPLACED");
		itemCategoryDAO.update(itemCategory.getId(), itemCategory);
		itemCategory = itemCategoryDAO.retrieveOne(1l);
		Assert.assertEquals("REPLACED", itemCategory.getName());
	}
	
	@Test
	public void test_deleteItemCategory() {
		itemCategoryDAO.delete(1L);
		itemCategory = itemCategoryDAO.retrieveOne(1L); 
		assertNull(itemCategory);
	}
	
}
