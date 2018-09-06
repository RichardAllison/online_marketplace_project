package com.fdmgroup.marketplace.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.marketplace.models.users.UserAccount;

//@WebFilter("/User/*")
public class SessionCheckInterceptor implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		UserAccount user = (UserAccount) session.getAttribute("user");
			
		if(user == null) {
			((HttpServletResponse) response).sendRedirect("/OnlineMarketplaceProject/Login");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
