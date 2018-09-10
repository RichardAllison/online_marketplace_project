package com.fdmgroup.marketplace.model.transaction;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.model.item.Item;

@Entity
public class SaleItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sale_item_generator" ) 
	@SequenceGenerator(name="sale_item_generator", sequenceName="SALE_ITEM_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@ManyToOne
	private Item item;
	@Column
	private int quantity;
//	private AccountUser seller;
//	private BigDecimal price;

	public SaleItem() {}
	
	public SaleItem(Item item, int quantity) {
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
//		this.price = item.getPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getPrice() {
		return this.item.getPrice().multiply(BigDecimal.valueOf(this.quantity));
	}
	
}
