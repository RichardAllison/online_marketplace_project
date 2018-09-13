package com.fdmgroup.marketplace.service.transaction.sale;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.SaleItem;

public interface SaleItemService {

	public void create(SaleItem saleItem);
	public SaleItem retrieveOne(long id);
	public List<SaleItem> retrieveAll();
	public void update(SaleItem saleItem);
	public void delete(long id);

}
