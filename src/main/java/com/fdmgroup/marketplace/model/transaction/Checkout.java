package com.fdmgroup.marketplace.model.transaction;

import java.math.BigDecimal;

public class Checkout {

	private Checkout() {}
	
	public static BigDecimal calculateTotalCost(Sale sale) {
		return sale.getSaleItems().stream().map(saleItem -> saleItem.getItem().getPrice())
				.reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));	
	}
	
	public static BigDecimal calculateTotalCost(Purchase purchase) {
		return purchase.getPurchaseItems().stream().map(purchaseItem -> purchaseItem.getItem().getPrice())
					.reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));	
	}
	
	public static void submitOrder(Sale order) {
		
	}

}
