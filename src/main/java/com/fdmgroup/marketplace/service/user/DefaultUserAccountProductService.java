package com.fdmgroup.marketplace.service.user;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class DefaultUserAccountProductService implements UserAccountProductService {

	private UserAccountDAO userAccountDAO;
	
	public DefaultUserAccountProductService(EntityManager entityManager) {
		userAccountDAO = new UserAccountDAO(entityManager);
	}
	
	@Override
	public void addNewUserProduct(UserAccount userAccount, Item item) {
		List<Item> products = userAccount.getProducts();
		products.add(item);
		userAccountDAO.update(userAccount);
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
		userAccountDAO.update(userAccount);
	}

	@Override
	public void removeUserProduct(UserAccount userAccount, Item item) {
		List<Item> products = userAccount.getProducts();
		int productIndex = products.indexOf(item);
		products.remove(productIndex);
		userAccountDAO.update(userAccount);	
	}

}
