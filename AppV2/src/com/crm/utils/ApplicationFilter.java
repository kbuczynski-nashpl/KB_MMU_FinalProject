package com.crm.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApplicationFilter implements Filter {

	private List<String> extensions = new ArrayList<String>();
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String ipAddress = request.getRemoteAddr();
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString());
		 HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        HttpSession session = req.getSession(false);
	        String loginURI = req.getContextPath() + "/login";

	        boolean loggedIn = session != null && session.getAttribute("CLIENT") != null;
	        boolean loginRequest = req.getRequestURI().equals(loginURI);

	        if (loggedIn || loginRequest) {
	            chain.doFilter(req, res);
	        } else {
	        	res.sendRedirect(loginURI);
	        }

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String testParam = config.getInitParameter("test-param");
		System.out.println("Test Param: " + testParam);
		this.extensions.add("/css");
		this.extensions.add("/js");
		this.extensions.add("/images");
	}
}
