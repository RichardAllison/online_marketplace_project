package com.fdmgroup.marketplace.service.transaction.sale;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.Sale;

public interface SaleService {

	public void create(Sale order);
	public Sale retrieveOne(long id);
	public List<Sale> retrieveAll();
	public void update(Sale order);
	public void delete(long id);
	
}
