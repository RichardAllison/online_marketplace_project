package com.fdmgroup.marketplace.service.transaction.purchase;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.Purchase;

public interface PurchaseService {

	public void create(Purchase purchase);
	public Purchase retrieveOne(long id);
	public List<Purchase> retrieveAll();
	public void update(Purchase purchase);
	public void delete(long id);
	
}
