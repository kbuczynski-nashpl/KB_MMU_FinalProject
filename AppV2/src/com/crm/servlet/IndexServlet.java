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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void checkUser(HttpServletRequest request) {
		HttpSession _SESSION = request.getSession();
		String _SESSION_ID = _SESSION.getId();
		long _SESSION_START_TIME = _SESSION.getCreationTime();
		long _SESSION_LAST_ACCESS_TIME = _SESSION.getLastAccessedTime();
		Boolean _SESSION_IS_NEW = _SESSION.isNew();
		if(_SESSION_IS_NEW == true) {
			 SessionProperties _SESSION_PROPERTIES = new SessionProperties(_SESSION_ID, _SESSION_START_TIME, _SESSION_LAST_ACCESS_TIME, _SESSION_IS_NEW);
			_SESSION.setAttribute("SESSION", _SESSION_PROPERTIES);
		} else {
			SessionProperties _SESSION_PROPERTIES = (SessionProperties) _SESSION.getAttribute("SESSION");
		}
				
	}
}
