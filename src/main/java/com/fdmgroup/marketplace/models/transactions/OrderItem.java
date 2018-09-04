package com.fdmgroup.marketplace.models.transactions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//import java.math.BigDecimal;

import com.fdmgroup.marketplace.models.items.Item;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_item_generator" ) 
	@SequenceGenerator(name="order_item_generator", sequenceName="ITEM_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@Column
	private Item item;
	@Column
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
