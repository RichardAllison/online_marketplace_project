package com.fdmgroup.marketplace.models.transactions;

import java.math.BigDecimal;

public class Checkout {

	private Checkout() {}
	
	public static BigDecimal calculateTotalCost(Order order) {
		return order.getOrderItems().stream().map(orderItem -> orderItem.getItem().getPrice())
				.reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));	
	}
	
	public static void submitOrder(Order order) {
		
	}

}
