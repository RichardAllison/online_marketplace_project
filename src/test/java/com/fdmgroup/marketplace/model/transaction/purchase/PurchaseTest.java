package com.fdmgroup.marketplace.model.transaction.purchase;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.transaction.purchase.PurchaseItem;
import com.fdmgroup.marketplace.model.user.UserAccount;

public class PurchaseTest {
	
	private Purchase purchase;
	private UserAccount buyer;
	
	@Before
	public void before() {
		purchase = new Purchase();
		buyer = new UserAccount();
	}
	
	@Test
	public void test_thatOrderHasOrderId() {
		purchase.setId(1l);
		assertEquals(1l, purchase.getId());
	}
	
	@Test
	public void test_thatOrderHasOrderTime() {
		LocalDateTime expected = LocalDateTime.now();
		purchase.setTime(expected);
		assertEquals(expected, purchase.getTime());
	}
	
	@Test
	public void test_thatOrderHasBuyer() {
		purchase.setBuyer(buyer);
		UserAccount actual = purchase.getBuyer();
		assertEquals(buyer, actual);
	}
	
	@Test
	public void test_thatAddToOrderAddsItemToOrderBasket() {
		Item item = new Item();
		PurchaseItem purchaseItem = new PurchaseItem();
		purchaseItem.setItem(item);
		purchaseItem.setQuantity(1);
		purchase.addToPurchase(purchaseItem);
		assertEquals(purchaseItem, purchase.getPurchaseItems().get(0));
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemDoesNotContainAnItem() {
		PurchaseItem purchaseItem = new PurchaseItem();
		purchase.addToPurchase(purchaseItem);
		assertEquals(0, purchase.getPurchaseItems().size());
	}
	
	@Test
	public void test_thatAddToOrderDoesNotAddOrderItemToOrderIfOrderItemQuantityIsZero() {
		Item item = new Item();
		PurchaseItem purchaseItem = new PurchaseItem();
		purchaseItem.setItem(item);
		purchase.addToPurchase(purchaseItem);
		assertEquals(0, purchase.getPurchaseItems().size());
	}

}
