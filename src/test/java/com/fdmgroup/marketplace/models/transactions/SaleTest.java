package com.fdmgroup.marketplace.models.transactions;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.marketplace.models.items.Item;
import com.fdmgroup.marketplace.models.users.User;

public class SaleTest {
	
	private Sale sale;
	private User seller;
	
	@Before
	public void before() {
		sale = new Sale();
		seller = new User();
	}
	
	@Test
	public void test_thatSaleHasSaleId() {
		sale.setSaleId(1l);
		assertEquals(1l, sale.getSaleId());
	}
	
	@Test
	public void test_thatSaleHasSaleTime() {
		Date expected = new Date();
		sale.setTime(expected);
		assertEquals(expected, sale.getTime());
	}
	
	@Test
	public void test_thatSaleHasSeller() {
		sale.setSeller(seller);
		User actual = sale.getSeller();
		assertEquals(seller, actual);
	}
	
	@Test
	public void test_thatSaleCalculatesTotalCost() {
		List<SaleItem> saleItems = new ArrayList<>();
		
		Item item1 = new Item();
		Item item2 = new Item();		
		item1.setPrice(BigDecimal.valueOf(5));
		item2.setPrice(BigDecimal.valueOf(2.75));
		
		SaleItem saleItem1 = new SaleItem();
		SaleItem saleItem2 = new SaleItem();
		saleItem1.setItem(item1);
		saleItem2.setItem(item2);
		saleItems.add(saleItem1);
		saleItems.add(saleItem2);
		
		sale.setSaleItems(saleItems);
		BigDecimal expected = BigDecimal.valueOf(7.75);
		BigDecimal actual = sale.calculateTotalCost();
		assertEquals(expected, actual);
	}

}
