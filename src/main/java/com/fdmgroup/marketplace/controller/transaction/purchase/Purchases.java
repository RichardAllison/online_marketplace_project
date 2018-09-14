package com.fdmgroup.marketplace.controller.transaction.purchase;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.model.transaction.purchase.Purchase;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.service.user.DefaultUserAccountTransactionService;
import com.fdmgroup.marketplace.service.user.UserAccountPurchaseService;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;

@WebServlet("/User/Purchases")
public class Purchases extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserAccountPurchaseService userPurchaseService;
	private EntityManager entityManager;
	
	public void init() {
		entityManager = LocalEntityManagerFactory.getEntityManager();
		userPurchaseService = new DefaultUserAccountTransactionService(entityManager);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccount user = (UserAccount) request.getSession().getAttribute("user");
		
		List<Purchase> allPurchases = userPurchaseService.getAllUserPurchases(user);
		request.setAttribute("purchaseList", allPurchases);
		request.getRequestDispatcher("/WEB-INF/purchases.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}