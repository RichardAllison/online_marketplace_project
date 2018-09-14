package com.fdmgroup.marketplace.repository.item;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.repository.CRUD;

public class ItemDAO implements CRUD<Item> {

	private EntityManager entityManager;

	public ItemDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void create(Item item) {
		entityManager.getTransaction().begin();
		entityManager.persist(item);
		entityManager.getTransaction().commit();
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
		return entityManager.createNamedQuery(
				"Item.searchItemsByName", Item.class)
				.setParameter("name", name)
				.getResultList();
	}

	public List<Item> retrieveAllByUserId(long id) {
		return entityManager.createNamedQuery(
				"Item.getItemsByUserId", Item.class)
				.setParameter("id", id)
				.getResultList();
	}

	@Override
	public void update(Item item) {
		entityManager.getTransaction().begin();
		entityManager.merge(item);
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
		Item item = entityManager.find(Item.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(item);
		entityManager.getTransaction().commit();
	}
}
