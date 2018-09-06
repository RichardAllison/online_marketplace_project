package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fdmgroup.marketplace.models.items.Product;

public class ProductDAO implements CRUD<Product> {

	EntityManager entityManager;
	
	public ProductDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(Product product) {
		entityManager.persist(product);
	}

	@Override
	public Product retrieveOne(long id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public List<Product> retrieveAll() {
		return entityManager.createQuery(
				"select a from Product a", Product.class).getResultList();
	}
	
	public List<Product> retrieveAllByUserId(long id) {
		return entityManager.createQuery(
				"SELECT p FROM Product p JOIN UserAccount u WHERE u.id = :id", Product.class)
//				"SELECT p FROM UserAccount u JOIN u.products p WHERE u.id = :id", Product.class)	
//				"SELECT p from Product p join p.owner o where o.UserAccount.id = :id", Product.class)	
				//"SELECT u from UserAccount u join u.products p where u.id = :id", Product.class)
				.setParameter("id", id)
				.getResultList();
		
		
		
//		Query query = entityManager.createNativeQuery(
//				"SELECT p.id, p.quantity, p.quantityreserved, p.item_id FROM product p WHERE owner_id = ?", Product.class);
//		query.setParameter(1, id);
//		List<Product> products = query.getResultList(); 
//		return products;
	}
	
	@Override
	public void update(long id, Product product) {
		entityManager.merge(product);
	}

	@Override
	public void delete(long id) {
		Product product = entityManager.find(Product.class, id);
		entityManager.remove(product);
	}

}