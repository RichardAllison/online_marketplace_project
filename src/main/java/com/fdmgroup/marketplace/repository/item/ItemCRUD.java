package com.fdmgroup.marketplace.repository.item;

import java.util.List;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.repository.CRUD;

public interface ItemCRUD extends CRUD<Item> {
	
	public List<Item> searchForItemsByName(String name);
	public List<Item> retrieveAllByUserId(long id);

}
