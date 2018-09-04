package com.fdmgroup.marketplace.models.items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_generator" ) 
	@SequenceGenerator(name="product_generator", sequenceName="PRODUCT_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@Column
	private int quantity;
	@Column
	private int quantityReserved;
	@OneToOne
	private Item item;

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
