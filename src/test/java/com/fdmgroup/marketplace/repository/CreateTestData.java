package com.fdmgroup.marketplace.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.model.transaction.SaleItem;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.category.ItemCategoryDAO;
import com.fdmgroup.marketplace.repository.item.ItemDAO;
import com.fdmgroup.marketplace.repository.transaction.SaleDAO;
import com.fdmgroup.marketplace.repository.transaction.SaleItemDAO;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

/**
 * NOTE: drop-and-create in persisence.xml must be set.
 */
public class CreateTestData {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	private static UserAccountDAO userAccountDao;
	private static ItemCategoryDAO categoryDao;
	private static ItemDAO itemDao;
	private static SaleDAO transactionDao;
	private static SaleItemDAO transactionItemDao;
	
	private static UserAccount user1;
	private static UserAccount user2;
	private static ItemCategory category1;
	private static ItemCategory category2;
	private static Item item1;
	private static Item item2;
	private static SaleItem saleItem1;
	private static SaleItem saleItem2;
	private static Sale sale1;
	private static Sale sale2;
	
	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineMarketplaceProject");
		entityManager = entityManagerFactory.createEntityManager();
		insertData(entityManager);
		entityManagerFactory.close();
	}
	
	public static void insertData(EntityManager entityManager) {
		userAccountDao = new UserAccountDAO(entityManager);
		categoryDao = new ItemCategoryDAO(entityManager);
		itemDao = new ItemDAO(entityManager);
		transactionDao = new SaleDAO(entityManager);
		transactionItemDao = new SaleItemDAO(entityManager);
		
		insertUserAccounts(entityManager);
		insertCategories(entityManager);
		insertItems(entityManager);
		insertSaleItems(entityManager);
		insertSales(entityManager);
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
	
	public static void insertSaleItems(EntityManager entityManager) {
		saleItem1 = new SaleItem(item1, 2);
		entityManager.getTransaction().begin();
		transactionItemDao.create(saleItem1);
		entityManager.getTransaction().commit();
		
		saleItem2 = new SaleItem(item2, 1);
		entityManager.getTransaction().begin();
		transactionItemDao.create(saleItem2);
		entityManager.getTransaction().commit();
	}
	
	public static void insertSales(EntityManager entityManager) {
		Date time = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault())
			      .toInstant());
		
		sale1 = new Sale(user2, user1, time);
		sale1.addToSale(saleItem1);
		sale1.addToSale(saleItem2);
		entityManager.getTransaction().begin();
		transactionDao.create(sale1);
		entityManager.getTransaction().commit();
		
		sale2 = new Sale(user1, user2, time);
		entityManager.getTransaction().begin();
		transactionDao.create(sale2);
		entityManager.getTransaction().commit();
	}

}
