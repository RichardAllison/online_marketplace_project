package com.fdmgroup.marketplace.model.transaction;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.Checkout;
import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.model.transaction.sale.SaleItem;
import com.fdmgroup.marketplace.model.user.UserAccount;

public class CheckoutTest {
	
	Sale order;
	UserAccount userAccount;
	
	@Before
	public void before() {
		order = new Sale();
		userAccount = new UserAccount();
		List<SaleItem> orderItems = new ArrayList<>();
		
		Item item1 = new Item();
		Item item2 = new Item();		
		item1.setPrice(BigDecimal.valueOf(5));
		item2.setPrice(BigDecimal.valueOf(2.75));
		
		SaleItem orderItem1 = new SaleItem();
		SaleItem orderItem2 = new SaleItem();
		orderItem1.setItem(item1);
		orderItem2.setItem(item2);
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		
		order.setSaleItems(orderItems);
		order.setBuyer(userAccount);
	}

	@Test
	public void test_thatCalculateTotalCostCalculatesSumOfPricesOfItemsInOrder() {
		BigDecimal expected = BigDecimal.valueOf(7.75);
		BigDecimal actual = Checkout.calculateTotalCost(order);
		assertEquals(expected, actual);
	}
	
	@Test
	@Ignore
	public void test_thatSubmitOrderAddsToCustomerPurchases() {
		Checkout.submitOrder(order);
		assertEquals(1, userAccount.getPurchases().size());
	}
	
	@Test
	@Ignore
	public void test_thatSubmitOrderCreatesNewOrdersForSellers() {
		
	}
	
}
