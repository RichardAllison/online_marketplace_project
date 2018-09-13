package com.fdmgroup.marketplace.service.transaction.purchase;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.transaction.purchase.PurchaseItem;

public interface PurchaseItemService {

	public void addItemToPurchase(Purchase purchase, PurchaseItem purchaseItem);
	public List<PurchaseItem> getAllItemsInPurchase(Purchase purchase);
	public void updateItemInPurchase(Purchase purchase, PurchaseItem purchaseItem);
	public void removeItemFromPurchase(Purchase purchase, PurchaseItem purchaseItem);
	
}
