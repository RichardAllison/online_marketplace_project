package com.fdmgroup.marketplace.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.SaleItem;

public class SaleItemDAO implements CRUD<SaleItem> {

	private EntityManager entityManager;

	public SaleItemDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void create(SaleItem saleItem) {
		entityManager.persist(saleItem);
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
	public void update(long id, SaleItem saleItem) {
		entityManager.merge(saleItem);
	}

	@Override
	public void delete(long id) {
		SaleItem saleItem = entityManager.find(SaleItem.class, id);
		entityManager.remove(saleItem);
	}


}
