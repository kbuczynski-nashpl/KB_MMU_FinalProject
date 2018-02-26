package com.crm.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.client.company.CRM_company;
import com.crm.utils.userLoginUtils;
import com.db.mysql.models.DBO_CRM_company;
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = request.getRequestURL().toString();
			String keyword = url.substring(url.lastIndexOf('/') + 1);
			keyword = java.net.URLDecoder.decode(keyword, "UTF-8");
			request.setAttribute("SEARCHRESULT", this.search(keyword));
		} catch (NullPointerException e) {
			request.setAttribute("SEARCHRESULT", "NO KEYWORD TO SEARCH FOR");
		}
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private HashMap<Integer, CRM_company> search(String keyword) {
		String type = "";
		
		if(StringUtils.isStrictlyNumeric(keyword) == true) {
			type = "NUMBER";
		} else if(userLoginUtils.validateEmail(keyword) != true) {
			type = "EMAIL";
		} else {
			type = "ALL";
		}
		return this.gatherData(keyword, type);
	}
	
	private HashMap<Integer, CRM_company> gatherData(String keyword, String type) {
		DBO_CRM_company dbo0 = new DBO_CRM_company();
		switch (type) {
			case "NUMBER":
				keyword = this.cleanTelNumber(keyword);
				int number = Integer.parseInt(keyword.trim());
				return dbo0.getCompanyByPhoneNumber(number);
			case "EMAIL":
				keyword = keyword.toLowerCase();
				return dbo0.getCompanyByEmailAddress(keyword);
			case "ALL":
				return dbo0.searchForCompany(keyword);
			default :
				return dbo0.searchForCompany(keyword);
		}
	}
	
	private String cleanTelNumber(String keyword) {
		keyword = keyword.replaceAll("\\D+", "");
		if(keyword.startsWith("0")) {
			keyword = keyword.substring(0, keyword.length());
		}
		if(keyword.startsWith("0")) {
			cleanTelNumber(keyword);
		}
		return keyword;
	}

}
