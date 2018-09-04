package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;
import com.fdmgroup.marketplace.models.users.UserAccount;

public class OrderTest {
	
	private Transaction order;
	private UserAccount buyer;
	
	@Before
	public void before() {
		order = new Transaction();
		buyer = new UserAccount();
	}
	
	@Test
	public void test_thatOrderHasOrderId() {
		order.setId(1l);
		assertEquals(1l, order.getId());
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
		TransactionItem orderItem = new TransactionItem();
		orderItem.setItem(item);
		orderItem.setQuantity(1);
		order.addToOrder(orderItem);
		assertEquals(orderItem, order.getOrderItems().get(0));
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemDoesNotContainAnItem() {
		TransactionItem orderItem = new TransactionItem();
		order.addToOrder(orderItem);
		assertEquals(0, order.getOrderItems().size());
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemQuantityIsZero() {
		Item item = new Item();
		TransactionItem orderItem = new TransactionItem();
		orderItem.setItem(item);
		order.addToOrder(orderItem);
		assertEquals(0, order.getOrderItems().size());
	}

}
