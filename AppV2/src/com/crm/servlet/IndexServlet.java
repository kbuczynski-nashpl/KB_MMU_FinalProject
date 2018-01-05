package com.crm.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.user.CRMUser;
import com.crm.servlet.sessionHandler.SessionProperties;

@WebServlet(urlPatterns = { "/"})
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(checkUserSession(request) == false) {
			System.out.println("GO TO LOGIN");
			response.sendRedirect("login");
		} else {
			System.out.println("GO TO HOME");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private boolean checkUserSession(HttpServletRequest request) {
		HttpSession _SESSION = request.getSession();
		String _SESSION_ID = _SESSION.getId();
		long _SESSION_START_TIME = _SESSION.getCreationTime();
		long _SESSION_LAST_ACCESS_TIME = _SESSION.getLastAccessedTime();
		Boolean _SESSION_IS_NEW = _SESSION.isNew();
		System.out.println(_SESSION_IS_NEW);
		if(_SESSION_IS_NEW == true || _SESSION.getAttribute("CLIENT") == null) {
			 SessionProperties _SESSION_PROPERTIES = new SessionProperties(_SESSION_ID, _SESSION_START_TIME, _SESSION_LAST_ACCESS_TIME, _SESSION_IS_NEW);
			_SESSION.setAttribute("SESSION", _SESSION_PROPERTIES);
		} else {
			SessionProperties _SESSION_PROPERTIES = (SessionProperties) _SESSION.getAttribute("SESSION");
			CRMUser client = (CRMUser) _SESSION.getAttribute("CLIENT");
			if(client.getIsLogedIn() == true) {
				return true;
			}
		}
		return false;
	}
}
