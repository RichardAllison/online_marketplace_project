package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.models.items.Item;

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
