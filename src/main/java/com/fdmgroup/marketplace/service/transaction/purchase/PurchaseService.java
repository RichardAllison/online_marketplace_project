package com.fdmgroup.marketplace.service.transaction.purchase;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.Purchase;

public interface PurchaseService {

	public void newPurchase(Purchase purchase);
	public Purchase retrievePurchase(long id);
	public List<Purchase> retrieveAllPurchases();
	public void updatePurchase(Purchase purchase);
	public void deletePurchase(long id);
	
}
