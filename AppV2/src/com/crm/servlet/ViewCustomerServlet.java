package com.crm.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
import com.crm.client.company.CRM_company_phoneNo;
import com.crm.client.user.CRM_user_master;
import com.crm.utils.ApplicationErrorLoging;
import com.crm.utils.ApplicationUtils;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_notes;
import com.db.mysql.models.DBO_CRM_company_personnel;
import com.db.mysql.models.DBO_CRM_company_phoneNo;

public class ViewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		HttpSession _SESSION = request.getSession();
		String baseURI = ApplicationUtils.getBasePathOfURI(request);
		System.out.println(baseURI);

		if (_SESSION.getAttribute("DELETENOTIFICATION") != null
				&& _SESSION.getAttribute("DELETENOTIFICATION").equals("OK")) {
			request.setAttribute("DELETE_MSG", "Entrie Successful deleted!");
		}

		try {
			String url = ApplicationUtils.getPathURL(request);
			String idStr = url.substring(url.lastIndexOf('/') + 1);
			id = Integer.parseInt(idStr);

		} catch (NumberFormatException e) {
			ApplicationErrorLoging.log("ViewCustomerServlet.java", e);
			response.sendRedirect(baseURI + "404");
			return;
		}

		try {
			Object crmCompany = DBO_CRM_company.getById(id, ((CRM_user_master) _SESSION.getAttribute("CLIENT_MASTER_INFO")).getId());
			ArrayList<CRM_company_address> crmCompanyAddresses = DBO_CRM_company_address.getByCompanyId(id);
			ArrayList<CRM_company_email_address> crmCompanyEmailAddresses = DBO_CRM_company_email_address.getByCompanyId(id);
			ArrayList<CRM_company_notes> crmCompanyNotes = DBO_CRM_company_notes.getByCompanyId(id);
			ArrayList<CRM_company_phoneNo> crmPhoneNumbers = DBO_CRM_company_phoneNo.getByCompanyId(id);
			ArrayList<CRM_company_personnel> crmCompanyPersonnel = DBO_CRM_company_personnel.getByCompanyId(id);

			request.setAttribute("crmCompany", crmCompany);
			request.setAttribute("crmCompanyAddresses", crmCompanyAddresses);
			request.setAttribute("crmCompanyEmailAddresses", crmCompanyEmailAddresses);
			request.setAttribute("crmCompanyNotes", crmCompanyNotes);
			request.setAttribute("crmPhoneNumbers", crmPhoneNumbers);
			request.setAttribute("crmCompanyPersonnel", crmCompanyPersonnel);

			lastFiveViewCompanies(request, (CRM_company) crmCompany);

		} catch (Exception e) {
			ApplicationErrorLoging.log("ViewCustoemrServlet.java", e);
			response.sendRedirect(baseURI + "404");
			return;
		}

		ApplicationUtils.openJSP(request, response, "/WEB-INF/views/view.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Function witch saves last 5 companies into a session for further use
	 * 
	 * @param request
	 * @param cc
	 */
	private void lastFiveViewCompanies(HttpServletRequest request, CRM_company cc) {
		HttpSession _SESSION = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<CRM_company> last5cc = (ArrayList<CRM_company>) _SESSION.getAttribute("LAST5CUST");
		if (last5cc == null || last5cc.size() < 1 || last5cc.isEmpty()) {
			last5cc = new ArrayList<CRM_company>();
			last5cc.add(cc);
		} else {
			for (CRM_company tempcc : last5cc) {
				if (tempcc.getId().equals(cc.getId())) {
					_SESSION.setAttribute("LAST5CUST", last5cc);
					return;
				}
			}
			last5cc.add(0, cc);
		}

		if (last5cc.size() > 5) {
			last5cc.remove(last5cc.size() - 1);
		}

		_SESSION.setAttribute("LASTVIEWCOMPANY", cc);
		_SESSION.setAttribute("LAST5CUST", last5cc);

	}

}
