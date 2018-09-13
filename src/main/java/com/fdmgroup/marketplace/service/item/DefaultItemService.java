package com.fdmgroup.marketplace.service.item;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.item.ItemDAO;

public class DefaultItemService implements ItemService {
	CRUD<Item> itemDAO;
	
	public DefaultItemService(EntityManager entityManager) {
		itemDAO = new ItemDAO(entityManager);
	}

	@Override
	public void createItem(Item item) {
		itemDAO.create(item);
	}

	@Override
	public Item retrieveItem(long id) {
		return itemDAO.retrieveOne(id);
	}

	@Override
	public List<Item> retrieveAllItems() {
		return itemDAO.retrieveAll();
	}

	@Override
	public void updateItem(Item item) {
		itemDAO.update(item);
	}

	@Override
	public void deleteItem(long id) {
		itemDAO.delete(id);
	}
	
}
