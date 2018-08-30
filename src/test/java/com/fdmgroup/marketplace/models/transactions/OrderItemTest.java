package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;

public class OrderItemTest {

	private OrderItem orderItem;
	private Item item;
	
	@Before
	public void before() {
		orderItem = new OrderItem();
		item = new Item();
	}
	
	@Test
	public void test_thatOrderItemHasId() {
		orderItem.setOrderItemId(1l);
		assertEquals(1l, orderItem.getOrderItemId());
	}
	
	@Test
	public void test_thatOrderItemHasProduct() {
		orderItem.setItem(item);
		assertEquals(item, orderItem.getItem());
	}
	
	@Test
	public void test_thatOrderItemHasQuantity() {
		orderItem.setQuantity(2);
		assertEquals(2, orderItem.getQuantity());
	}
}
