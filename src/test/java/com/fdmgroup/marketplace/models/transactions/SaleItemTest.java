package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;


public class SaleItemTest {

	private SaleItem saleItem;
	private Item item;
	
	@Before
	public void before() {
		saleItem = new SaleItem();
		item = new Item();
	}
	
	@Test
	public void test_thatSaleItemHasId() {
		saleItem.setSaleItemId(1l);
		assertEquals(1l, saleItem.getSaleItemId());
	}
	
	@Test
	public void test_thatSaleItemHasProduct() {
		saleItem.setItem(item);
		assertEquals(item, saleItem.getItem());
	}
	
	@Test
	public void test_thatSaleItemHasQuantity() {
		saleItem.setQuantity(2);
		assertEquals(2, saleItem.getQuantity());
	}
}
