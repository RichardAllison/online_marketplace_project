package com.fdmgroup.marketplace.repository.transaction.purchase;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.purchase.PurchaseItem;
import com.fdmgroup.marketplace.repository.CRUD;

public class PurchaseItemDAO implements CRUD<PurchaseItem> {

	private EntityManager entityManager;

	public PurchaseItemDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(PurchaseItem purchaseItem) {
		entityManager.persist(purchaseItem);
	}

	@Override
	public PurchaseItem retrieveOne(long id) {
		return entityManager.find(PurchaseItem.class, id);
	}

	@Override
	public List<PurchaseItem> retrieveAll() {
		return entityManager.createQuery(
				"select a from PurchaseItem a", PurchaseItem.class).getResultList();
	}

	@Override
	public void update(PurchaseItem purchaseItem) {
		entityManager.merge(purchaseItem);
	}

	@Override
	public void delete(long id) {
		PurchaseItem purchaseItem = entityManager.find(PurchaseItem.class, id);
		entityManager.remove(purchaseItem);
	}


}
