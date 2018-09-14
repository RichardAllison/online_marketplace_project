package com.fdmgroup.marketplace.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.transaction.purchase.PurchaseItem;
import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.model.transaction.sale.SaleItem;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.category.ItemCategoryDAO;
import com.fdmgroup.marketplace.repository.item.ItemDAO;
import com.fdmgroup.marketplace.repository.transaction.purchase.PurchaseDAO;
import com.fdmgroup.marketplace.repository.transaction.purchase.PurchaseItemDAO;
import com.fdmgroup.marketplace.repository.transaction.sale.SaleDAO;
import com.fdmgroup.marketplace.repository.transaction.sale.SaleItemDAO;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;

/**
 * NOTE: drop-and-create in persisence.xml must be set.
 */
public class CreateTestData {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	private static UserAccountDAO userAccountDao;
	private static ItemCategoryDAO categoryDao;
	private static ItemDAO itemDao;
	private static SaleDAO saleDao;
	private static SaleItemDAO saleItemDao;
	private static PurchaseDAO purchaseDao;
	private static PurchaseItemDAO purchaseItemDao;
	
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
	private static PurchaseItem purchaseItem1;
	private static PurchaseItem purchaseItem2;
	private static Purchase purchase1;
	private static Purchase purchase2;
	
	public static void main(String[] args) {
		entityManager = LocalEntityManagerFactory.getEntityManager();
		insertData(entityManager);
		entityManagerFactory.close();
	}
	
	public static void insertData(EntityManager entityManager) {
		userAccountDao = new UserAccountDAO(entityManager);
		categoryDao = new ItemCategoryDAO(entityManager);
		itemDao = new ItemDAO(entityManager);
		saleDao = new SaleDAO(entityManager);
		saleItemDao = new SaleItemDAO(entityManager);
		purchaseDao = new PurchaseDAO(entityManager);
		purchaseItemDao = new PurchaseItemDAO(entityManager);
		
		insertUserAccounts(entityManager);
		insertCategories(entityManager);
		insertItems(entityManager);
		insertSaleItems(entityManager);
		insertSales(entityManager);
		insertPurchaseItems(entityManager);
		insertPurchases(entityManager);
	}
	
	public static void insertUserAccounts(EntityManager entityManager) {
		user1 = new UserAccount("username1", "password1", "email1@emailaddress.com");
		entityManager.getTransaction().begin();
		userAccountDao.create(user1);
		entityManager.getTransaction().commit();
		
		user2 = new UserAccount("username2", "password2", "email2@emailaddress.com");
		userAccountDao.create(user2);
	}
	
	public static void insertCategories(EntityManager entityManager) {
		category1 = new ItemCategory("Books");
		entityManager.getTransaction().begin();
		categoryDao.create(category1);
		entityManager.getTransaction().commit();
		
		category2 = new ItemCategory("Technology");
		categoryDao.create(category2);
	}
	
	public static void insertItems(EntityManager entityManager) {
		item1 = new Item("book", "a new book", category1,  BigDecimal.valueOf(5), 1, user1);
		item1.setQuantity(1);
		entityManager.getTransaction().begin();
		itemDao.create(item1);
		entityManager.getTransaction().commit();
		
		item2 = new Item("laptop", "mac book pro", category2, BigDecimal.valueOf(1500), 1, user1);
		itemDao.create(item2);
	}
	
	public static void insertSaleItems(EntityManager entityManager) {
		saleItem1 = new SaleItem(item1, 2);
		entityManager.getTransaction().begin();
		saleItemDao.create(saleItem1);
		entityManager.getTransaction().commit();
		
		saleItem2 = new SaleItem(item2, 1);
		entityManager.getTransaction().begin();
		saleItemDao.create(saleItem2);
		entityManager.getTransaction().commit();
	}
	
	public static void insertSales(EntityManager entityManager) {
		LocalDateTime time = LocalDateTime.now();
		
		sale1 = new Sale(user2, user1, time);
		sale1.addToSale(saleItem1);
		sale1.addToSale(saleItem2);
		entityManager.getTransaction().begin();
		saleDao.create(sale1);
		entityManager.getTransaction().commit();
		
		sale2 = new Sale(user1, user2, time);
		entityManager.getTransaction().begin();
		saleDao.create(sale2);
		entityManager.getTransaction().commit();
	}
	
	public static void insertPurchaseItems(EntityManager entityManager) {
		purchaseItem1 = new PurchaseItem(item1, 2);
		entityManager.getTransaction().begin();
		purchaseItemDao.create(purchaseItem1);
		entityManager.getTransaction().commit();
		
		purchaseItem2 = new PurchaseItem(item2, 1);
		entityManager.getTransaction().begin();
		purchaseItemDao.create(purchaseItem2);
		entityManager.getTransaction().commit();
	}
	
	public static void insertPurchases(EntityManager entityManager) {
		LocalDateTime time = LocalDateTime.now();
		
		purchase1 = new Purchase(user1, time);
		purchase1.addToPurchase(purchaseItem1);
		purchase1.addToPurchase(purchaseItem2);
		entityManager.getTransaction().begin();
		purchaseDao.create(purchase1);
		entityManager.getTransaction().commit();
		
		purchase2 = new Purchase(user2, time);
		entityManager.getTransaction().begin();
		purchaseDao.create(purchase2);
		entityManager.getTransaction().commit();
	}

}
