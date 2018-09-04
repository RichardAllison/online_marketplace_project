package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.models.categories.Category;

public class CategoryDAO implements CRUD<Category> {
	
	private EntityManager entityManager;

	public CategoryDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(Category category) {
		entityManager.persist(category);
	}

	@Override
	public Category retrieveOne(long id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public List<Category> retrieveAll() {
		return entityManager.createQuery(
				"select a from Category a", Category.class).getResultList();
	}

	@Override
	public void update(long id, Category category) {
		entityManager.merge(category);
	}

	@Override
	public void delete(long id) {
		Category category = entityManager.find(Category.class, id);
		entityManager.remove(category);
	}

}
