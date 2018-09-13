package com.fdmgroup.marketplace.service.user;

import java.util.List;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.user.UserAccount;

public interface UserAccountProductService {

	public void addNewUserProduct(UserAccount userAccount, Item item);
	public List<Item> getAllUserProducts(UserAccount userAccount);
	public void updateUserProduct(UserAccount userAccount, Item item);
	public void removeUserProduct(UserAccount userAccount, Item item);

}
