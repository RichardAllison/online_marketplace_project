package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;

public class CheckoutTest {

	@Test
	public void test_thatCalculateTotalCostCalculatesSumOfPricesOfItemsInOrder() {
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<>();
		
		Item item1 = new Item();
		Item item2 = new Item();		
		item1.setPrice(BigDecimal.valueOf(5));
		item2.setPrice(BigDecimal.valueOf(2.75));
		
		OrderItem orderItem1 = new OrderItem();
		OrderItem orderItem2 = new OrderItem();
		orderItem1.setItem(item1);
		orderItem2.setItem(item2);
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		
		order.setOrderItems(orderItems);
		BigDecimal expected = BigDecimal.valueOf(7.75);
		BigDecimal actual = Checkout.calculateTotalCost(order);
		assertEquals(expected, actual);
	}
	
}
