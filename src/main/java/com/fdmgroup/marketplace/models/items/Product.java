package com.fdmgroup.marketplace.models.items;

import java.math.BigDecimal;

public class Product {

	private long productId;
	private BigDecimal price;
	private int quantity;
	private int quantityReserved;


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

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
		if (quantity >= 0) {
			this.quantity = quantity;
		}
	}

	public int getQuantityReserved() {
		return quantityReserved;
	}
	
	public void setQuantityReserved(int quantityToReserve) {
		if (quantityToReserve <= this.quantity) {
			this.quantityReserved = quantityToReserve;
		} else {
			this.quantityReserved = this.quantity;
		}
	}

	public int getQuantityAvailable() {
		return this.quantity - this.quantityReserved;
	}
}
