package com.crm.servlet;

import java.io.IOException;
import java.util.HashMap;

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
		if (userLoginUtils.getUserLoginSession(request) == true) {
			if (request.getSession().getAttribute("REDIRECT") != null) {
				response.sendRedirect(request.getSession().getAttribute("REDIRECT").toString());
				return;
			} else {
				response.sendRedirect("index");
				return;
			}
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
			HashMap<String, Object> res = userLoginUtils.logIn(usr, psw);
			if (res.get("isLogged").equals("true")) {
				this.buildUpSession(res, request);
				if (request.getSession().getAttribute("REDIRECT") != null && !request.getSession().getAttribute("REDIRECT").equals("index")) {
					response.sendRedirect(request.getSession().getAttribute("REDIRECT").toString());
					return;
				} else {
					response.sendRedirect("index");
					return;
				}
			} else {
				request.setAttribute("error", "Invalid Username or Password");
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/login.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void buildUpSession(HashMap<String, Object> obj, HttpServletRequest request) {
		HttpSession _SESSION = request.getSession();
		_SESSION.setAttribute("CLIENT", obj.get("CRM_User"));
		_SESSION.setAttribute("CLIENT_MASTER_INFO", obj.get("CRM_user_master"));
		_SESSION.setAttribute("CLIENT_INFO", obj.get("CRM_user_information"));
	}

}
