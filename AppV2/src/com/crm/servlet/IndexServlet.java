package com.crm.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.user.CRM_user;
import com.crm.utils.ApplicationUtils;
import com.db.mysql.models.DBO_CRM_company_notes;

/**
 * Index servlet. Main landing page of the application
 * 
 * @author Krzysztof Buczynski
 *
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession _SESSION = request.getSession();

		request.setAttribute("LAST5CUST", _SESSION.getAttribute("LAST5CUST"));
		
		DBO_CRM_company_notes dbo0 = new DBO_CRM_company_notes();
		
		request.setAttribute("LAST5NOTES", dbo0.getByCompanyIdTop5(((CRM_user) _SESSION.getAttribute("CLIENT")).getId()));
		request.setAttribute("DUEINNOTES", dbo0.getAllByDate(ApplicationUtils.getDate(7, "yyyy-MM-dd HH:mm"), ((CRM_user) _SESSION.getAttribute("CLIENT")).getId()));

		ApplicationUtils.openJSP(request, response, "/WEB-INF/views/index.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
