package com.crm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.client.company.CRM_company;
import com.crm.client.company.CRM_company_address;
import com.crm.client.company.CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		String type;
		try {
			String url = request.getRequestURL().toString();
			System.out.println(url);
			String idStr = url.substring(url.lastIndexOf('/') + 1);
			String[] urlSplit = url.split("/");
			type = urlSplit[urlSplit.length - 2];
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
			String path = ((HttpServletRequest) request).getRequestURI();
			String baseURL = path.substring(0, path.length() - ((HttpServletRequest) request).getRequestURI().length())
					+ ((HttpServletRequest) request).getContextPath() + "/";
			response.sendRedirect(baseURL + "404");
			return;
		}
		DBO_CRM_company dbo0 = new DBO_CRM_company();
		DBO_CRM_company_email_address dbo1 = new DBO_CRM_company_email_address();
		DBO_CRM_company_address dbo2 = new DBO_CRM_company_address();

		switch (type) {
		case "main":
			if(request.getAttribute("type") != null) {
				processMainEditRequest();
			}
			CRM_company cc = dbo0.getById(id);
			ArrayList<CRM_company_email_address> companyEmailAddressList = dbo1.getByCompanyId(id);
			ArrayList<CRM_company_address> companyAddressList = dbo2.getByCompanyId(id);
			request.setAttribute("CC", cc);
			request.setAttribute("CCEA", companyEmailAddressList);
			request.setAttribute("CCA", companyAddressList);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/editMain.jsp");
			dispatcher.forward(request, response);
			
			break;
		default:
			break;
		}
		
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//TODO: process the main edit request
	private void processMainEditRequest() {
		return;
	}

}
