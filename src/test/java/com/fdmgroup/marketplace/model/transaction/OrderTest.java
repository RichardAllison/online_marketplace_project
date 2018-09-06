package com.fdmgroup.marketplace.model.transaction;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.model.transaction.SaleItem;
import com.fdmgroup.marketplace.model.user.UserAccount;

public class OrderTest {
	
	private Sale order;
	private UserAccount buyer;
	
	@Before
	public void before() {
		order = new Sale();
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
		SaleItem orderItem = new SaleItem();
		orderItem.setItem(item);
		orderItem.setQuantity(1);
		order.addToOrder(orderItem);
		assertEquals(orderItem, order.getSaleItems().get(0));
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemDoesNotContainAnItem() {
		SaleItem orderItem = new SaleItem();
		order.addToOrder(orderItem);
		assertEquals(0, order.getSaleItems().size());
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemQuantityIsZero() {
		Item item = new Item();
		SaleItem orderItem = new SaleItem();
		orderItem.setItem(item);
		order.addToOrder(orderItem);
		assertEquals(0, order.getSaleItems().size());
	}

}
