package com.fdmgroup.marketplace.models.transactions;

import java.util.Date;

import com.fdmgroup.marketplace.models.users.User;

public class Order {
	
	private long orderId;
	private User buyer;
	private Date time;

	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
