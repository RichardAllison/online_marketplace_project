package com.fdmgroup.marketplace.models.items;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.transactions.Order;
import com.fdmgroup.marketplace.models.transactions.OrderItem;

public class ProductTest {
	
	private Product product;
	
	@Before
	public void before() {
		product = new Product();
	}
	
	@Test
	public void test_thatProductHasProductId() {
		product.setId(1l);
		long expected = 1l;
		long actual = product.getId();
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

	@Test
	public void test_thatIncrementQuantityIncreasesQuantityByOne() {
		product.incrementQuantity();
		assertEquals(1, product.getQuantity());
	}
	
	@Test
	public void test_thatDecrementQuantityReducesQuantityByOne() {
		product.setQuantity(1);
		product.decrementQuantity();
		assertEquals(0, product.getQuantity());
	}
	
	@Test
	public void test_thatDecrementQuantityDoesNotReduceQuantityBelowZero() {
		product.decrementQuantity();
		assertEquals(0, product.getQuantity());
	}
	
	@Test
	public void test_thatIncrementQuantityReservedIncreasesQuantityReservedByOne() {
		product.setQuantity(1);
		product.incrementQuantityReserved();
		assertEquals(1, product.getQuantityReserved());
	}
	
	@Test
	public void test_thatIncrementQuantityReservedDoesNotIncreaseQuantityReservedBeyondQuantity() {
		product.incrementQuantityReserved();
		assertEquals(0, product.getQuantityReserved());
	}

}
