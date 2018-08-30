package com.fdmgroup.marketplace.models.transactions;

import java.math.BigDecimal;
import java.util.List;

import com.fdmgroup.marketplace.models.users.User;

public class Sale extends Basket {

	private long saleId;
	private User seller;
	private List<SaleItem> saleItems;

	public long getSaleId() {
		return saleId;
	}

	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public List<SaleItem> getSaleItems() {
		return saleItems;
	}

	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}

	@Override
	public BigDecimal calculateTotalCost() {
		return this.saleItems.stream().map(saleItem -> saleItem.getItem().getPrice())
				.reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));	
	}
}
