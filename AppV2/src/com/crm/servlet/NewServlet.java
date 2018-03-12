package com.crm.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.company.CRM_company_address;
import com.crm.client.company.CRM_company_email_address;
import com.crm.client.company.CRM_company_notes;
import com.crm.client.company.CRM_company_personnel;
import com.crm.client.user.CRM_user;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_notes;
import com.db.mysql.models.DBO_CRM_company_personnel;

/**
 * Servlet implementation class NewCRMEntryServlet
 */
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String type;
	private static Integer id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = ((HttpServletRequest) request).getRequestURI();
		String baseURL = path.substring(0, path.length() - ((HttpServletRequest) request).getRequestURI().length())
				+ ((HttpServletRequest) request).getContextPath() + "/";
		HttpSession _SESSION = request.getSession();

		try {
			String url = request.getRequestURL().toString();
			String idStr = url.substring(url.lastIndexOf('/') + 1);
			String[] urlSplit = url.split("/");
			type = new String(urlSplit[urlSplit.length - 2]);
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
			response.sendRedirect(baseURL + "404");
			return;
		}
		HashMap<String, String> postData = new HashMap<String, String>();
		HashMap<String, String> result = new HashMap<String, String>();
		request.setAttribute("USER", (CRM_user) _SESSION.getAttribute("CLIENT"));
		request.setAttribute("COMPANY_ID", id);
		switch (type) {
		case "personnel":
			RequestDispatcher dispatcher0 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/newPersonnel.jsp");
			dispatcher0.forward(request, response);
			break;
		case "postpersonnel":
			RequestDispatcher dispatcher1 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/newPersonnel.jsp");
			if (request.getParameter("type") == null) {
				dispatcher1.forward(request, response);
				return;
			}
			postData = new HashMap<String, String>();
			postData.put("surname", request.getParameter("surname"));
			postData.put("forname", request.getParameter("forname"));
			postData.put("email", request.getParameter("email"));
			postData.put("phoneNo", request.getParameter("phoneNo"));
			postData.put("phoneNoPrefix", request.getParameter("phoneNoPrefix"));
			postData.put("position", request.getParameter("position"));
			result = this.postPersonel(postData);
			if (result.get("STATUS").equals("ERROR")) {
				request.setAttribute("error", "Something went wrong please try again");
			} else {
				request.setAttribute("success", "New Entry have been created");
			}
			dispatcher1.forward(request, response);
			break;
		case "email":
			RequestDispatcher dispatcher2 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/newEmail.jsp");
			dispatcher2.forward(request, response);
			break;
		case "postemail":
			RequestDispatcher dispatcher3 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/newEmail.jsp");
			if (request.getParameter("type") == null) {
				dispatcher3.forward(request, response);
				return;
			}
			postData = new HashMap<String, String>();
			postData.put("emailAddress", request.getParameter("emailAddress"));
			postData.put("emailType", request.getParameter("emailType"));
			result = this.postEmail(postData);
			if (result.get("STATUS").equals("ERROR")) {
				request.setAttribute("error", "Something went wrong please try again");
			} else {
				request.setAttribute("success", "New Entry have been created");
			}
			dispatcher3.forward(request, response);
			break;
		case "note":
			RequestDispatcher dispatcher4 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newNote.jsp");
			dispatcher4.forward(request, response);
			break;
		case "postnote":
			RequestDispatcher dispatcher5 = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newNote.jsp");
			if (request.getParameter("type") == null) {
				dispatcher5.forward(request, response);
				return;
			}
			postData = new HashMap<String, String>();
			postData.put("noteTitle", request.getParameter("noteTitle"));
			postData.put("note", request.getParameter("note"));
			postData.put("noteUserId", request.getParameter("noteUserId"));
			Date currentDate = new Date();
			DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			postData.put("noteDate", dataFormat.format(currentDate));
			result = this.postNote(postData);
			if (result.get("STATUS").equals("ERROR")) {
				request.setAttribute("error", "Something went wrong please try again");
			} else {
				request.setAttribute("success", "New Entry have been created");
			}
			dispatcher5.forward(request, response);
			break;
		case "address":
			RequestDispatcher dispatcher6 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/newAddress.jsp");
			dispatcher6.forward(request, response);
			break;
		case "postaddress":
			RequestDispatcher dispatcher7 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/newAddress.jsp");
			if (request.getParameter("type") == null) {
				dispatcher7.forward(request, response);
				return;
			}
			postData = new HashMap<String, String>();
			postData.put("addressLine1", request.getParameter("addressLine1"));
			postData.put("addressPostcode", request.getParameter("addressPostcode"));
			postData.put("addressCity", request.getParameter("addressCity"));
			postData.put("addressCountry", request.getParameter("addressCountry"));
			if (request.getParameter("addressLine2") != null) {
				postData.put("addressLine2", request.getParameter("addressLine2"));
			}
			result = this.postAddress(postData);
			if (result.get("STATUS").equals("ERROR")) {
				request.setAttribute("error", "Something went wrong please try again");
			} else {
				request.setAttribute("success", "New Entry have been created");
			}

			dispatcher7.forward(request, response);
			break;
		default:
			response.sendRedirect(baseURL + "404");
			break;
		}
		return;
	}

	private HashMap<String, String> postAddress(HashMap<String, String> postData) {
		CRM_company_address cca = new CRM_company_address(id, postData.get("addressLine1"),
				postData.get("addressPostcode"), postData.get("addressCity"), postData.get("addressCountry"), false);
		if (postData.get("addressLine2") != null) {
			cca.setCompany_address_line2(postData.get("addressLine2"));
		}
		DBO_CRM_company_address dbo0 = new DBO_CRM_company_address();
		return dbo0.createNewCrmCompanyAddress(cca);
	}

	private HashMap<String, String> postNote(HashMap<String, String> postData) {
		CRM_company_notes ccn = new CRM_company_notes(id, postData.get("noteTitle"), postData.get("note"),
				Integer.parseInt(postData.get("noteUserId").toString()), postData.get("noteDate"));
		DBO_CRM_company_notes dbo0 = new DBO_CRM_company_notes();
		return dbo0.newNote(ccn);
	}

	private HashMap<String, String> postEmail(HashMap<String, String> postData) {
		CRM_company_email_address ccea = new CRM_company_email_address(id, postData.get("emailAddress"),
				postData.get("emailType"));
		DBO_CRM_company_email_address dbo0 = new DBO_CRM_company_email_address();
		return dbo0.createNewCRMEmailAddress(ccea);
	}

	private HashMap<String, String> postPersonel(HashMap<String, String> postData) {
		CRM_company_personnel ccp = new CRM_company_personnel(id, postData.get("surname"), postData.get("forname"),
				postData.get("email"), postData.get("phoneNo"), postData.get("phoneNoPrefix"),
				postData.get("position"));
		DBO_CRM_company_personnel dbo0 = new DBO_CRM_company_personnel();
		return dbo0.newCompanyPersonnel(ccp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
