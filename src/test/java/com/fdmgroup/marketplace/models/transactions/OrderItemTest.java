package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Product;

public class OrderItemTest {

	private OrderItem orderItem;
	private Product product;
	
	@Before
	public void before() {
		orderItem = new OrderItem();
		product = new Product();
	}
	
	@Test
	public void test_thatOrderItemHasId() {
		orderItem.setOrderItemId(1l);
		assertEquals(1l, orderItem.getOrderItemId());
	}
	
	@Test
	public void test_thatOrderItemHasProduct() {
		orderItem.setProduct(product);
		assertEquals(product, orderItem.getProduct());
	}
}
