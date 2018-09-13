package com.fdmgroup.marketplace.service.transaction.sale;

import java.util.List;

import javax.persistence.EntityManager;

import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.model.transaction.sale.SaleItem;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.repository.transaction.sale.SaleDAO;

public class DefaultSaleService implements SaleService, SaleItemService {
	
	private CRUD<Sale> saleDAO;
	
	public DefaultSaleService(EntityManager entityManager) {
		saleDAO = new SaleDAO(entityManager);
	}

	@Override
	public void newSale(Sale sale) {
		saleDAO.create(sale);
	}

	@Override
	public Sale retrieveSale(long id) {
		return saleDAO.retrieveOne(id);
	}

	@Override
	public List<Sale> retrieveAllSales() {
		return saleDAO.retrieveAll();
	}

	@Override
	public void updateSale(Sale sale) {
		saleDAO.update(sale);
	}

	@Override
	public void deleteSale(long id) {
		saleDAO.delete(id);
	}

	@Override
	public void addItemToSale(Sale sale, SaleItem saleItem) {
		List<SaleItem> saleItems = sale.getSaleItems();
		saleItems.add(saleItem);
		saleDAO.update(sale);		
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
		saleDAO.update(sale);
	}

	@Override
	public void removeItemFromSale(Sale sale, SaleItem saleItem) {
		List<SaleItem> saleItems = sale.getSaleItems();
		int itemIndex = saleItems.indexOf(saleItem);
		saleItems.remove(itemIndex);
		saleDAO.update(sale);
	}
	
}
