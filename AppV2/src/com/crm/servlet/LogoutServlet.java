package com.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet which will perform a logout function by destroying a user session.
 * 
 * @author Krzysztof Buczynski
 *
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("login");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
