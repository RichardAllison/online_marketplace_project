package com.fdmgroup.marketplace.service.transaction.purchase;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.PurchaseItem;

public interface PurchaseItemService {

	public void create(PurchaseItem purchaseItem);
	public PurchaseItem retrieveOne(long id);
	public List<PurchaseItem> retrieveAll();
	public void update(PurchaseItem purchaseItem);
	public void delete(long id);
	
}
