package com.fdmgroup.marketplace.models.categories;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	ItemCategory category;
	
	@Before
	public void before() {
		category = new ItemCategory();
	}
	
	@Test
	public void test_thatCategoryHasId() {
		category.setId(1l);
		assertEquals(1l, category.getId());
	}
	
	@Test
	public void test_thatCategoryHasName() {
		String name = "name";
		category.setName(name);
		assertEquals(name, category.getName());
	}
	
}
