package com.fdmgroup.marketplace.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.listener.LocalEntityManagerFactory;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.UserAccountDAO;

@WebServlet("/AccountCreate")
public class AccountCreate extends HttpServlet {
	
	private static EntityManager entityManager = LocalEntityManagerFactory.getEntityManager();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		UserAccountDAO userAccountDAO = new UserAccountDAO(entityManager);
		UserAccount user = null; 
		try {
			user = new UserAccount(username, password, email);
			entityManager.getTransaction().begin();
			userAccountDAO.create(user);
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
