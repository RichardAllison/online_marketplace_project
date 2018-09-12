package com.fdmgroup.marketplace.controller.user;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.listener.LocalEntityManagerFactory;
import com.fdmgroup.marketplace.model.user.UserAccount;
import com.fdmgroup.marketplace.repository.user.UserAccountDAO;

@WebServlet("/User/Edit")
public class AccountEdit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static EntityManager entityManager = LocalEntityManagerFactory.getEntityManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null) {
			//			UserAccount user = (UserAccount) request.getSession().getAttribute("user");
			request.getRequestDispatcher("/WEB-INF/account_edit.jsp").forward(request, response);
		} else {
			response.sendRedirect("/OnlineMarketplaceProject/Login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/OnlineMarketplaceProject/Login");
		} else {
			UserAccountDAO userAccountDAO = new UserAccountDAO(entityManager);

			UserAccount user = (UserAccount) request.getSession().getAttribute("user");
			try {
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setEmailAddress(request.getParameter("email"));
				entityManager.getTransaction().begin();
				userAccountDAO.update(user);
				entityManager.getTransaction().commit();
				response.sendRedirect("User");
			} catch (RollbackException rbe){
				user = null;
				request.setAttribute("message", "User name already exists");
			}
		}

	}

}
