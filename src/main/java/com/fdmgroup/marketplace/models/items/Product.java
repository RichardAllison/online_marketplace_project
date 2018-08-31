package com.fdmgroup.marketplace.models.items;

public class Product {

	private long productId;
	private int quantity;
	private int quantityReserved;
	private Item item;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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
	
	public void incrementQuantity() {
		this.quantity++;
	}
	
	public void decrementQuantity() {
		if (this.quantity > 0) {
			this.quantity--;
		}
	}
	
	public void incrementQuantityReserved() {
		if (this.quantityReserved < this.quantity) {
			this.quantityReserved++;
		}
	}
	
	public void decrementQuantityReserved() {
		if (this.quantityReserved > 0) {
			this.quantityReserved--;
		}
	}
}
