package com.fdmgroup.marketplace.controller.user;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.service.user.DefaultUserAccountService;
import com.fdmgroup.marketplace.service.user.UserAccountService;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;

@WebServlet("/User/Edit")
public class AccountEdit extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserAccountService userService;
	private EntityManager entityManager;
	
	public void init() {
		entityManager = LocalEntityManagerFactory.getEntityManager();
		userService = new DefaultUserAccountService(entityManager);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null) {
			UserAccount user = (UserAccount) request.getSession().getAttribute("user");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/account_edit.jsp").forward(request, response);
		} else {
			response.sendRedirect("/OnlineMarketplaceProject/Login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/OnlineMarketplaceProject/Login");
		} else {
			UserAccount user = (UserAccount) request.getSession().getAttribute("user");
			try {
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setEmailAddress(request.getParameter("email"));
				userService.update(user);
				response.sendRedirect("../User");
			} catch (RollbackException rbe){
				user = null;
				request.setAttribute("message", "User name already exists");
			}
		}

	}

}
