package com.fdmgroup.marketplace.service.category;

import java.util.List;

import com.fdmgroup.marketplace.model.category.ItemCategory;

public interface ItemCategoryService {

	public void createItemCategory(ItemCategory category);
	public ItemCategory retrieveItemCategory(long id);
	public List<ItemCategory> retrieveAllItemCategories();
	public void updateItemCategory(ItemCategory category);
	public void deleteItemCategory(long id);
	
}
