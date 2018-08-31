package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;
import com.fdmgroup.marketplace.models.users.UserAccount;

public class OrderTest {
	
	private Order order;
	private UserAccount buyer;
	
	@Before
	public void before() {
		order = new Order();
		buyer = new UserAccount();
	}
	
	@Test
	public void test_thatOrderHasOrderId() {
		order.setOrderId(1l);
		assertEquals(1l, order.getOrderId());
	}
	
	@Test
	public void test_thatOrderHasOrderTime() {
		Date expected = new Date();
		order.setTime(expected);
		assertEquals(expected, order.getTime());
	}
	
	@Test
	public void test_thatOrderHasBuyer() {
		order.setBuyer(buyer);
		UserAccount actual = order.getBuyer();
		assertEquals(buyer, actual);
	}
	
	@Test
	public void test_thatAddToOrderAddsItemToOrderBasket() {
		Item item = new Item();
		OrderItem orderItem = new OrderItem();
		orderItem.setItem(item);
		orderItem.setQuantity(1);
		order.addToOrder(orderItem);
		assertEquals(orderItem, order.getOrderItems().get(0));
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemDoesNotContainAnItem() {
		OrderItem orderItem = new OrderItem();
		order.addToOrder(orderItem);
		assertEquals(0, order.getOrderItems().size());
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemQuantityIsZero() {
		Item item = new Item();
		OrderItem orderItem = new OrderItem();
		orderItem.setItem(item);
		order.addToOrder(orderItem);
		assertEquals(0, order.getOrderItems().size());
	}

}
