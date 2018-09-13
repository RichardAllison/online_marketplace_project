package com.fdmgroup.marketplace.service.transaction.sale;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.sale.Sale;

public interface SaleService {

	public void newSale(Sale order);
	public Sale retrieveSale(long id);
	public List<Sale> retrieveAllSales();
	public void updateSale(Sale order);
	public void deleteSale(long id);
	
}
