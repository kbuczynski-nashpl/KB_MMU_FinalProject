package com.crm.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
import com.crm.client.user.CRM_user_information;
import com.crm.utils.ApplicationErrorLoging;
import com.crm.utils.ApplicationUtils;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_notes;
import com.db.mysql.models.DBO_CRM_company_personnel;
import com.db.mysql.models.DBO_CRM_user;
import com.db.mysql.models.DOB_CRM_user_information;

/**
 * A servlet is responsible to process request and add new CRM company component
 * or display JSP page.
 */
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String type;
	private static Integer id;

	public NewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String baseURI = ApplicationUtils.getBasePathOfURI(request);

		HttpSession _SESSION = request.getSession();

		try {
			String url = request.getRequestURL().toString();
			String idStr = url.substring(url.lastIndexOf('/') + 1);
			String[] urlSplit = url.split("/");
			type = new String(urlSplit[urlSplit.length - 2]);
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			ApplicationErrorLoging.log("NewServlet.java", e);
			response.sendRedirect(baseURI + "404");
			return;
		}

		HashMap<String, String> postData = new HashMap<String, String>();
		HashMap<String, String> result = new HashMap<String, String>();

		request.setAttribute("USER", (CRM_user) _SESSION.getAttribute("CLIENT"));
		request.setAttribute("COMPANY_ID", id);

		switch (type) {
		case "personnel":
			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newPersonnel.jsp");
			break;
		case "postpersonnel":
			if (request.getParameter("type") == null) {
				ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newPersonnel.jsp");
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

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newPersonnel.jsp");
			break;
		case "email":
			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newEmail.jsp");
			break;
		case "postemail":
			if (request.getParameter("type") == null) {
				ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newEmail.jsp");
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

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newEmail.jsp");
			break;
		case "note":
			request.setAttribute("USER_INFO", this.getUserInfo(((CRM_user) _SESSION.getAttribute("CLIENT")).getUser_master_id()));
			request.setAttribute("NOTE_STATUS", ApplicationUtils.note_status);

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newNote.jsp");
			break;
		case "postnote":
			if (request.getParameter("type") == null) {
				request.setAttribute("USER_INFO", this.getUserInfo(((CRM_user) _SESSION.getAttribute("CLIENT")).getUser_master_id()));
				request.setAttribute("NOTE_STATUS", ApplicationUtils.note_status);

				ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newNote.jsp");
				return;
			}

			postData = new HashMap<String, String>();

			Date currentDate = new Date();
			DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			postData.put("noteTitle", request.getParameter("noteTitle"));
			postData.put("note", request.getParameter("note"));
			postData.put("noteUserId", request.getParameter("noteUserId"));
			postData.put("noteDate", dataFormat.format(currentDate));
			postData.put("noteStatus", request.getParameter("noteStatus"));
			postData.put("noteAssigne", request.getParameter("noteAssigne"));
			postData.put("noteDuein", request.getParameter("noteDuein"));

			result = this.postNote(postData);

			if (result.get("STATUS").equals("ERROR")) {
				request.setAttribute("error", "Something went wrong please try again");
			} else {
				request.setAttribute("success", "New Entry have been created");
			}

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newNote.jsp");
			break;
		case "address":
			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newAddress.jsp");
			break;
		case "postaddress":
			request.setAttribute("COUNTRIES", ApplicationUtils.countires);

			if (request.getParameter("type") == null) {
				ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newAddress.jsp");
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

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/newAddress.jsp");
			break;
		default:
			response.sendRedirect(baseURI + "404");
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
				Integer.parseInt(postData.get("noteUserId").toString()), postData.get("noteDate"),
				Integer.parseInt(postData.get("noteAssigne").toString()), postData.get("noteStatus"),
				postData.get("noteDuein"));
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

	private ArrayList<CRM_user_information> getUserInfo(Integer companyId) {
		DBO_CRM_user dbocu = new DBO_CRM_user();
		DOB_CRM_user_information dboui = new DOB_CRM_user_information();
		return dboui.getByIdFromList(dbocu.getAllForCompany(companyId));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
