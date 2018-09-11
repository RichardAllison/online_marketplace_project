package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.Sale;

public class SaleDAO implements CRUD<Sale> {
	
	private EntityManager entityManager;

	public SaleDAO(EntityManager entityManager){
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
				"select a from Sale a", Sale.class).getResultList();
	}

	@Override
	public void update(Sale order) {
		entityManager.merge(order);
	}

	@Override
	public void delete(long id) {
		Sale order = entityManager.find(Sale.class, id);
		entityManager.remove(order);
	}

	public List<Sale> retrieveAllByUserId(long id) {
			return entityManager.createQuery(
					"SELECT i FROM Sale i JOIN i.seller u WHERE u.id = :id", Sale.class)
			.setParameter("id", id)
			.getResultList();
	}

}
