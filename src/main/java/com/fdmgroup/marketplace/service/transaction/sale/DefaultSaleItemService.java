package com.fdmgroup.marketplace.service.transaction.sale;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.SaleItem;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.transaction.sale.SaleItemDAO;

public class DefaultSaleItemService implements SaleItemService {

	CRUD<SaleItem> saleItemDAO;
	
	DefaultSaleItemService(EntityManager entityManager) {
		saleItemDAO = new SaleItemDAO(entityManager);
	}
	
	@Override
	public void create(SaleItem saleItem) {
		saleItemDAO.create(saleItem);
	}

	@Override
	public SaleItem retrieveOne(long id) {
		return saleItemDAO.retrieveOne(id);
	}

	@Override
	public List<SaleItem> retrieveAll() {
		return saleItemDAO.retrieveAll();
	}

	@Override
	public void update(SaleItem saleItem) {
		saleItemDAO.update(saleItem);
	}

	@Override
	public void delete(long id) {
		saleItemDAO.delete(id);
	}

}
