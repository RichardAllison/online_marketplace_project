package com.fdmgroup.marketplace.model.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fdmgroup.marketplace.model.user.UserAccount;

@Entity
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sale_generator" ) 
	@SequenceGenerator(name="sale_generator", sequenceName="SALE_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@ManyToOne
	private UserAccount buyer;
	@Column
	private Date time;
	@ManyToMany
	@JoinColumn(name = "id")
	private List<SaleItem> saleItems;
	
	public Sale() {
		this.saleItems = new ArrayList<>();
	}

	public Sale(UserAccount buyer, Date time) {
		this();
		this.buyer = buyer;
		this.time = time;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public UserAccount getBuyer() {
		return buyer;
	}

	public void setBuyer(UserAccount buyer) {
		this.buyer = buyer;
	}

	public List<SaleItem> getSaleItems() {
		return saleItems;
	}

	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}
	
	public void addToOrder(SaleItem orderItem) {
		if (orderItem.getItem() != null && orderItem.getQuantity() > 0) {
			this.saleItems.add(orderItem);
			// increment quantity reserved in product
		}
	}

}
