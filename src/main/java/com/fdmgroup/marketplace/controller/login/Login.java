package com.fdmgroup.marketplace.controller.login;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;
import com.fdmgroup.marketplace.service.user.DefaultUserAccountService;
import com.fdmgroup.marketplace.service.user.UserAccountService;
import com.fdmgroup.marketplace.web.listener.LocalEntityManagerFactory;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserAccountService userService;
	private EntityManager entityManager;
	
	public void init() {
		entityManager = LocalEntityManagerFactory.getEntityManager();
		userService = new DefaultUserAccountService(new UserAccountDAO(entityManager));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			response.sendRedirect("/OnlineMarketplaceProject/User");
		} else {
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserAccount user = null;
		try {
			user = userService.getByUsernameAndPassword(username, password);
		} catch (NoResultException nre){
			request.setAttribute("message", "username or password incorrect");
		}

		if (user == null){
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(60 * 15);
			request.setAttribute("username", user.getUsername());

			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		}
	}
}
