package com.fdmgroup.marketplace.service.transaction.purchase;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.PurchaseItem;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.transaction.purchase.PurchaseItemDAO;

public class DefaultPurchaseItemService implements PurchaseItemService {

	CRUD<PurchaseItem> purchaseItemDAO;
	
	DefaultPurchaseItemService(EntityManager entityManager) {
		purchaseItemDAO = new PurchaseItemDAO(entityManager);
	}

	@Override
	public void create(PurchaseItem purchaseItem) {
		purchaseItemDAO.create(purchaseItem);
	}

	@Override
	public PurchaseItem retrieveOne(long id) {
		return purchaseItemDAO.retrieveOne(id);
	}

	@Override
	public List<PurchaseItem> retrieveAll() {
		return purchaseItemDAO.retrieveAll();
	}

	@Override
	public void update(PurchaseItem purchaseItem) {
		purchaseItemDAO.update(purchaseItem);
	}

	@Override
	public void delete(long id) {
		purchaseItemDAO.delete(id);
	}
	
}
