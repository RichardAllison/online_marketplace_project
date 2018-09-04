package com.fdmgroup.marketplace;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.marketplace.models.categories.Category;
import com.fdmgroup.marketplace.models.items.Item;
import com.fdmgroup.marketplace.models.items.Product;
import com.fdmgroup.marketplace.models.transactions.Checkout;
import com.fdmgroup.marketplace.models.transactions.Transaction;
import com.fdmgroup.marketplace.models.transactions.TransactionItem;
import com.fdmgroup.marketplace.models.users.UserAccount;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.CategoryDAO;
import com.fdmgroup.marketplace.repository.EntityManagerHelper;
import com.fdmgroup.marketplace.repository.ItemDAO;
import com.fdmgroup.marketplace.repository.OrderDAO;
import com.fdmgroup.marketplace.repository.OrderItemDAO;
import com.fdmgroup.marketplace.repository.ProductDAO;
import com.fdmgroup.marketplace.repository.UserAccountDAO;


/**
 * Note: This relies on a clean database with drop-and-create enabled
 * and the two books created below to be present.
 */
public class DatabaseSetup {

	private static EntityManager entityManager;
	private static CRUD<UserAccount> userAccountCrud;
	private static CRUD<Category> categoryCrud;
	private static CRUD<Item> itemCrud;
	private static CRUD<Product> productCrud;
	private static CRUD<Transaction> orderCrud;
	private static CRUD<TransactionItem> orderItemCrud;
	private static final Logger LOGGER = LogManager.getLogger(DatabaseSetup.class);
	
	public static void main(String[] args) {
		entityManager = EntityManagerHelper.getEntityManager();
		userAccountCrud = new UserAccountDAO(entityManager);
		categoryCrud = new CategoryDAO(entityManager);
		itemCrud = new ItemDAO(entityManager);
		productCrud = new ProductDAO(entityManager);
		orderCrud = new OrderDAO(entityManager);
		orderItemCrud = new OrderItemDAO(entityManager);
		
		createUsers();
		
		// Clean-up before exit
		EntityManagerHelper.closeEntityManager();
		EntityManagerHelper.closeEntityManagerFactory();
		LOGGER.info("Exiting application");
	}
	
	private static void createUsers(){
		UserAccount user1 = new UserAccount("user", "password");
		System.out.println(user1.getUsername());
		UserAccount user2 = new UserAccount("david", "password");
		UserAccountDAO UserAccountDao = new UserAccountDAO(entityManager);
		EntityManagerHelper.beginTransaction();
		UserAccountDao.create(user1);
		UserAccountDao.create(user2);
		EntityManagerHelper.commit();
	}
}
