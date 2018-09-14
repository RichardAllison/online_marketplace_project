package com.fdmgroup.marketplace.controller.item.product;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;
import com.fdmgroup.marketplace.service.user.DefaultUserAccountProductService;
import com.fdmgroup.marketplace.service.user.UserAccountProductService;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;


@WebServlet("/User/Products")
public class Products extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static UserAccountProductService userProductService;
	private EntityManager entityManager;
	
	public void init(ServletConfig config) throws ServletException {
		entityManager = LocalEntityManagerFactory.getEntityManager();
		userProductService = new DefaultUserAccountProductService(new UserAccountDAO(entityManager));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			UserAccount user = (UserAccount) request.getSession().getAttribute("user");

			List<Item> allItems = userProductService.getAllUserProducts(user);
			request.setAttribute("itemList", allItems);
			request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("../Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
