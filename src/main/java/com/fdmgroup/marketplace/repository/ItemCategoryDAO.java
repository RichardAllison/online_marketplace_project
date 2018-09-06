package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.category.ItemCategory;

public class ItemCategoryDAO implements CRUD<ItemCategory> {
	
	private EntityManager entityManager;

	public ItemCategoryDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(ItemCategory category) {
		entityManager.persist(category);
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
	public void update(long id, ItemCategory category) {
		entityManager.merge(category);
	}

	@Override
	public void delete(long id) {
		ItemCategory category = entityManager.find(ItemCategory.class, id);
		entityManager.remove(category);
	}

}
