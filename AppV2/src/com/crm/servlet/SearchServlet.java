package com.crm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.utils.userLoginUtils;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_phoneNo;
import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = request.getRequestURL().toString();
			String keyword = url.substring(url.lastIndexOf('/') + 1);
			this.search(keyword);
		} catch (NullPointerException e) {
			request.setAttribute("NULLSEARCH", "NO KEYWORD TO SEARCH FOR");
		}
			
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void search(String keyword) {
		String type = "";
		
		if(StringUtils.isStrictlyNumeric(keyword) == true) {
			type = "NUMBER";
		} else if(userLoginUtils.validateEmail(keyword) == true) {
			type = "EMAIL";
		} else {
			type = "ALL";
		}
		ArrayList<ArrayList<?>> searchResult = this.gatherData(keyword, type);
	}
	
	private ArrayList<ArrayList<?>> gatherData(String keyword, String type) {
		ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
		DBO_CRM_company dbo0 = new DBO_CRM_company();
		switch (type) {
			case "NUMBER":
				data.add(dbo0.getCompanyByPhoneNumber(Integer.parseInt(keyword)));
				break;
			case "EMAIL":
				data.add(dbo0.getCompanyByEmailAddress(keyword));
				break;
			case "ALL":
				data.add(dbo0.searchForCompany(keyword));
				break;
			default :
				data.add(dbo0.searchForCompany(keyword));
				break;
		}
		return data;
	}

}
