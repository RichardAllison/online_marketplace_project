package com.fdmgroup.marketplace.service.item;

import java.util.List;

import com.fdmgroup.marketplace.model.item.Item;

public interface ItemService {

	public void createItem(Item item);
	public Item retrieveItem(long id);
	public List<Item> retrieveAllItems();
//	public List<Item> searchForItemsByName(String name);
//	public List<Item> retrieveAllByUserId(long id);
	public void updateItem(Item item);
	public void deleteItem(long id);
}
