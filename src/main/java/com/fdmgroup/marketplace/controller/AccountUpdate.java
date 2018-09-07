package com.fdmgroup.marketplace.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.listener.LocalEntityManagerFactory;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.UserAccountDAO;

@WebServlet("/User/AccountUpdate")
public class AccountUpdate extends HttpServlet {
	
	private static EntityManager entityManager = LocalEntityManagerFactory.getEntityManager();

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccount user = (UserAccount) request.getSession().getAttribute("user");
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmailAddress(request.getParameter("email"));
		UserAccountDAO userAccountDAO = new UserAccountDAO(entityManager);

		entityManager.getTransaction().begin();
		userAccountDAO.update(user.getId(), user);
		entityManager.getTransaction().commit();

		response.sendRedirect("AccountHome");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
