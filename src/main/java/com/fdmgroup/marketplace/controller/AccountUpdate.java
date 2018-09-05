package com.fdmgroup.marketplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.marketplace.models.users.UserAccount;
import com.fdmgroup.marketplace.repository.EntityManagerHelper;
import com.fdmgroup.marketplace.repository.UserAccountDAO;

@WebServlet("/User/AccountUpdate")
public class AccountUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccount user = (UserAccount) request.getSession().getAttribute("user");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		UserAccountDAO userAccountDAO = new UserAccountDAO(EntityManagerHelper.getEntityManager());
		UserAccount updatedUser = new UserAccount(username, password, email);

		updatedUser.setId(user.getId());
		EntityManagerHelper.beginTransaction();
		userAccountDAO.update(user.getId(), updatedUser);
		EntityManagerHelper.commit();

		response.sendRedirect("AccountHome");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
