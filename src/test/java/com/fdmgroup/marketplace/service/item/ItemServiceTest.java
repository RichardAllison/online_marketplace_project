package com.fdmgroup.marketplace.service.item;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.repository.CRUD;

public class ItemServiceTest {
	
	private ItemService itemService;
	@Mock
	private CRUD<Item> itemDAO;
	@Mock
	private EntityManager entityManager;
	
	@Before
	public void before() {
		itemService = new DefaultItemService(entityManager);
		MockitoAnnotations.initMocks(this);
	}
}
