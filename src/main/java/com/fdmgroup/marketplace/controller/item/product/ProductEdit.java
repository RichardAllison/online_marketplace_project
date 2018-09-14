package com.fdmgroup.marketplace.controller.item.product;

import java.io.IOException;
import java.math.BigDecimal;

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

@WebServlet("/User/Product/Edit/*")
public class ProductEdit extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static ItemService itemService;
	private EntityManager entityManager;
	private long productId;

	public void init(ServletConfig config) throws ServletException {
		entityManager = LocalEntityManagerFactory.getEntityManager();
		itemService = new DefaultItemService(entityManager);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null) {
			productId = Long.valueOf(request.getPathInfo().substring(1));
			Item product = itemService.retrieveItem(productId);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/WEB-INF/product_edit.jsp").forward(request, response);
		} else {
			response.sendRedirect("/OnlineMarketplaceProject/Login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			Item product = itemService.retrieveItem(productId);

			product.setDescription(request.getParameter("description"));
			product.setName(request.getParameter("name"));
			product.setPrice(new BigDecimal(request.getParameter("price")));
			product.setQuantity(Integer.valueOf(request.getParameter("quantity")));
			itemService.updateItem(product);
			response.sendRedirect("../User");

		} else {
			response.sendRedirect("/OnlineMarketplaceProject/Login");
		}

	}
}
