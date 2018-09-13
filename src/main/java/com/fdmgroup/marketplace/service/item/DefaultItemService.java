package com.fdmgroup.marketplace.service.item;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.item.ItemDAO;

public class DefaultItemService implements ItemService {
	CRUD<Item> itemDAO;
	
	DefaultItemService(EntityManager entityManager) {
		itemDAO = new ItemDAO(entityManager);
	}

	@Override
	public void create(Item item) {
		itemDAO.create(item);
	}

	@Override
	public Item retrieveOne(long id) {
		return itemDAO.retrieveOne(id);
	}

	@Override
	public List<Item> retrieveAll() {
		return itemDAO.retrieveAll();
	}

	@Override
	public void update(Item item) {
		itemDAO.update(item);
	}

	@Override
	public void delete(long id) {
		itemDAO.delete(id);
	}
	
}
