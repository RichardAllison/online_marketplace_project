package com.fdmgroup.marketplace.service.user;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.model.user.UserAccount;

public interface UserAccountSaleService {
	
	public void addNewUserSale(UserAccount userAccount, Sale sale);
	public List<Sale> getAllUserSales(UserAccount userAccount);
	public void updateUserSale(UserAccount userAccount, Sale sale);
	public void removeUserSale(UserAccount userAccount, Sale sale);

}
