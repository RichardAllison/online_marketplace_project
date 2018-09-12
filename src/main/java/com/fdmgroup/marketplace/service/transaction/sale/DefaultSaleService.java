package com.fdmgroup.marketplace.service.transaction.sale;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.transaction.SaleDAO;

public class DefaultSaleService implements SaleService {
	CRUD<Sale> saleDAO;
	
	DefaultSaleService(EntityManager entityManager) {
		saleDAO = new SaleDAO(entityManager);
	}
}
