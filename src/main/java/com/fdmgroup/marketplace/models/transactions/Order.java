package com.fdmgroup.marketplace.models.transactions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fdmgroup.marketplace.models.users.UserAccount;

@Entity
public class Order {
	
	@Id
	private long id;
	private UserAccount buyer;
	private Date time;
	private List<OrderItem> orderItems;
	
	public Order() {
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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addToOrder(OrderItem orderItem) {
		if (orderItem.getItem() != null && orderItem.getQuantity() > 0) {
			this.orderItems.add(orderItem);
			// increment quantity reserved in product
		}
	}

}
