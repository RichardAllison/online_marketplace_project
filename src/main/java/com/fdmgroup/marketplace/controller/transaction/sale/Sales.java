package com.fdmgroup.marketplace.controller.transaction.sale;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.model.transaction.sale.Sale;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.service.user.DefaultUserAccountTransactionService;
import com.fdmgroup.marketplace.service.user.UserAccountSaleService;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;

@WebServlet("/User/Sales")
public class Sales extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserAccountSaleService userSaleService;
	private EntityManager entityManager;
	
	public void init() {
		entityManager = LocalEntityManagerFactory.getEntityManager();
		userSaleService = new DefaultUserAccountTransactionService(entityManager);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			UserAccount user = (UserAccount) request.getSession().getAttribute("user");

			List<Sale> allSales = userSaleService.getAllUserSales(user);
			request.setAttribute("saleList", allSales);
			request.getRequestDispatcher("/WEB-INF/sales.jsp").forward(request, response);
		} else {
			response.sendRedirect("../Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}