package com.fdmgroup.marketplace.service.user;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.user.UserAccount;

public interface UserAccountPurchaseService {
	
	public void addNewUserPurchase(UserAccount userAccount, Purchase purchase);
	public List<Purchase> getAllUserPurchases(UserAccount userAccount);
	public void updateUserPurchase(UserAccount userAccount, Purchase purchase);
	public void removeUserPurchase(UserAccount userAccount, Purchase purchase);

}
