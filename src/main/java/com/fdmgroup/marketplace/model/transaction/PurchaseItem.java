package com.fdmgroup.marketplace.model.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.model.item.Item;

@Entity
public class PurchaseItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="purchase_item_generator" ) 
	@SequenceGenerator(name="purchase_item_generator", sequenceName="PURCHASE_ITEM_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@ManyToOne
	private Item item;
	@Column
	private int quantity;
//	private AccountUser seller;
//	private BigDecimal price;

	public PurchaseItem() {}
	
	public PurchaseItem(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

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
		this.quantity = quantity;
	}
	
}
