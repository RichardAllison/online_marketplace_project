package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	        "SELECT a FROM Item a WHERE a.name LIKE :name", Item.class)
	        .setParameter("name", name)
	        .getResultList();
	}
	
	public List<Item> retrieveAllByUserId(long id) {
		TypedQuery<Item> q = entityManager.createQuery(
				"SELECT i FROM Item i JOIN i.seller u WHERE u.id = :id", Item.class);
		
		q = q.setParameter("id", id);
		List<Item> items = q.getResultList();
		return items;
	}
	
	@Override
	public void update(Item item) {
		entityManager.merge(item);
	}

	@Override
	public void delete(long id) {
		Item item = entityManager.find(Item.class, id);
		entityManager.remove(item);
	}
}
