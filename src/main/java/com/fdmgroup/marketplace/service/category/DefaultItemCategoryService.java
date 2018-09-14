package com.fdmgroup.marketplace.service.category;

import java.util.List;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.repository.CRUD;

public class DefaultItemCategoryService implements ItemCategoryService {

	private CRUD<ItemCategory> itemCategoryCRUD;
	
	public DefaultItemCategoryService(CRUD<ItemCategory> itemCategoryCRUD) {
		this.itemCategoryCRUD = itemCategoryCRUD;
	}

	@Override
	public void createItemCategory(ItemCategory itemCategory) {
		itemCategoryCRUD.create(itemCategory);
	}

	@Override
	public ItemCategory retrieveItemCategory(long id) {
		return itemCategoryCRUD.retrieveOne(id);
	}

	@Override
	public List<ItemCategory> retrieveAllItemCategories() {
		return itemCategoryCRUD.retrieveAll();
	}

	@Override
	public void updateItemCategory(ItemCategory itemCategory) {
		itemCategoryCRUD.update(itemCategory);
	}

	@Override
	public void deleteItemCategory(long id) {
		itemCategoryCRUD.delete(id);
	}
	
}
