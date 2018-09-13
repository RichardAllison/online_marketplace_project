package com.fdmgroup.marketplace.model.item;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.model.user.UserAccount;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="item_generator" ) 
	@SequenceGenerator(name="item_generator", sequenceName="ITEM_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@Column
	private String name;
	@Column
	private String description;
	@ManyToOne
	private ItemCategory category;
	@Column
	private BigDecimal price;
	@Column
	private int quantity;
	@Column
	private int quantityReserved;
	@ManyToOne
	private UserAccount seller;
	
	public Item() {}

	public Item(String name, String description, BigDecimal price, UserAccount seller) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.seller = seller;
	}
	
	public ItemCategory getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public int getQuantityAvailable() {
		int available = 0;
		if (this.quantity - this.quantityReserved > 0) {
			available = this.quantity - this.quantityReserved;
		}
		return available;
	}

	public int getQuantityReserved() {
		return quantityReserved;
	}

	public UserAccount getSeller() {
		return seller;
	}

	public void setCategory(ItemCategory category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setQuantityReserved(int quantityReserved) {
		this.quantityReserved = quantityReserved;
	}

	public void setSeller(UserAccount seller) {
		this.seller = seller;
	}
	
}
