package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;
import com.fdmgroup.marketplace.models.users.UserAccount;

public class CheckoutTest {
	
	Transaction order;
	UserAccount userAccount;
	
	@Before
	public void before() {
		order = new Transaction();
		userAccount = new UserAccount();
		List<TransactionItem> orderItems = new ArrayList<>();
		
		Item item1 = new Item();
		Item item2 = new Item();		
		item1.setPrice(BigDecimal.valueOf(5));
		item2.setPrice(BigDecimal.valueOf(2.75));
		
		TransactionItem orderItem1 = new TransactionItem();
		TransactionItem orderItem2 = new TransactionItem();
		orderItem1.setItem(item1);
		orderItem2.setItem(item2);
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		
		order.setOrderItems(orderItems);
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
