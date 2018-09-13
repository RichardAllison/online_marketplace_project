package com.fdmgroup.marketplace.service.transaction.sale;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.transaction.sale.SaleDAO;

public class DefaultSaleService implements SaleService {
	
	CRUD<Sale> saleDAO;
	
	DefaultSaleService(EntityManager entityManager) {
		saleDAO = new SaleDAO(entityManager);
	}

	@Override
	public void create(Sale sale) {
		saleDAO.create(sale);
	}

	@Override
	public Sale retrieveOne(long id) {
		return saleDAO.retrieveOne(id);
	}

	@Override
	public List<Sale> retrieveAll() {
		return saleDAO.retrieveAll();
	}

	@Override
	public void update(Sale sale) {
		saleDAO.update(sale);
	}

	@Override
	public void delete(long id) {
		saleDAO.delete(id);
	}
	
}
