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

import com.fdmgroup.marketplace.models.items.Product;

public class ProductDAOTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	private static ProductDAO productDao;
	private Product product;
	
	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		productDao = new ProductDAO(entityManager);
		CreateTestData.insertData(entityManager);
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}
	
	@Test
	public void test_getProduct() {
		product = productDao.retrieveOne(1L);
		assertEquals("book", product.getItem().getName());
	}
	
	@Test
	public void test_getAllProducts() {
		List<Product> products = productDao.retrieveAll();
		assertEquals(2, products.size());
	}
	
	@Test
	public void test_updateProduct() {
		Product product = productDao.retrieveOne(1L);
		product.setQuantity(2);
		productDao.update(product.getId(), product);
		product = productDao.retrieveOne(1l);
		Assert.assertEquals(2, product.getQuantity());
	}
	
	@Test
	public void test_deleteProduct() {
		productDao.delete(1L);
		product = productDao.retrieveOne(1L); 
		assertNull(product);
	}
	
	@Test
	public void test_productHasOwner() {
		product = productDao.retrieveOne(1L);
		assertEquals("book", product.getItem().getName());
	}
}