package com.fdmgroup.marketplace.service.transaction.purchase;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.transaction.purchase.PurchaseItem;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.transaction.purchase.PurchaseDAO;

public class DefaultPurchaseService implements PurchaseService, PurchaseItemService {

	private CRUD<Purchase> purchaseDAO;
	
	public DefaultPurchaseService(EntityManager entityManager) {
		purchaseDAO = new PurchaseDAO(entityManager);
	} 

	@Override
	public void newPurchase(Purchase purchase) {
		purchaseDAO.create(purchase);
	}

	@Override
	public Purchase retrievePurchase(long id) {
		return purchaseDAO.retrieveOne(id);
	}

	@Override
	public List<Purchase> retrieveAllPurchases() {
		return purchaseDAO.retrieveAll();
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		purchaseDAO.update(purchase);
	}

	@Override
	public void deletePurchase(long id) {
		purchaseDAO.delete(id);
	}

	@Override
	public void addItemToPurchase(Purchase purchase, PurchaseItem purchaseItem) {
		List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
		if (purchaseItem.getQuantity() > 0) {
			purchaseItems.add(purchaseItem);
			purchaseDAO.update(purchase);
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
		purchaseDAO.update(purchase);
	}

	@Override
	public void removeItemFromPurchase(Purchase purchase, PurchaseItem purchaseItem) {
		List<PurchaseItem> purchaseItems = purchase.getPurchaseItems();
		int itemIndex = purchaseItems.indexOf(purchaseItem);
		purchaseItems.remove(itemIndex);
		purchaseDAO.update(purchase);
	}


}
