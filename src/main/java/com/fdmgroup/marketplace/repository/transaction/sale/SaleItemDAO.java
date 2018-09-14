package com.fdmgroup.marketplace.repository.transaction.sale;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.sale.SaleItem;
import com.fdmgroup.marketplace.repository.CRUD;

public class SaleItemDAO implements CRUD<SaleItem> {

	private EntityManager entityManager;

	public SaleItemDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(SaleItem saleItem) {
		entityManager.getTransaction().begin();
		entityManager.persist(saleItem);
		entityManager.getTransaction().commit();
	}

	@Override
	public SaleItem retrieveOne(long id) {
		return entityManager.find(SaleItem.class, id);
	}

	@Override
	public List<SaleItem> retrieveAll() {
		return entityManager.createQuery(
				"select a from SaleItem a", SaleItem.class).getResultList();
	}
	
	public List<SaleItem> retrieveAllBySaleId() {
		return entityManager.createQuery(
				"SELECT si FROM SaleItem si JOIN si.sale sa WHERE sa.id = :id", SaleItem.class).getResultList();
	}

	@Override
	public void update(SaleItem saleItem) {
		entityManager.getTransaction().begin();
		entityManager.merge(saleItem);
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
		SaleItem saleItem = entityManager.find(SaleItem.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(saleItem);
		entityManager.getTransaction().commit();
	}

}
