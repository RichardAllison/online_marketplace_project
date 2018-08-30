package com.fdmgroup.marketplace.models.items;

import java.math.BigDecimal;

public class Product {

	private BigDecimal price;
	private int quantity;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
