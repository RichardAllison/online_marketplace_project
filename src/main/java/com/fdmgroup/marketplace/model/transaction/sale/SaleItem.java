package com.fdmgroup.marketplace.model.transaction.sale;

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
	@ManyToOne
	private Sale sale;
	@Column
	private int quantity;
	@Column
	private BigDecimal price;

	public SaleItem() {}
	
	public SaleItem(Item item, int quantity, BigDecimal price) {
		this.item = item;
		this.quantity = quantity;
		this.price = price;
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
	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
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
