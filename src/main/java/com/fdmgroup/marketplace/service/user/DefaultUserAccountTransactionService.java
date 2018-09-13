package com.fdmgroup.marketplace.service.user;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.Purchase;
import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

public class DefaultUserAccountTransactionService implements UserAccountPurchaseService, UserAccountSaleService {

	private UserAccountDAO userAccountDAO;
	
	public DefaultUserAccountTransactionService(EntityManager entityManager) {
		userAccountDAO = new UserAccountDAO(entityManager);
	}
	
	@Override
	public void addNewUserSale(UserAccount userAccount, Sale sale) {
		List<Sale> sales = userAccount.getSales();
		sales.add(sale);
		userAccountDAO.update(userAccount);
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
		userAccountDAO.update(userAccount);
	}

	@Override
	public void removeUserSale(UserAccount userAccount, Sale sale) {
		List<Sale> sales = userAccount.getSales();
		int saleIndex = sales.indexOf(sale);
		sales.remove(saleIndex);
		userAccountDAO.update(userAccount);
	}

	@Override
	public void addNewUserPurchase(UserAccount userAccount, Purchase purchase) {
		List<Purchase> purchases = userAccount.getPurchases();
		purchases.add(purchase);
		userAccountDAO.update(userAccount);
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
		userAccountDAO.update(userAccount);
	}

	@Override
	public void removeUserPurchase(UserAccount userAccount, Purchase purchase) {
		List<Purchase> purchases = userAccount.getPurchases();
		int purchaseIndex = purchases.indexOf(purchase);
		purchases.remove(purchaseIndex);
		userAccountDAO.update(userAccount);
	}

}
