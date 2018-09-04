package com.fdmgroup.marketplace.models.items;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.models.users.UserAccount;

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
	@Column
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "id")
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
