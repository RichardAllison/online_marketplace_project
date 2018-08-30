package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;
import com.fdmgroup.marketplace.models.users.User;

public class OrderTest {
	
	private Order order;
	private User buyer;
	
	@Before
	public void before() {
		order = new Order();
		buyer = new User();
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
		User actual = order.getBuyer();
		assertEquals(buyer, actual);
	}
	
	@Test
	public void test_thatOrderCalculatesTotalCost() {
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
		BigDecimal actual = order.calculateTotalCost();
		assertEquals(expected, actual);
	}

}
