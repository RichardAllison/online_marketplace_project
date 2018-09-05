package com.fdmgroup.marketplace.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.listener.LocalEntityManagerFactory;
import com.fdmgroup.marketplace.models.items.Product;
import com.fdmgroup.marketplace.models.users.UserAccount;
import com.fdmgroup.marketplace.repository.ProductDAO;



@WebServlet("/User/Products")
public class AccountProducts extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccount user = (UserAccount) request.getSession().getAttribute("user");
		
		request.getRequestDispatcher("/WEB-INF/AccountProducts.jsp").forward(request, response);
		ProductDAO productDao  = new ProductDAO(LocalEntityManagerFactory.getEntityManager());
		List<Product> allProducts = productDao.retrieveAllByUserId(user.getId());
		request.setAttribute("productList", allProducts);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
