package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.models.transactions.Transaction;

public class OrderDAO implements CRUD<Transaction> {
	
	private EntityManager entityManager;

	public OrderDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void create(Transaction order) {
		entityManager.persist(order);
	}

	@Override
	public Transaction retrieveOne(long id) {
		return entityManager.find(Transaction.class, id);
	}

	@Override
	public List<Transaction> retrieveAll() {
		return entityManager.createQuery(
				"select a from Order a", Transaction.class).getResultList();
	}

	@Override
	public void update(long id, Transaction order) {
		entityManager.merge(order);
	}

	@Override
	public void delete(long id) {
		Transaction order = entityManager.find(Transaction.class, id);
		entityManager.remove(order);
	}

}
