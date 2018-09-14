package com.fdmgroup.marketplace.service.item;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.repository.CRUD;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;

public class ItemServiceTest {
	
	private ItemService itemService;
	private EntityManager entityManager;
	@Mock
	private CRUD<Item> itemDAO;
	
	@Before
	public void before() {
		entityManager = LocalEntityManagerFactory.getEntityManager();
		itemService = new DefaultItemService(itemDAO);
		MockitoAnnotations.initMocks(this);
	}
}
