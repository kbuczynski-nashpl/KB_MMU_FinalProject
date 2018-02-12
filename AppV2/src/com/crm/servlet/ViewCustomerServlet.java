package com.crm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.client.company.CRM_company_address;
import com.crm.client.company.CRM_company_email_address;
import com.crm.client.company.CRM_company_notes;
import com.crm.client.company.CRM_company_personnel;
import com.crm.client.company.CRM_company_phoneNo;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_notes;
import com.db.mysql.models.DBO_CRM_company_personnel;
import com.db.mysql.models.DBO_CRM_company_phoneNo;

/**
 * Servlet implementation class ViewCustomerServlet
 */
@WebServlet("/ViewCustomerServlet")
public class ViewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewCustomerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		try {
			String url = request.getRequestURL().toString();
			String idStr = url.substring(url.lastIndexOf('/') + 1);
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
			response.sendRedirect("404");
			return;
		}
		DBO_CRM_company dbo0 = new DBO_CRM_company();
		DBO_CRM_company_address dbo1 = new DBO_CRM_company_address();
		DBO_CRM_company_email_address dbo2 = new DBO_CRM_company_email_address();
		DBO_CRM_company_notes dbo3 = new DBO_CRM_company_notes();
		DBO_CRM_company_phoneNo dbo4 = new DBO_CRM_company_phoneNo();
		DBO_CRM_company_personnel dbo5 = new DBO_CRM_company_personnel();
		try {
			Object crmCompany = dbo0.getById(id);
			ArrayList<CRM_company_address> crmCompanyAddresses = dbo1.getByCompanyId(id);
			ArrayList<CRM_company_email_address> crmCompanyEmailAddresses = dbo2.getByCompanyId(id);
			ArrayList<CRM_company_notes> crmCompanyNotes = dbo3.getByCompanyId(id);
			ArrayList<CRM_company_phoneNo> crmPhoneNumbers = dbo4.getByCompanyId(id);
			ArrayList<CRM_company_personnel> crmCompanyPersonnel = dbo5.getByCompanyId(id);
						
			request.setAttribute("crmCompany", crmCompany);
			request.setAttribute("crmCompanyAddresses", crmCompanyAddresses);
			request.setAttribute("crmCompanyEmailAddresses", crmCompanyEmailAddresses);
			request.setAttribute("crmCompanyNotes", crmCompanyNotes);
			request.setAttribute("crmPhoneNumbers", crmPhoneNumbers);
			request.setAttribute("crmCompanyPersonnel", crmCompanyPersonnel);
		} catch (Exception e) {
			System.err.println(e.getCause());
			System.err.println(e.getLocalizedMessage());
			System.err.println(e.getStackTrace());
			return;
		}

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/view.jsp");
		dispatcher.forward(request, response);
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

}
