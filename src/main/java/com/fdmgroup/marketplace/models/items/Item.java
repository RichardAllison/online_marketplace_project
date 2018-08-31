package com.fdmgroup.marketplace.models.items;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fdmgroup.marketplace.models.users.UserAccount;

@Entity
public class Item {

	@Id
	private long id;
	private String name;
	private String description;
	private BigDecimal price;
	private UserAccount seller;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public UserAccount getSeller() {
		return seller;
	}

	public void setSeller(UserAccount seller) {
		this.seller = seller;
	}
	
}
