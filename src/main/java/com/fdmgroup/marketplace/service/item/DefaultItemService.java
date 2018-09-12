package com.fdmgroup.marketplace.service.item;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.item.ItemDAO;

public class DefaultItemService implements ItemService {
	CRUD<Item> itemDAO;
	
	DefaultItemService(EntityManager entityManager) {
		itemDAO = new ItemDAO(entityManager);
	}
	
}
