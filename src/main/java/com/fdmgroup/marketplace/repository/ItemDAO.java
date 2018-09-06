package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.item.Item;

public class ItemDAO implements CRUD<Item> {

	private EntityManager entityManager;

	public ItemDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(Item item) {
		entityManager.persist(item);
	}

	@Override
	public Item retrieveOne(long id) {
		return entityManager.find(Item.class, id);
	}

	@Override
	public List<Item> retrieveAll() {
		return entityManager.createQuery(
				"select a from Item a", Item.class).getResultList();
	}
	
	public List<Item> searchForItemsByName(String name) {
	    return entityManager.createQuery(
	        "SELECT a FROM Item a WHERE a.name LIKE :name")
	        .setParameter("name", name)
	        .getResultList();
	}
	
	public List<Item> retrieveAllByUserId(long id) {
		return entityManager.createQuery(
				"SELECT p FROM Product p JOIN UserAccount u WHERE u.id = :id", Item.class)
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
	public void update(long id, Item item) {
		entityManager.merge(item);
	}

	@Override
	public void delete(long id) {
		Item item = entityManager.find(Item.class, id);
		entityManager.remove(item);
	}
}
