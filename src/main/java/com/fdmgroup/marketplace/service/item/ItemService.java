package com.fdmgroup.marketplace.service.item;

import java.util.List;

import com.fdmgroup.marketplace.model.item.Item;

public interface ItemService {

	public void create(Item item);
	public Item retrieveOne(long id);
	public List<Item> retrieveAll();
//	public List<Item> searchForItemsByName(String name);
//	public List<Item> retrieveAllByUserId(long id);
	public void update(Item item);
	public void delete(long id);
}
