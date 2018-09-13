package com.fdmgroup.marketplace.service.transaction.purchase;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.Purchase;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.transaction.purchase.PurchaseDAO;

public class DefaultPurchaseService implements PurchaseService {
	CRUD<Purchase> purchaseDAO;
	
	DefaultPurchaseService(EntityManager entityManager) {
		purchaseDAO = new PurchaseDAO(entityManager);
	}

	@Override
	public void create(Purchase purchase) {
		purchaseDAO.create(purchase);
	}

	@Override
	public Purchase retrieveOne(long id) {
		return purchaseDAO.retrieveOne(id);
	}

	@Override
	public List<Purchase> retrieveAll() {
		return purchaseDAO.retrieveAll();
	}

	@Override
	public void update(Purchase purchase) {
		purchaseDAO.update(purchase);
	}

	@Override
	public void delete(long id) {
		purchaseDAO.delete(id);
	}

}
