package com.crm.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.company.CRM_company;
import com.crm.utils.ApplicationErrorLoging;
import com.crm.utils.ApplicationUtils;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_notes;
import com.db.mysql.models.DBO_CRM_company_personnel;

/**
 * Servlet which held functionality to remove CRM companies parts (email, notes.
 * address. personel)
 * 
 * @author Krzysztof Buczynski
 * @version 1.0
 */
public class DeleteCompanyElement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String type;
	private static Integer id;

	public DeleteCompanyElement() {
		super();
	}

	/**
	 * Main function of the class. Handles incoming request by checking for specific
	 * tags of URL.
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String baseURI = ApplicationUtils.getBasePathOfURI(request);

		try {
			String[] urlSplit = ApplicationUtils.urlSplit(request);
			String url = ApplicationUtils.getPathURL(request);
			String idStr = url.substring(url.lastIndexOf('/') + 1);

			type = new String(urlSplit[urlSplit.length - 2]);
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			ApplicationErrorLoging.log("DeleteCompanyElement.java", e);
			response.sendRedirect(baseURI + "404");

			return;
		}

		HttpSession _SESSION = request.getSession();
		HashMap<String, String> result = deleteHandler();

		if (result.get("STATUS").equals("OK")) {
			_SESSION.setAttribute("DELETENOTIFICATION", "OK");
			if (_SESSION.getAttribute("LASTVIEWCOMPANY") != null) {
				response.sendRedirect(
						baseURI + "view/" + ((CRM_company) _SESSION.getAttribute("LASTVIEWCOMPANY")).getId());
			} else {
				response.sendRedirect(baseURI + "index");
			}
		} else {
			response.sendRedirect(baseURI + "404");
		}

		return;
	}

	/**
	 * Function to process the delete request on given type and id.
	 * 
	 * @return HashMap with Status from MySQL
	 */
	private HashMap<String, String> deleteHandler() {
		switch (type) {
		case "note":
			return DBO_CRM_company_notes.removeNoteById(id);
		case "address":
			return DBO_CRM_company_address.removeAddressById(id);
		case "personnel":
			return DBO_CRM_company_personnel.removePersonnelById(id);
		case "email":
			return DBO_CRM_company_email_address.removeEmailById(id);
		default:
			HashMap<String, String> result = new HashMap<String, String>();
			result.put("STATUS", "OK");
			return result;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
