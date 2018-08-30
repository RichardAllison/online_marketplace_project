package com.fdmgroup.marketplace.models.transactions;

import com.fdmgroup.marketplace.models.items.Product;

public class OrderItem {

	private long orderItemId;
	private Product product;

	public long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
