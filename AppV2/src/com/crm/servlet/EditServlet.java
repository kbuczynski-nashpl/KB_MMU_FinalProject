package com.crm.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.company.CRM_company;
import com.crm.client.company.CRM_company_address;
import com.crm.client.company.CRM_company_email_address;
import com.crm.client.company.CRM_company_notes;
import com.crm.client.company.CRM_company_personnel;
import com.crm.client.user.CRM_user;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_notes;
import com.db.mysql.models.DBO_CRM_company_personnel;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = 0;
		String type;
		String path = ((HttpServletRequest) request).getRequestURI();
		String baseURL = path.substring(0, path.length() - ((HttpServletRequest) request).getRequestURI().length())
				+ ((HttpServletRequest) request).getContextPath() + "/";
		List<String> parameterNames = new ArrayList<String>(request.getParameterMap().keySet());
		HttpSession _SESSION = request.getSession();
		for (String tmp : parameterNames) {
			System.out.println(tmp);
		}
		try {
			String url = request.getRequestURL().toString();
			String idStr = url.substring(url.lastIndexOf('/') + 1);
			String[] urlSplit = url.split("/");
			type = urlSplit[urlSplit.length - 2];
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
			response.sendRedirect(baseURL + "404");
			return;
		}

		DBO_CRM_company dbo0 = new DBO_CRM_company();
		DBO_CRM_company_email_address dbo1 = new DBO_CRM_company_email_address();
		DBO_CRM_company_address dbo2 = new DBO_CRM_company_address();
		DBO_CRM_company_personnel dbo3 = new DBO_CRM_company_personnel();
		DBO_CRM_company_notes dbo4 = new DBO_CRM_company_notes();
		CRM_company cc = new CRM_company();
		
		switch (type) {
		case "main":
			cc = dbo0.getById(id);
			ArrayList<CRM_company_email_address> companyEmailAddressList = dbo1.getByCompanyId(id);
			ArrayList<CRM_company_address> companyAddressList = dbo2.getByCompanyId(id);
			if (request.getParameter("type") != null) {
				HashMap<String, String> postValues = new HashMap<String, String>();
				postValues.put("address", request.getParameter("address").toString());
				postValues.put("emailAddress", request.getParameter("emailAddress").toString());
				postValues.put("companyId", id.toString());
				processMainEditRequest(postValues, dbo1, dbo2, companyEmailAddressList, companyAddressList);
				response.sendRedirect(baseURL + "edit/main/" + id);
				return;
			}

			request.setAttribute("CC", cc);
			request.setAttribute("CCEA", companyEmailAddressList);
			request.setAttribute("CCA", companyAddressList);

			RequestDispatcher dispatcher0 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editMain.jsp");
			dispatcher0.forward(request, response);
			break;
		case "personnel":
			CRM_company_personnel ccp = dbo3.getById(id);
			cc = dbo0.getById(ccp.getCompany_id());
			if (request.getParameter("type") != null) {
				HashMap<String, String> newValues = new HashMap<String, String>();
				newValues.put("surname", request.getParameter("surname"));
				newValues.put("forname", request.getParameter("forname"));
				newValues.put("email", request.getParameter("email"));
				newValues.put("phoneNo", request.getParameter("phoneNo"));
				newValues.put("phoneNoPrefix", request.getParameter("phoneNoPrefix"));
				newValues.put("position", request.getParameter("position"));
				processPersonelEditRequest(newValues, dbo3, id);
				response.sendRedirect(baseURL + "edit/personnel/" + id);
				return;
			}
			request.setAttribute("CC", cc);
			request.setAttribute("CCP", ccp);
			RequestDispatcher dispatcher1 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editPersonnel.jsp");
			dispatcher1.forward(request, response);
			break;

		case "email":
			CRM_company_email_address ccea = dbo1.getById(id);
			cc = dbo0.getById(ccea.getCompany_id());
			if (request.getParameter("type") != null) {
				HashMap<String, String> newValues = new HashMap<String, String>();
				newValues.put("emailAddress", request.getParameter("emailAddress"));
				newValues.put("emailType", request.getParameter("emailType"));
				processEmailEditRequest(newValues, dbo1, id);
				response.sendRedirect(baseURL + "edit/email/" + id);
				return;
			}
			request.setAttribute("CC", cc);
			request.setAttribute("CCEA", ccea);
			RequestDispatcher dispatcher2 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editEmail.jsp");
			dispatcher2.forward(request, response);

			break;
		case "note":
			CRM_company_notes ccn = dbo4.getById(id);
			cc = dbo0.getById(ccn.getCompany_id());
			if (request.getParameter("type") != null) {
				HashMap<String, String> newValues = new HashMap<String, String>();
				newValues.put("noteTitle", request.getParameter("noteTitle"));
				newValues.put("note", request.getParameter("note"));
				newValues.put("noteUserId", request.getParameter("noteUserId"));
				Date currentDate = new Date();
				DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				newValues.put("noteDate", dataFormat.format(currentDate));
				processNoteEditRequest(newValues, dbo4, id);
				response.sendRedirect(baseURL + "edit/note/" + id);
				return;
			}
			request.setAttribute("USER", (CRM_user) _SESSION.getAttribute("CLIENT"));
			request.setAttribute("CC", cc);
			request.setAttribute("CCN", ccn);
			RequestDispatcher dispatcher3 = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editNote.jsp");
			dispatcher3.forward(request, response);

			break;
		default:
			break;
		}

		return;

	}
	private void processNoteEditRequest(HashMap<String, String> newValues, DBO_CRM_company_notes dbo4, Integer id) {
		dbo4.updateNote(newValues, id);
	}

	/**
	 * Function will pass new values for email to database DBO class to update the entry
	 * @param newValues
	 * @param dbo1
	 * @param id
	 */
	private void processEmailEditRequest(HashMap<String, String> newValues, DBO_CRM_company_email_address dbo1,
			Integer id) {
		dbo1.updateEmailEntry(newValues, id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Function which will update main edit details for address an email address
	 * 
	 * @param postValues
	 * @param cc
	 * @param dbo1
	 * @param dbo2
	 * @param companyEmailAddressList
	 * @param companyAddressList
	 */

	private void processMainEditRequest(HashMap<String, String> postValues, DBO_CRM_company_email_address dbo1,
			DBO_CRM_company_address dbo2, ArrayList<CRM_company_email_address> companyEmailAddressList,
			ArrayList<CRM_company_address> companyAddressList) {

		// Find current Active address
		CRM_company_address currentActiveAddress = null;
		for (CRM_company_address cca : companyAddressList) {
			if (cca.getCompany_address_active().equals(true)) {
				currentActiveAddress = cca;
			}
		}

		// If current active is null then set new one in db
		if (currentActiveAddress == null) {
			dbo2.updateActiveAddressState(true, Integer.parseInt(postValues.get("address")));
		}

		// check if current active is not the same as new update new one
		if (!currentActiveAddress.getId().equals(Integer.parseInt(postValues.get("address")))) {
			currentActiveAddress.setCompany_address_active(false);
			dbo2.updateActiveAddressState(false, currentActiveAddress.getId());
			dbo2.updateActiveAddressState(true, Integer.parseInt(postValues.get("address")));
		}

		// Find current active email address
		CRM_company_email_address currentActiveEmailAddress = null;
		for (CRM_company_email_address ccea : companyEmailAddressList) {
			if (ccea.getCompany_email_active().equals(true)) {
				currentActiveEmailAddress = ccea;
			}
		}

		// If current active is null then set new one in db
		if (currentActiveEmailAddress == null) {
			dbo1.updateActiveAddressState(true, Integer.parseInt(postValues.get("emailAddress")));
		}

		// check if current active is not the same as new update new one
		if (!currentActiveEmailAddress.getId().equals(Integer.parseInt(postValues.get("emailAddress")))) {
			currentActiveEmailAddress.setCompany_email_active(false);
			dbo1.updateActiveAddressState(false, currentActiveEmailAddress.getId());
			dbo1.updateActiveAddressState(true, Integer.parseInt(postValues.get("emailAddress")));
		}
		return;
	}

	/**
	 * Function was designed to pass values to database update statment.
	 * 
	 * 
	 * @param newValues
	 * @param dbo3
	 * @param id
	 */
	private void processPersonelEditRequest(HashMap<String, String> newValues, DBO_CRM_company_personnel dbo3,
			Integer id) {
		dbo3.updateRecordById(newValues, id);
	}

}
