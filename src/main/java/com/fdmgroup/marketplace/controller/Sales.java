package com.fdmgroup.marketplace.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.listener.LocalEntityManagerFactory;
import com.fdmgroup.marketplace.model.transaction.Sale;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.SaleDAO;

@WebServlet("/User/Sales")
public class Sales extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccount user = (UserAccount) request.getSession().getAttribute("user");
		
		SaleDAO saleDao  = new SaleDAO(LocalEntityManagerFactory.getEntityManager());
		List<Sale> allSales = saleDao.retrieveAllByUserId(user.getId());
		request.setAttribute("saleList", allSales);
		request.getRequestDispatcher("/WEB-INF/sales.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}