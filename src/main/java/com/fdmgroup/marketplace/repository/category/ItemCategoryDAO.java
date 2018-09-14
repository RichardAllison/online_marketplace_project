package com.fdmgroup.marketplace.repository.category;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.repository.CRUD;

public class ItemCategoryDAO implements CRUD<ItemCategory> {
	
	private EntityManager entityManager;

	public ItemCategoryDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(ItemCategory category) {
		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.getTransaction().commit();
	}

	@Override
	public ItemCategory retrieveOne(long id) {
		return entityManager.find(ItemCategory.class, id);
	}

	@Override
	public List<ItemCategory> retrieveAll() {
		return entityManager.createQuery(
				"select a from ItemCategory a", ItemCategory.class).getResultList();
	}

	@Override
	public void update(ItemCategory category) {
		entityManager.getTransaction().begin();
		entityManager.merge(category);
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
		ItemCategory category = entityManager.find(ItemCategory.class, id);
		entityManager.remove(category);
	}

}
