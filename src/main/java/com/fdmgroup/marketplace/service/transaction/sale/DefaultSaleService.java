package com.fdmgroup.marketplace.service.transaction.sale;

import java.util.List;

import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.model.transaction.sale.SaleItem;
import com.fdmgroup.marketplace.repository.CRUD;

public class DefaultSaleService implements SaleService, SaleItemService {
	
	private CRUD<Sale> saleCRUD;
	
	public DefaultSaleService(CRUD<Sale> saleCRUD) {
		this.saleCRUD = saleCRUD;
	}
	
	@Override
	public void newSale(Sale sale) {
		saleCRUD.create(sale);
	}

	@Override
	public Sale retrieveSale(long id) {
		return saleCRUD.retrieveOne(id);
	}

	@Override
	public List<Sale> retrieveAllSales() {
		return saleCRUD.retrieveAll();
	}

	@Override
	public void updateSale(Sale sale) {
		saleCRUD.update(sale);
	}

	@Override
	public void deleteSale(long id) {
		saleCRUD.delete(id);
	}

	@Override
	public void addItemToSale(Sale sale, SaleItem saleItem) {
		List<SaleItem> saleItems = sale.getSaleItems();
		saleItems.add(saleItem);
		saleCRUD.update(sale);		
	}

	@Override
	public List<SaleItem> getAllItemsInSale(Sale sale) {
		return sale.getSaleItems();
	}

	@Override
	public void updateItemInSale(Sale sale, SaleItem saleItem) {
		List<SaleItem> saleItems = sale.getSaleItems();
		int itemIndex = saleItems.indexOf(saleItem);
		SaleItem itemToUpdate = saleItems.get(itemIndex);
		itemToUpdate.setQuantity(saleItem.getQuantity());
		saleCRUD.update(sale);
	}

	@Override
	public void removeItemFromSale(Sale sale, SaleItem saleItem) {
		List<SaleItem> saleItems = sale.getSaleItems();
		int itemIndex = saleItems.indexOf(saleItem);
		saleItems.remove(itemIndex);
		saleCRUD.update(sale);
	}
	
}
