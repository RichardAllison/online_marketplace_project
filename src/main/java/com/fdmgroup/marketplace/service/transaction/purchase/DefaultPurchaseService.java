package com.fdmgroup.marketplace.service.transaction.purchase;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.transaction.purchase.PurchaseItem;
import com.fdmgroup.marketplace.repository.CRUD;

public class DefaultPurchaseService implements PurchaseService, PurchaseItemService {

	private CRUD<Purchase> purchaseCRUD;
	
	public DefaultPurchaseService(CRUD<Purchase> purchaseCRUD) {
		this.purchaseCRUD = purchaseCRUD;
	} 
	
	@Override
	public void newPurchase(Purchase purchase) {
		purchaseCRUD.create(purchase);
	}

	@Override
	public Purchase retrievePurchase(long id) {
		return purchaseCRUD.retrieveOne(id);
	}

	@Override
	public List<Purchase> retrieveAllPurchases() {
		return purchaseCRUD.retrieveAll();
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		purchaseCRUD.update(purchase);
	}

	@Override
	public void deletePurchase(long id) {
		purchaseCRUD.delete(id);
	}

	@Override
	public void addItemToPurchase(Purchase purchase, PurchaseItem purchaseItem) {
		List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
		if (purchaseItem.getQuantity() > 0) {
			purchaseItems.add(purchaseItem);
			purchaseCRUD.update(purchase);
		} 
	}
	
	@Override
	public List<PurchaseItem> getAllItemsInPurchase(Purchase purchase) {
		return purchase.getPurchaseItems();
	}

	@Override
	public void updateItemInPurchase(Purchase purchase, PurchaseItem purchaseItem) {
		List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
		int itemIndex = purchaseItems.indexOf(purchaseItem);
		PurchaseItem itemToUpdate = purchaseItems.get(itemIndex);
		itemToUpdate.setQuantity(purchaseItem.getQuantity());
		purchaseCRUD.update(purchase);
	}

	@Override
	public void removeItemFromPurchase(Purchase purchase, PurchaseItem purchaseItem) {
		List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
		int itemIndex = purchaseItems.indexOf(purchaseItem);
		purchaseItems.remove(itemIndex);
		purchaseCRUD.update(purchase);
	}


}
