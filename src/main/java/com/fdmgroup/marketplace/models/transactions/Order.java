package com.fdmgroup.marketplace.models.transactions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fdmgroup.marketplace.models.users.UserAccount;

public class Order {
	
	private long orderId;
	private UserAccount buyer;
	private Date time;
	private List<OrderItem> orderItems;
	
	public Order() {
		this.orderItems = new ArrayList<>();
	}

	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
		}
	}

}
