package com.crm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
import com.crm.client.user.CRM_user_information;
import com.crm.utils.ApplicationErrorLoging;
import com.crm.utils.ApplicationUtils;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_notes;
import com.db.mysql.models.DBO_CRM_company_personnel;
import com.db.mysql.models.DBO_CRM_user;
import com.db.mysql.models.DOB_CRM_user_information;

/**
 * A Servlet which handles the edit request. It either process the data and
 * updates the database or displays requested jsp page.
 * 
 * @author Krzysztof Buczynski
 *
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Integer id = 0;
	private static String type;

	public EditServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	/**
	 * Main landing function of the servlet. It handles the request type and checks
	 * what edit to preform or if JSP needs to be open with correct form.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession _SESSION = request.getSession();
		String baseURI = ApplicationUtils.getBasePathOfURI(request);

		try {
			String url = ApplicationUtils.getPathURL(request);
			String idStr = url.substring(url.lastIndexOf('/') + 1);
			String[] urlSplit = ApplicationUtils.urlSplit(request);

			type = urlSplit[urlSplit.length - 2];
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			ApplicationErrorLoging.log("EditServlet.java", e);
			response.sendRedirect(baseURI + "404");
			return;
		}

		DBO_CRM_company dbo0 = new DBO_CRM_company();
		DBO_CRM_company_email_address dbo1 = new DBO_CRM_company_email_address();
		DBO_CRM_company_address dbo2 = new DBO_CRM_company_address();
		DBO_CRM_company_personnel dbo3 = new DBO_CRM_company_personnel();
		DBO_CRM_company_notes dbo4 = new DBO_CRM_company_notes();

		CRM_company cc = new CRM_company();

		HashMap<String, String> result = new HashMap<String, String>();

		switch (type) {
		case "main":
			cc = dbo0.getById(id);

			ArrayList<CRM_company_email_address> companyEmailAddressList = dbo1.getByCompanyId(id);
			ArrayList<CRM_company_address> companyAddressList = dbo2.getByCompanyId(id);

			if (request.getParameter("type") != null) {
				HashMap<String, String> postValues = new HashMap<String, String>();
				postValues.put("companyName", request.getParameter("companyName"));
				postValues.put("address", request.getParameter("address").toString());
				postValues.put("emailAddress", request.getParameter("emailAddress").toString());
				postValues.put("companyId", id.toString());

				result = processMainEditRequest(postValues,dbo0, dbo1, dbo2, companyEmailAddressList, companyAddressList);

				_SESSION.setAttribute("EDIT_RESPONSE", result);

				response.sendRedirect(baseURI + "edit/main/" + id);
				return;
			}

			request.setAttribute("CC", cc);
			request.setAttribute("CCEA", companyEmailAddressList);
			request.setAttribute("CCA", companyAddressList);

			if (_SESSION.getAttribute("EDIT_RESPONSE") != null) {
				if (((HashMap<String, String>) _SESSION.getAttribute("EDIT_RESPONSE")).get("STATUS").equals("ERROR")) {
					request.setAttribute("error", "Something went wrong please try again");
				} else {
					request.setAttribute("success", "New Entry have been created");
				}
			}

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/editMain.jsp");
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

				result = processPersonelEditRequest(newValues, dbo3, id);

				_SESSION.setAttribute("EDIT_RESPONSE", result);

				response.sendRedirect(baseURI + "edit/personnel/" + id);
				return;
			}
			request.setAttribute("CC", cc);
			request.setAttribute("CCP", ccp);

			if (_SESSION.getAttribute("EDIT_RESPONSE") != null) {
				if (((HashMap<String, String>) _SESSION.getAttribute("EDIT_RESPONSE")).get("STATUS").equals("ERROR")) {
					request.setAttribute("error", "Something went wrong please try again");
				} else {
					request.setAttribute("success", "New Entry have been created");
				}
			}

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/editPersonnel.jsp");
			break;

		case "email":
			CRM_company_email_address ccea = dbo1.getById(id);

			cc = dbo0.getById(ccea.getCompany_id());

			if (request.getParameter("type") != null) {
				HashMap<String, String> newValues = new HashMap<String, String>();

				newValues.put("emailAddress", request.getParameter("emailAddress"));
				newValues.put("emailType", request.getParameter("emailType"));

				result = processEmailEditRequest(newValues, dbo1);

				_SESSION.setAttribute("EDIT_RESPONSE", result);

				response.sendRedirect(baseURI + "edit/email/" + id);
				return;
			}

			request.setAttribute("CC", cc);
			request.setAttribute("CCEA", ccea);

			if (_SESSION.getAttribute("EDIT_RESPONSE") != null) {
				if (((HashMap<String, String>) _SESSION.getAttribute("EDIT_RESPONSE")).get("STATUS").equals("ERROR")) {
					request.setAttribute("error", "Something went wrong please try again");
				} else {
					request.setAttribute("success", "New Entry have been created");
				}
			}

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/editEmail.jsp");
			break;
		case "note":
			CRM_company_notes ccn = dbo4.getById(id);

			cc = dbo0.getById(ccn.getCompany_id());

			if (request.getParameter("type") != null) {
				HashMap<String, String> newValues = new HashMap<String, String>();

				newValues.put("noteTitle", request.getParameter("noteTitle"));
				newValues.put("note", request.getParameter("note"));
				newValues.put("noteStatus", request.getParameter("noteStatus"));
				newValues.put("noteAssigne", request.getParameter("noteAssigne"));
				newValues.put("noteDuein", request.getParameter("noteDuein"));
				newValues.put("noteUserId", request.getParameter("noteUserId"));
				newValues.put("noteDate", ApplicationUtils.getDate(0, "yyyy-MM-dd HH:mm"));

				result = processNoteEditRequest(newValues, dbo4);

				_SESSION.setAttribute("EDIT_RESPONSE", result);

				response.sendRedirect(baseURI + "edit/note/" + id);
				return;
			}
			request.setAttribute("USER", (CRM_user) _SESSION.getAttribute("CLIENT"));
			request.setAttribute("CC", cc);
			request.setAttribute("CCN", ccn);
			request.setAttribute("USER_INFO", this.getUserInfo(((CRM_user) _SESSION.getAttribute("CLIENT")).getUser_master_id()));
			request.setAttribute("NOTE_STATUS", ApplicationUtils.note_status);


			if (_SESSION.getAttribute("EDIT_RESPONSE") != null) {
				if (((HashMap<String, String>) _SESSION.getAttribute("EDIT_RESPONSE")).get("STATUS").equals("ERROR")) {
					request.setAttribute("error", "Something went wrong please try again");
				} else {
					request.setAttribute("success", "New Entry have been created");
				}
			}

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/editNote.jsp");
			break;
		case "address":
			CRM_company_address cca = dbo2.getById(id);

			cc = dbo0.getById(cca.getCompany_id());

			if (request.getParameter("type") != null) {
				HashMap<String, String> newValues = new HashMap<String, String>();

				newValues.put("addressLine1", request.getParameter("addressLine1"));
				newValues.put("addressPostCode", request.getParameter("addressPostCode"));
				newValues.put("addressCity", request.getParameter("addressCity"));
				newValues.put("addressCountry", request.getParameter("addressCountry"));

				if (request.getParameter("addressLine2") != null) {
					newValues.put("addressLine2", request.getParameter("addressLine2"));
				}

				result = proccessAddressEditRequest(newValues, dbo2);

				_SESSION.setAttribute("EDIT_RESPONSE", result);

				response.sendRedirect(baseURI + "edit/address/" + id);
				return;
			}

			request.setAttribute("USER", (CRM_user) _SESSION.getAttribute("CLIENT"));
			request.setAttribute("CC", cc);
			request.setAttribute("CCA", cca);

			if (_SESSION.getAttribute("EDIT_RESPONSE") != null) {
				if (((HashMap<String, String>) _SESSION.getAttribute("EDIT_RESPONSE")).get("STATUS").equals("ERROR")) {
					request.setAttribute("error", "Something went wrong please try again");
				} else {
					request.setAttribute("success", "New Entry have been created");
				}
			}

			ApplicationUtils.openJSP(request, response, "/WEB-INF/views/editAddress.jsp");
			break;
		default:
			break;
		}

		return;

	}

	private HashMap<String, String> proccessAddressEditRequest(HashMap<String, String> newValues,
			DBO_CRM_company_address dbo2) {
		return dbo2.updateAddress(newValues, id);
	}

	private HashMap<String, String> processNoteEditRequest(HashMap<String, String> newValues,
			DBO_CRM_company_notes dbo4) {
		return dbo4.updateNote(newValues, id);
	}

	/**
	 * Function will pass new values for email to database DBO class to update the
	 * entry
	 * 
	 * @param newValues
	 * @param dbo1
	 * @param id
	 * @return
	 */
	private HashMap<String, String> processEmailEditRequest(HashMap<String, String> newValues,
			DBO_CRM_company_email_address dbo1) {
		return dbo1.updateEmailEntry(newValues, id);
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
	 * @return
	 */

	private HashMap<String, String> processMainEditRequest(HashMap<String, String> postValues,
			DBO_CRM_company dbo0,
			DBO_CRM_company_email_address dbo1, 
			DBO_CRM_company_address dbo2,
			ArrayList<CRM_company_email_address> companyEmailAddressList,
			ArrayList<CRM_company_address> companyAddressList) {

		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		// Find current Active address
		CRM_company_address currentActiveAddress = null;
		for (CRM_company_address cca : companyAddressList) {
			if (cca.getCompany_address_active().equals(true)) {
				currentActiveAddress = cca;
			}
		}

		// If current active is null then set new one in db
		if (currentActiveAddress == null) {
			result.add(dbo2.updateActiveAddressState(true, Integer.parseInt(postValues.get("address"))));
		}

		// check if current active is not the same as new update new one
		if (!currentActiveAddress.getId().equals(Integer.parseInt(postValues.get("address")))) {
			currentActiveAddress.setCompany_address_active(false);
			result.add(dbo2.updateActiveAddressState(false, currentActiveAddress.getId()));
			result.add(dbo2.updateActiveAddressState(true, Integer.parseInt(postValues.get("address"))));
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
			result.add(dbo1.updateActiveAddressState(true, Integer.parseInt(postValues.get("emailAddress"))));
		}

		// check if current active is not the same as new update new one
		if (!currentActiveEmailAddress.getId().equals(Integer.parseInt(postValues.get("emailAddress")))) {
			currentActiveEmailAddress.setCompany_email_active(false);
			result.add(dbo1.updateActiveAddressState(false, currentActiveEmailAddress.getId()));
			result.add(dbo1.updateActiveAddressState(true, Integer.parseInt(postValues.get("emailAddress"))));
		}
		
		// update CRM company name
		result.add(dbo0.updateCompanyName(postValues.get("companyName").toString(), id));
		
		for (HashMap<String, String> tmp : result) {
			if (tmp.get("STATUS").equals("ERROR")) {
				return tmp;
			}
		}
		
		if (result.size() < 1) {
			return null;
		}

		return result.get(result.size() - 1);
	}

	/**
	 * Function was designed to pass values to database update statment.
	 * 
	 * 
	 * @param newValues
	 * @param dbo3
	 * @param id
	 * @return
	 */
	private HashMap<String, String> processPersonelEditRequest(HashMap<String, String> newValues,
			DBO_CRM_company_personnel dbo3, Integer id) {
		return dbo3.updateRecordById(newValues, id);
	}
	
	private ArrayList<CRM_user_information> getUserInfo(Integer companyId) {
		DBO_CRM_user dbocu = new DBO_CRM_user();
		DOB_CRM_user_information dboui = new DOB_CRM_user_information();
		return dboui.getByIdFromList(dbocu.getAllForCompany(companyId));
	}

}
