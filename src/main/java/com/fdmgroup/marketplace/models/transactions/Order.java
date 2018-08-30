package com.fdmgroup.marketplace.models.transactions;

import java.math.BigDecimal;
import java.util.List;

import com.fdmgroup.marketplace.models.users.User;

public class Order extends Basket{
	
	private long orderId;
	private User buyer;
	private List<OrderItem> orderItems;

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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public BigDecimal calculateTotalCost() {
		return this.orderItems.stream().map(orderItem -> orderItem.getItem().getPrice())
				.reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));	
	}

}
