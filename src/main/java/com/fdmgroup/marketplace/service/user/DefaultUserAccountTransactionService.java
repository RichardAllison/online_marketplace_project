package com.fdmgroup.marketplace.service.user;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.CRUD;

public class DefaultUserAccountTransactionService implements UserAccountPurchaseService, UserAccountSaleService {

	private CRUD<UserAccount> userAccountCRUD;
	
	public DefaultUserAccountTransactionService(CRUD<UserAccount> userAccountCRUD) {
		this.userAccountCRUD = userAccountCRUD;
	}
	
	@Override
	public void addNewUserSale(UserAccount userAccount, Sale sale) {
		List<Sale> sales = userAccount.getSales();
		sales.add(sale);
		userAccountCRUD.update(userAccount);
	}

	@Override
	public List<Sale> getAllUserSales(UserAccount userAccount) {
		return userAccount.getSales();
	}

	@Override
	public void updateUserSale(UserAccount userAccount, Sale sale) {
		List<Sale> sales = userAccount.getSales();
		int itemIndex = sales.indexOf(sale);
		Sale saleToUpdate = sales.get(itemIndex);
		saleToUpdate.setBuyer(sale.getBuyer());
		saleToUpdate.setTime(sale.getTime());
		userAccountCRUD.update(userAccount);
	}

	@Override
	public void removeUserSale(UserAccount userAccount, Sale sale) {
		List<Sale> sales = userAccount.getSales();
		int saleIndex = sales.indexOf(sale);
		sales.remove(saleIndex);
		userAccountCRUD.update(userAccount);
	}

	@Override
	public void addNewUserPurchase(UserAccount userAccount, Purchase purchase) {
		List<Purchase> purchases = userAccount.getPurchases();
		purchases.add(purchase);
		userAccountCRUD.update(userAccount);
	}

	@Override
	public List<Purchase> getAllUserPurchases(UserAccount userAccount) {
		return userAccount.getPurchases();
	}

	@Override
	public void updateUserPurchase(UserAccount userAccount, Purchase purchase) {
		List<Purchase> purchases = userAccount.getPurchases();
		int purchaseIndex = purchases.indexOf(purchase);
		Purchase purchaseToUpdate = purchases.get(purchaseIndex);
		purchaseToUpdate.setTime(purchase.getTime());
		userAccountCRUD.update(userAccount);
	}

	@Override
	public void removeUserPurchase(UserAccount userAccount, Purchase purchase) {
		List<Purchase> purchases = userAccount.getPurchases();
		int purchaseIndex = purchases.indexOf(purchase);
		purchases.remove(purchaseIndex);
		userAccountCRUD.update(userAccount);
	}

}
