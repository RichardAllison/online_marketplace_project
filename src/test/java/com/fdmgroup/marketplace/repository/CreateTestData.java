package com.fdmgroup.marketplace.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.model.transaction.SaleItem;
import com.fdmgroup.marketplace.model.user.UserAccount;

/**
 * NOTE: drop-and-create in persisence.xml must be set.
 */
public class CreateTestData {
	
	private static UserAccountDAO userAccountDao;
	private static ItemCategoryDAO categoryDao;
	private static ItemDAO itemDao;
	private static TransactionDAO transactionDao;
	private static TransactionItemDAO transactionItemDao;
	
	private static UserAccount user1;
	private static UserAccount user2;
	private static ItemCategory category1;
	private static ItemCategory category2;
	private static Item item1;
	private static Item item2;
	private static SaleItem orderItem1;
	private static SaleItem orderItem2;
	private static Sale order1;
	private static Sale order2;
	
	public static void insertData(EntityManager entityManager) {
		userAccountDao = new UserAccountDAO(entityManager);
		categoryDao = new ItemCategoryDAO(entityManager);
		itemDao = new ItemDAO(entityManager);
		transactionDao = new TransactionDAO(entityManager);
		transactionItemDao = new TransactionItemDAO(entityManager);
		
		insertUserAccounts(entityManager);
		insertCategories(entityManager);
		insertItems(entityManager);
//		insertProducts(entityManager);
		insertTransactionItems(entityManager);
		insertTransactions(entityManager);
	}
	
	public static void insertUserAccounts(EntityManager entityManager) {
		user1 = new UserAccount("username1", "password1", "email1@emailaddress.com");
		entityManager.getTransaction().begin();
		userAccountDao.create(user1);
		entityManager.getTransaction().commit();
		
		user2 = new UserAccount("username2", "password2", "email2@emailaddress.com");
		entityManager.getTransaction().begin();
		userAccountDao.create(user2);
		entityManager.getTransaction().commit();
	}
	
	public static void insertCategories(EntityManager entityManager) {
		category1 = new ItemCategory("Books");
		entityManager.getTransaction().begin();
		categoryDao.create(category1);
		entityManager.getTransaction().commit();
		
		category2 = new ItemCategory("Technology");
		entityManager.getTransaction().begin();
		categoryDao.create(category2);
		entityManager.getTransaction().commit();
	}
	
	public static void insertItems(EntityManager entityManager) {
		item1 = new Item("book", "a new book", BigDecimal.valueOf(5), user1);
		entityManager.getTransaction().begin();
		itemDao.create(item1);
		entityManager.getTransaction().commit();
		
		item2 = new Item("laptop", "mac book pro", BigDecimal.valueOf(1500), user1);
		entityManager.getTransaction().begin();
		itemDao.create(item2);
		entityManager.getTransaction().commit();
	}
	
//	public static void insertProducts(EntityManager entityManager) {
//		product1 = new Product(item1, 5);
//		entityManager.getTransaction().begin();
//		productDao.create(product1);
//		entityManager.getTransaction().commit();
//		
//		product2 = new Product(item2, 1);
//		entityManager.getTransaction().begin();
//		productDao.create(product2);
//		entityManager.getTransaction().commit();
//	}
	
	public static void insertTransactionItems(EntityManager entityManager) {
		orderItem1 = new SaleItem(item1, 2);
		entityManager.getTransaction().begin();
		transactionItemDao.create(orderItem1);
		entityManager.getTransaction().commit();
		
		orderItem2 = new SaleItem(item2, 1);
		entityManager.getTransaction().begin();
		transactionItemDao.create(orderItem2);
		entityManager.getTransaction().commit();
	}
	
	public static void insertTransactions(EntityManager entityManager) {
		Date time = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault())
			      .toInstant());
		
		order1 = new Sale(user1, time);
		entityManager.getTransaction().begin();
		transactionDao.create(order1);
		entityManager.getTransaction().commit();
		
		order2 = new Sale(user2, time);
		entityManager.getTransaction().begin();
		transactionDao.create(order2);
		entityManager.getTransaction().commit();
	}

}
