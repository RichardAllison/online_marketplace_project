package com.fdmgroup.marketplace.models.transactions;

//import java.math.BigDecimal;

import com.fdmgroup.marketplace.models.items.Item;

public class OrderItem {

	private long id;
	private Item item;
	private int quantity;
//	private AccountUser seller;
//	private BigDecimal price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
