package com.crm.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.user.CRM_user;
import com.crm.utils.ApplicationUtils;
import com.crm.utils.NewCRMCompanyUtils;

/**
 * A Servlet which contains functionality to add new company into the system. It
 * will check and validate main information then process to confirmation and
 * process the data once everything is ok.
 * 
 * @author Krzysztof Buczynski
 * @version 2.0
 */
public class AddNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	/**
	 * Main Landing point for the request. it will make sure nothing is cached to
	 * ensure fresh input is correct. It will display new CRM company forms and pass
	 * the data into createNewCRMCompany() function once all data has been
	 * confirmed.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");

		HttpSession _SESSION = request.getSession();

		String url = ApplicationUtils.getPathURL(request);
		String idStr = url.substring(url.lastIndexOf('/') + 1);

		if (idStr.equals("confirm")) {
			HashMap<String, String> result = NewCRMCompanyUtils.createNewCRMCompany(
					(HashMap<String, String>) _SESSION.getAttribute("newCrmCompany"),
					(CRM_user) _SESSION.getAttribute("CLIENT"));

			request.setAttribute("STATUS", result.get("STATUS"));
			request.setAttribute("MSG", result.get("VALUE"));
			request.setAttribute("ID", result.get("cc-id"));

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/addSummary.jsp");

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

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/addConfirm.jsp");

			return;
		}
		request.setAttribute("COUNTRY", ApplicationUtils.countires);
		ApplicationUtils.openJSP(request, response, "/WEB-INF/views/add.jsp");
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
