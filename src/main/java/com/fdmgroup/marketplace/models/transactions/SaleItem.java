package com.fdmgroup.marketplace.models.transactions;

//import java.math.BigDecimal;

import com.fdmgroup.marketplace.models.items.Item;

public class SaleItem {

	private long saleItemId;
	private Item item;
	private int quantity;
//	private BigDecimal price;

	public long getSaleItemId() {
		return saleItemId;
	}

	public void setSaleItemId(long saleItemId) {
		this.saleItemId = saleItemId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
//		this.price = item.getPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
