package com.fdmgroup.marketplace.models.items;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	
	@Before
	public void before() {
		item = new Item();
	}
	
	@Test
	public void test_thatProductHasPrice() {
		item.setPrice(BigDecimal.valueOf(10));
		BigDecimal expected = BigDecimal.valueOf(10);
		BigDecimal actual = item.getPrice();
		assertEquals(expected, actual);
	}
}
