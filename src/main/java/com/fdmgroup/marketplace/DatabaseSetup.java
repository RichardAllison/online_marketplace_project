package com.fdmgroup.marketplace;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.marketplace.models.users.UserAccount;
import com.fdmgroup.marketplace.repository.CRUD;


/**
 * Note: This relies on a clean database with drop-and-create enabled
 * and the two books created below to be present.
 */
public class DatabaseSetup {
//
//	private static EntityManager entityManager;
//	private static CRUD<UserAccount> userAccountCrud;
//	private static CRUD<Author> authorCrud;
//	private static CRUD<Publisher> publisherCrud;
//	private static final Logger LOGGER = LogManager.getLogger(Demo.class);
//	
//	public static void main(String[] args) {
//		entityManager = EntityManagerUtil.getEntityManager();
//		bookCrud = new BookDAO(entityManager);
//		authorCrud = new AuthorDAO(entityManager);
//		publisherCrud = new PublisherDAO(entityManager);
//
//		createSpringInActionBook();
//		createDesignPatternsBook();
//		createUsers();
//		
//		demoBookDAO();
//
//		// Clean-up before exit
//		EntityManagerUtil.closeEntityManager();
//		EntityManagerUtil.closeEntityManagerFactory();
//		LOGGER.info("Exiting application");
//	}
//
//	/**
//	 * One book with one Author & Publisher,
//	 * created in separate commits.
//	 */
//	private static void createSpringInActionBook(){
//		Author springInActionAuthor = new Author("Craig", "Walls", "Craig's biography");
//		EntityManagerUtil.beginTransaction();
//		authorCrud.create(springInActionAuthor);
//		EntityManagerUtil.commit();
//	
//		Publisher manningPublisher = new Publisher("Manning Publications", "Shelter Island, NY 11964");
//		EntityManagerUtil.beginTransaction();
//		publisherCrud.create(manningPublisher);
//		EntityManagerUtil.commit();
//	
//		List<Author> siaAuthors = new ArrayList<>();
//		siaAuthors.add(springInActionAuthor);
//		Book springInActionBook = new Book("Spring in Action", "161729120X", 624, siaAuthors, manningPublisher, PublicationType.PAPERBACK); 
//		EntityManagerUtil.beginTransaction();
//		bookCrud.create(springInActionBook);
//		EntityManagerUtil.commit();
//	}
//
//	/**
//	 * One book with three Authors & a Publisher,
//	 * persisted in one commit.
//	 */
//	private static void createDesignPatternsBook(){
//		Author rHelm = new Author("Richard", "Helm", "Richard's biography");
//		Author rJohnson = new Author("Ralph", "Johnson", "Ralph's biography");
//		Author jVlissides = new Author("John", "Vlissides", "John's biography");
//	
//		Publisher addisonPublisher = new Publisher("Addison Wesley", "330 Hudson, New York City, New York");
//		
//		List<Author> gofAuthors = new ArrayList<>();
//		gofAuthors.add(rHelm);
//		gofAuthors.add(rJohnson);
//		gofAuthors.add(jVlissides);
//		Book gofBook = new Book("Design patterns : elements of reusable object-oriented software", "0201633612", 416, gofAuthors, addisonPublisher, PublicationType.HARDBACK); 
//	
//		EntityManagerUtil.beginTransaction();
//		bookCrud.create(gofBook);
//		EntityManagerUtil.commit();
//	}
//
//	/**
//	 * Test Book DAO methods.
//	 */
//	private static void demoBookDAO() {
//		Book springBook = bookCrud.retrieveOne(1);
//		LOGGER.debug("BookDAO.retrieveOne() = " + springBook.getTitle());
//		
//		LOGGER.debug("BookDAO.retrieveAll() number of books = " + bookCrud.retrieveAll().size());
//
//		springBook.setIsbn("987654321");
//		bookCrud.update(springBook.getId(), springBook);
//		springBook = bookCrud.retrieveOne(1);
//		LOGGER.debug("BookDAO.update() isbn now = " + springBook.getIsbn());
//
//		List<Book> allBooks = new BookDAO(entityManager).byAuthorId(1L);
//		LOGGER.debug("BookDAO.allBooksByAuthorId() number of books = " + allBooks.size());
//
//		bookCrud.delete(1L);
//		LOGGER.debug("After BookDAO.delete(), total number of books = " + bookCrud.retrieveAll().size());
//	}
//	
//	private static void createUsers(){
//		WebUser user1 = new WebUser("user", "password");
//		WebUser user2 = new WebUser("david", "password");
//		WebUserDAO webUserDao = new WebUserDAO(entityManager);
//		EntityManagerUtil.beginTransaction();
//		webUserDao.create(user1);
//		webUserDao.create(user2);
//		EntityManagerUtil.commit();
//	}
}
