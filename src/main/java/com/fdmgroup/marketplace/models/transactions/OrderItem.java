package com.fdmgroup.marketplace.models.transactions;

import com.fdmgroup.marketplace.models.items.Item;

public class OrderItem {

	private long orderItemId;
	private Item item;
	private int quantity;

	public long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
