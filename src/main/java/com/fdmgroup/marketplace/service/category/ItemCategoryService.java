package com.fdmgroup.marketplace.service.category;

import java.util.List;

import com.fdmgroup.marketplace.model.category.ItemCategory;

public interface ItemCategoryService {

	public void create(ItemCategory category);
	public ItemCategory retrieveOne(long id);
	public List<ItemCategory> retrieveAll();
	public void update(ItemCategory category);
	public void delete(long id);
	
}
