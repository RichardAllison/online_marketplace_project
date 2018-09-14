package com.fdmgroup.marketplace.model.transaction.purchase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.item.Item;

public class PurchaseItemTest {

	private PurchaseItem purchaseItem;
	private Item item;
	
	@Before
	public void before() {
		purchaseItem = new PurchaseItem();
		item = new Item();
	}
	
	@Test
	public void test_thatOrderItemHasId() {
		purchaseItem.setId(1l);
		assertEquals(1l, purchaseItem.getId());
	}
	
	@Test
	public void test_thatOrderItemHasProduct() {
		purchaseItem.setItem(item);
		assertEquals(item, purchaseItem.getItem());
	}
	
	@Test
	public void test_thatOrderItemHasQuantity() {
		purchaseItem.setQuantity(2);
		assertEquals(2, purchaseItem.getQuantity());
	}
}
