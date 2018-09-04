package com.fdmgroup.marketplace.models.transactions;

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

import com.fdmgroup.marketplace.models.users.UserAccount;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_generator" ) 
	@SequenceGenerator(name="order_generator", sequenceName="ORDER_ID_SEQ", initialValue=1, allocationSize=1) 
	private long id;
	@ManyToOne
	private UserAccount buyer;
	@Column
	private Date time;
	@ManyToMany
	@JoinColumn(name = "id")
	private List<TransactionItem> orderItems;
	
	public Transaction() {
		this.orderItems = new ArrayList<>();
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

	public List<TransactionItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<TransactionItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addToOrder(TransactionItem orderItem) {
		if (orderItem.getItem() != null && orderItem.getQuantity() > 0) {
			this.orderItems.add(orderItem);
			// increment quantity reserved in product
		}
	}

}
