package com.fdmgroup.marketplace.service.transaction.purchase;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.Purchase;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.transaction.PurchaseDAO;

public class DefaultPurchaseService implements PurchaseService {
	CRUD<Purchase> purchaseDAO;
	
	DefaultPurchaseService(EntityManager entityManager) {
		purchaseDAO = new PurchaseDAO(entityManager);
	}
}
