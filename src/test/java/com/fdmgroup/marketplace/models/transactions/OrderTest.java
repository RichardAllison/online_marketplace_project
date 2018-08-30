package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

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

}
