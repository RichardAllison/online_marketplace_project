package com.fdmgroup.marketplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/User/Edit")
public class AccountEdit extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getPathInfo().substring(1);
		
		if (request.getSession().getAttribute("user") != null) {
			request.getRequestDispatcher("/WEB-INF/AccountEdit.jsp").forward(request, response);
		} else {
			response.sendRedirect("/OnlineMarketplaceProject/Login");
		}
	}
}
