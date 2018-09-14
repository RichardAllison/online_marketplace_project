package com.fdmgroup.marketplace.repository.transaction.sale;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.repository.CRUD;

public class SaleDAO implements CRUD<Sale> {

	private EntityManager entityManager;

	public SaleDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void create(Sale sale) {
		entityManager.getTransaction().begin();
		entityManager.persist(sale);
		entityManager.getTransaction().commit();
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
		entityManager.getTransaction().begin();
		entityManager.merge(order);
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
		Sale order = entityManager.find(Sale.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(order);
		entityManager.getTransaction().commit();
	}

	public List<Sale> retrieveAllByUserId(long id) {
		return entityManager.createNamedQuery(
				"Sale.getAllByUserId", Sale.class)
				.setParameter("id", id)
				.getResultList();
	}

}
