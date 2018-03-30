package com.crm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.utils.ApplicationUtils;

/**
 * Servlet implementation class aboutServlet
 */
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AboutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationUtils.openJSP(request, response, "/WEB-INF/views/about.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
