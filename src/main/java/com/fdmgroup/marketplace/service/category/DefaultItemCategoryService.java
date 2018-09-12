package com.fdmgroup.marketplace.service.category;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.category.ItemCategoryDAO;

public class DefaultItemCategoryService implements ItemCategoryService {

	CRUD<ItemCategory> categoryDAO;
	
	DefaultItemCategoryService(EntityManager entityManager) {
		categoryDAO = new ItemCategoryDAO(entityManager);
	}
	
}
