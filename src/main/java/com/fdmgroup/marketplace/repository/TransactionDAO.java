package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.Sale;

public class TransactionDAO implements CRUD<Sale> {
	
	private EntityManager entityManager;

	public TransactionDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void create(Sale order) {
		entityManager.persist(order);
	}

	@Override
	public Sale retrieveOne(long id) {
		return entityManager.find(Sale.class, id);
	}

	@Override
	public List<Sale> retrieveAll() {
		return entityManager.createQuery(
				"select a from Transaction a", Sale.class).getResultList();
	}

	@Override
	public void update(long id, Sale order) {
		entityManager.merge(order);
	}

	@Override
	public void delete(long id) {
		Sale order = entityManager.find(Sale.class, id);
		entityManager.remove(order);
	}

}
