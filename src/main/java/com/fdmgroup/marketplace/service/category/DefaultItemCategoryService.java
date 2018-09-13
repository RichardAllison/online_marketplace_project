package com.fdmgroup.marketplace.service.category;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.category.ItemCategoryDAO;

public class DefaultItemCategoryService implements ItemCategoryService {

	private CRUD<ItemCategory> itemCategoryDAO;
	
	public DefaultItemCategoryService(EntityManager entityManager) {
		itemCategoryDAO = new ItemCategoryDAO(entityManager);
	}

	@Override
	public void createItemCategory(ItemCategory itemCategory) {
		itemCategoryDAO.create(itemCategory);
	}

	@Override
	public ItemCategory retrieveItemCategory(long id) {
		return itemCategoryDAO.retrieveOne(id);
	}

	@Override
	public List<ItemCategory> retrieveAllItemCategories() {
		return itemCategoryDAO.retrieveAll();
	}

	@Override
	public void updateItemCategory(ItemCategory itemCategory) {
		itemCategoryDAO.update(itemCategory);
	}

	@Override
	public void deleteItemCategory(long id) {
		itemCategoryDAO.delete(id);
	}
	
}
