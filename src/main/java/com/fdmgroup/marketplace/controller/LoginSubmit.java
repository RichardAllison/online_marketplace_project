package com.fdmgroup.marketplace.controller;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.listener.LocalEntityManagerFactory;
import com.fdmgroup.marketplace.models.users.UserAccount;
import com.fdmgroup.marketplace.repository.UserAccountDAO;

@WebServlet("/LoginSubmit")
public class LoginSubmit extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserAccountDAO userAccountDAO = new UserAccountDAO(LocalEntityManagerFactory.getEntityManager());
		UserAccount user = null;
		try {
			user = userAccountDAO.getByUsernameAndPassword(username, password);
		} catch (NoResultException nre){
			request.setAttribute("message", "username or password incorrect");
		}
		
		if (user == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(60 * 15);
			request.setAttribute("username", user.getUsername());
			response.sendRedirect("User/"+user.getUsername());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
