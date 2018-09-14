package com.fdmgroup.marketplace.controller.item.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.model.category.ItemCategory;
import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.service.category.DefaultItemCategoryService;
import com.fdmgroup.marketplace.service.category.ItemCategoryService;
import com.fdmgroup.marketplace.service.item.DefaultItemService;
import com.fdmgroup.marketplace.service.item.ItemService;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;

@WebServlet("/User/Products/Add")
public class ProductAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ItemService itemService;
	private ItemCategoryService categoryService;
	private EntityManager entityManager;
	
	public void init(){
		entityManager = LocalEntityManagerFactory.getEntityManager();
		itemService = new DefaultItemService(entityManager);
		categoryService = new DefaultItemCategoryService(entityManager);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ItemCategory> categories = categoryService.retrieveAllItemCategories();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/WEB-INF/product_add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			UserAccount user = (UserAccount) request.getSession().getAttribute("user");
			ItemCategory category = null;
			if (request.getParameter("category") != null){
				categoryService.retrieveItemCategory(Long.valueOf(request.getParameter("category")));
			}
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			int quantity = Integer.valueOf(request.getParameter("quantity"));
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			Item item = null;
			if (user != null) {
				item = new Item(name, description, category, price, quantity, user);
				itemService.createItem(item);
			}
			response.sendRedirect("/OnlineMarketplaceProject/User/Products");
		}
		
		else {
			response.sendRedirect("/OnlineMarketplaceProject/Login");
		}
	}
}
