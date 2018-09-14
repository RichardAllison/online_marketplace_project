package com.fdmgroup.marketplace.controller.item;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.service.item.DefaultItemService;
import com.fdmgroup.marketplace.service.item.ItemService;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;

@WebServlet({ "/item/*", "/Item/*"})
public class ItemShow extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static ItemService itemService;
	private long itemId;

	public void init(ServletConfig config) throws ServletException {
		EntityManager entityManager = LocalEntityManagerFactory.getEntityManager();
		itemService = new DefaultItemService(entityManager);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itemId = Long.valueOf(request.getPathInfo().substring(1));
		Item item = itemService.retrieveItem(itemId);
		if (item != null) {
			request.setAttribute("item", item);
			request.getRequestDispatcher("/WEB-INF/item_show.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
