package com.fdmgroup.marketplace.service.transaction.sale;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.model.transaction.SaleItem;

public interface SaleItemService {

	public void addItemToSale(Sale sale, SaleItem saleItem);
	public List<SaleItem> getAllItemsInSale(Sale sale);
	public void updateItemInSale(Sale sale, SaleItem saleItem);
	public void removeItemFromSale(Sale sale, SaleItem saleItem);

}
