package com.crm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.company.CRM_company;
import com.crm.client.user.CRM_user;
import com.crm.utils.NewCRMCompanyUtils;

/**
 * Servlet implementation class AddNewServlet
 */
public class AddNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		HttpSession _SESSION = request.getSession();
		List<String> parameterNames = new ArrayList<String>(request.getParameterMap().keySet());
		for (String tmp : parameterNames) {
			System.out.println(tmp);
		}

		String url = request.getRequestURL().toString();
		String idStr = url.substring(url.lastIndexOf('/') + 1);
		
		if(idStr.equals("confirm")) {
			NewCRMCompanyUtils.createNewCRMCompany((HashMap<String, String>) _SESSION.getAttribute("newCrmCompany"), (CRM_user) _SESSION.getAttribute("CLIENT"));
			return;
		}

		if (request.getParameter("companyName") != null) {
			HashMap<String, String> postVariables = new HashMap<String, String>();
			postVariables.put("companyName", request.getParameter("companyName"));
			postVariables.put("companyAddressLine1", request.getParameter("addressline1"));
			postVariables.put("companyAddressLine2", request.getParameter("addressline2"));
			postVariables.put("companyAddressPostcode", request.getParameter("addresspostcode"));
			postVariables.put("companyAddressCity", request.getParameter("addresscity"));
			postVariables.put("companyAddressCountry", request.getParameter("addresscountry"));
			postVariables.put("companyEmailAddress", request.getParameter("emailaddress"));
			postVariables.put("companyEmailType", request.getParameter("emailtype"));
			postVariables.put("companyEmailActive", request.getParameter("emailactive"));
			postVariables.put("companyPhoneNumber", request.getParameter("phoneNonumber"));
			postVariables.put("companyPhoneNoPrefix", request.getParameter("phoneNoprefix"));
			
			_SESSION.setAttribute("newCrmCompany", postVariables);
			
			request.setAttribute("postVariables", postVariables);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/addConfirm.jsp");
			dispatcher.forward(request, response);
			return;
		}

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/add.jsp");
		dispatcher.forward(request, response);
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void createNewCRMEntry(HttpServletRequest request, HttpServletResponse response) {
		HttpSession _SESSION = request.getSession();
		CRM_company newCompany = new CRM_company();
		
	}
	

}
