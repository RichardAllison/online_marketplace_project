package com.fdmgroup.marketplace.model.transaction.sale;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.model.transaction.sale.SaleItem;
import com.fdmgroup.marketplace.model.user.UserAccount;

public class SaleTest {
	
	private Sale sale;
	private UserAccount buyer;
	
	@Before
	public void before() {
		sale = new Sale();
		buyer = new UserAccount();
	}
	
	@Test
	public void test_thatOrderHasOrderId() {
		sale.setId(1l);
		assertEquals(1l, sale.getId());
	}
	
	@Test
	public void test_thatOrderHasOrderTime() {
		LocalDateTime expected = LocalDateTime.now();
		sale.setTime(expected);
		assertEquals(expected, sale.getTime());
	}
	
	@Test
	public void test_thatOrderHasBuyer() {
		sale.setBuyer(buyer);
		UserAccount actual = sale.getBuyer();
		assertEquals(buyer, actual);
	}
	
	@Test
	public void test_thatAddToOrderAddsItemToOrderBasket() {
		Item item = new Item();
		SaleItem saleItem = new SaleItem();
		saleItem.setItem(item);
		saleItem.setQuantity(1);
		sale.addToSale(saleItem);
		assertEquals(saleItem, sale.getSaleItems().get(0));
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemDoesNotContainAnItem() {
		SaleItem saleItem = new SaleItem();
		sale.addToSale(saleItem);
		assertEquals(0, sale.getSaleItems().size());
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemQuantityIsZero() {
		Item item = new Item();
		SaleItem saleItem = new SaleItem();
		saleItem.setItem(item);
		sale.addToSale(saleItem);
		assertEquals(0, sale.getSaleItems().size());
	}

}
