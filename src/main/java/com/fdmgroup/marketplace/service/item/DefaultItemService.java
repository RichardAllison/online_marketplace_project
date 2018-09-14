package com.fdmgroup.marketplace.service.item;

import java.util.List;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.repository.CRUD;

public class DefaultItemService implements ItemService {
	
	private CRUD<Item> itemCRUD;
	
	public DefaultItemService(CRUD<Item> itemCRUD) {
		this.itemCRUD = itemCRUD;
	}

	@Override
	public void createItem(Item item) {
		itemCRUD.create(item);
	}

	@Override
	public Item retrieveItem(long id) {
		return itemCRUD.retrieveOne(id);
	}

	@Override
	public List<Item> retrieveAllItems() {
		return itemCRUD.retrieveAll();
	}

	@Override
	public void updateItem(Item item) {
		itemCRUD.update(item);
	}

	@Override
	public void deleteItem(long id) {
		itemCRUD.delete(id);
	}
	
}
