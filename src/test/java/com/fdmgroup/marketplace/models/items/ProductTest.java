package com.fdmgroup.marketplace.models.items;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	private Product product;
	
	@Before
	public void before() {
		product = new Product();
	}
	
	@Test
	public void test_thatProductHasProductId() {
		product.setProductId(1l);
		long expected = 1l;
		long actual = product.getProductId();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_thatProductHasItem() {
		Item item = new Item();
		product.setItem(item);
		assertEquals(item, product.getItem());
	}
	
	@Test
	public void test_thatProductHasQuantity() {
		product.setQuantity(2);
		int expected = 2;
		int actual = product.getQuantity();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_thatProductQuantityCanBeZero(){
		product.setQuantity(0);
		int expected = 0;
		int actual = product.getQuantity();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void test_thatProductQuantityCannotBeNegative() {
		product.setQuantity(-1);
		int expected = 0;
		int actual = product.getQuantity();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_thatProductCanHaveReservedQuantity() {
		product.setQuantity(1);
		product.setQuantityReserved(1);
		int expected = 1;
		int actual = product.getQuantityReserved();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_thatReservedQuantityCannotBeGreaterThanQuantity() {
		product.setQuantity(1);
		product.setQuantityReserved(2);
		int expected = 1;
		int actual = product.getQuantityReserved();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_thatReservingProductsReducesQuantityAvailable() {
		product.setQuantity(1);
		product.setQuantityReserved(1);
		int expected = 0;
		int actual = product.getQuantityAvailable();
		assertEquals(expected, actual);
	}

}
