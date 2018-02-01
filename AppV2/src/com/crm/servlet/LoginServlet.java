package com.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.utils.userLoginUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		if(userLoginUtils.checkUserSession(request) == true) {
			response.sendRedirect("index");
			return;
		}
		if ((request.getParameter("password") == "") && (request.getParameter("password") == "")) {
			request.setAttribute("error", "Invalid Username or Password");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		} else if ((request.getParameter("password") == null) && (request.getParameter("password") == null)) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		} else {
			String psw = request.getParameter("password");
			String usr = request.getParameter("username");
			List<Object> res = userLoginUtils.logIn(usr, psw);
			Boolean debugFlag = true;
			if (res.get(0).equals("true") || debugFlag == true) {
				this.writeToSession(res.get(1), request);
			} else {
				request.setAttribute("error", "Invalid Username or Password");
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
				dispatcher.forward(request, response);

			}
			response.sendRedirect("index");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void writeToSession(Object obj, HttpServletRequest request) {
		HttpSession _SESSION = request.getSession();
		_SESSION.setAttribute("CLIENT", obj);
	}

}
