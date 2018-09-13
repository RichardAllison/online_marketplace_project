package com.fdmgroup.marketplace.model.transaction;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.sale.SaleItem;

public class SaleItemTest {

	private SaleItem saleItem;
	private Item item;
	
	@Before
	public void before() {
		saleItem = new SaleItem();
		item = new Item();
	}
	
	@Test
	public void test_thatOrderItemHasId() {
		saleItem.setId(1l);
		assertEquals(1l, saleItem.getId());
	}
	
	@Test
	public void test_thatOrderItemHasProduct() {
		saleItem.setItem(item);
		assertEquals(item, saleItem.getItem());
	}
	
	@Test
	public void test_thatOrderItemHasQuantity() {
		saleItem.setQuantity(2);
		assertEquals(2, saleItem.getQuantity());
	}
}
