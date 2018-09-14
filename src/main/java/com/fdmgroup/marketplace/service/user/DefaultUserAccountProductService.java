package com.fdmgroup.marketplace.service.user;

import java.util.List;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CRUD;

public class DefaultUserAccountProductService implements UserAccountProductService {

	private CRUD<UserAccount> userAccountCRUD;
	
	public DefaultUserAccountProductService(CRUD<UserAccount> userAccountCRUD) {
		this.userAccountCRUD = userAccountCRUD;
	}
	
	@Override
	public void addNewUserProduct(UserAccount userAccount, Item item) {
		List<Item> products = userAccount.getProducts();
		products.add(item);
		userAccountCRUD.update(userAccount);
	}

	@Override
	public List<Item> getAllUserProducts(UserAccount userAccount) {
		return userAccount.getProducts();
	}

	@Override
	public void updateUserProduct(UserAccount userAccount, Item item) {
		List<Item> products = userAccount.getProducts();
		int productIndex = products.indexOf(item);
		Item productToUpdate = products.get(productIndex);
		productToUpdate.setName(item.getName());
		productToUpdate.setDescription(item.getDescription());
		productToUpdate.setPrice(item.getPrice());
		productToUpdate.setQuantity(item.getQuantity());
		productToUpdate.setQuantityReserved(item.getQuantityReserved());
		userAccountCRUD.update(userAccount);
	}

	@Override
	public void removeUserProduct(UserAccount userAccount, Item item) {
		List<Item> products = userAccount.getProducts();
		int productIndex = products.indexOf(item);
		products.remove(productIndex);
		userAccountCRUD.update(userAccount);	
	}

}
