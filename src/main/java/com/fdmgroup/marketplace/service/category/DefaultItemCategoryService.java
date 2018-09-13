package com.fdmgroup.marketplace.service.category;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.category.ItemCategoryDAO;

public class DefaultItemCategoryService implements ItemCategoryService {

	CRUD<ItemCategory> itemCategoryDAO;
	
	DefaultItemCategoryService(EntityManager entityManager) {
		itemCategoryDAO = new ItemCategoryDAO(entityManager);
	}

	@Override
	public void create(ItemCategory itemCategory) {
		itemCategoryDAO.create(itemCategory);
	}

	@Override
	public ItemCategory retrieveOne(long id) {
		return itemCategoryDAO.retrieveOne(id);
	}

	@Override
	public List<ItemCategory> retrieveAll() {
		return itemCategoryDAO.retrieveAll();
	}

	@Override
	public void update(ItemCategory itemCategory) {
		itemCategoryDAO.update(itemCategory);
	}

	@Override
	public void delete(long id) {
		itemCategoryDAO.delete(id);
	}
	
}
