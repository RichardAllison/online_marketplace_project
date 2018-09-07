package com.fdmgroup.marketplace.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.listener.LocalEntityManagerFactory;
import com.fdmgroup.marketplace.model.item.Item;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.ItemDAO;
import com.fdmgroup.marketplace.repository.UserAccountDAO;

public class ProductCreate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static EntityManager entityManager = LocalEntityManagerFactory.getEntityManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccount user = (UserAccount) request.getSession().getAttribute("user");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		ItemDAO itemDao = new ItemDAO(entityManager);
		Item item = null;
		try {
			item = new Item(name, description, price, user);
			entityManager.getTransaction().begin();
			itemDao.create(item);
			entityManager.getTransaction().commit();
		} catch (RollbackException rbe){
			user = null;
			request.setAttribute("message", "User name already exists");
		}

		if (user == null) {
			request.getRequestDispatcher("account_add.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
