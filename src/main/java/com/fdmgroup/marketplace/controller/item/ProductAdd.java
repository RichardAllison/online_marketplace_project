package com.fdmgroup.marketplace.controller.item;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.listener.LocalEntityManagerFactory;
import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.item.ItemDAO;

@WebServlet("/User/Products/Add")
public class ProductAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static EntityManager entityManager = LocalEntityManagerFactory.getEntityManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/product_add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			UserAccount user = (UserAccount) request.getSession().getAttribute("user");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			int quantity = Integer.valueOf(request.getParameter("quantity"));
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			ItemDAO itemDao = new ItemDAO(entityManager);
			Item item = null;
			if (user != null) {
				item = new Item(name, description, price, user);
				item.setQuantity(quantity);
				entityManager.getTransaction().begin();
				itemDao.create(item);
				entityManager.getTransaction().commit();
			}
			response.sendRedirect("/OnlineMarketplaceProject/User/Products");
		}
		
		else {
			response.sendRedirect("Home");
		}
	}
}
