package com.fdmgroup.marketplace.models.items;

import java.math.BigDecimal;

import com.fdmgroup.marketplace.models.users.User;

public class Item {

	private String name;
	private String description;
	private BigDecimal price;
	private User seller;
	
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

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}
}
