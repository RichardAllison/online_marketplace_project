package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.models.transactions.TransactionItem;

public class TransactionItemDAO implements CRUD<TransactionItem> {

	private EntityManager entityManager;

	public TransactionItemDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(TransactionItem orderItem) {
		entityManager.persist(orderItem);
	}

	@Override
	public TransactionItem retrieveOne(long id) {
		return entityManager.find(TransactionItem.class, id);
	}

	@Override
	public List<TransactionItem> retrieveAll() {
		return entityManager.createQuery(
				"select a from OrderItem a", TransactionItem.class).getResultList();
	}

	@Override
	public void update(long id, TransactionItem orderItem) {
		entityManager.merge(orderItem);
	}

	@Override
	public void delete(long id) {
		TransactionItem orderItem = entityManager.find(TransactionItem.class, id);
		entityManager.remove(orderItem);
	}


}
