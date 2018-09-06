package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.SaleItem;

public class TransactionItemDAO implements CRUD<SaleItem> {

	private EntityManager entityManager;

	public TransactionItemDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(SaleItem orderItem) {
		entityManager.persist(orderItem);
	}

	@Override
	public SaleItem retrieveOne(long id) {
		return entityManager.find(SaleItem.class, id);
	}

	@Override
	public List<SaleItem> retrieveAll() {
		return entityManager.createQuery(
				"select a from TransactionItem a", SaleItem.class).getResultList();
	}

	@Override
	public void update(long id, SaleItem orderItem) {
		entityManager.merge(orderItem);
	}

	@Override
	public void delete(long id) {
		SaleItem orderItem = entityManager.find(SaleItem.class, id);
		entityManager.remove(orderItem);
	}


}
