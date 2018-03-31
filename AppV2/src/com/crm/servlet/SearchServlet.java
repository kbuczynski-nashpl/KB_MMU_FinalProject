package com.crm.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.client.company.CRM_company;
import com.crm.utils.ApplicationErrorLoging;
import com.crm.utils.ApplicationUtils;
import com.crm.utils.LoginUtils;
import com.db.mysql.models.DBO_CRM_company;
import com.mysql.jdbc.StringUtils;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String url = request.getRequestURL().toString();
			String keyword = url.substring(url.lastIndexOf('/') + 1);
			keyword = java.net.URLDecoder.decode(keyword, "UTF-8");
			HashMap<Integer, CRM_company> result = this.search(keyword);
			if (!result.isEmpty()) {
				request.setAttribute("SEARCHRESULT", result);
			} else {
				request.setAttribute("SEARCHRESULT", "NO KEYWORD TO SEARCH FOR");
			}
		} catch (NullPointerException e) {
			ApplicationErrorLoging.log("SearchServlet.java", e);
		}
		ApplicationUtils.openJSP(request, response, "/WEB-INF/views/search.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * A function to determinate the type of a keyword and pass it to a search
	 * function
	 * 
	 * @param keyword
	 * @return HashMap with result entries from database
	 */
	private HashMap<Integer, CRM_company> search(String keyword) {
		String type;

		if (StringUtils.isStrictlyNumeric(keyword) == true) {
			type = new String("NUMBER");
		} else if (LoginUtils.validateEmail(keyword) != true) {
			type = new String("EMAIL");
		} else {
			type = new String("ALL");
		}
		return this.gatherData(keyword, type);
	}

	/**
	 * A function which will pass a request to models to perform a search for given
	 * keyword based on a type.
	 * 
	 * @param keyword
	 * @param type
	 * @return HashMap with result set.
	 */
	private HashMap<Integer, CRM_company> gatherData(String keyword, String type) {
		switch (type) {
		case "NUMBER":
			keyword = this.cleanTelNumber(keyword);
			int number = Integer.parseInt(keyword.trim());
			return DBO_CRM_company.getCompanyByPhoneNumber(number);
		case "EMAIL":
			keyword = keyword.toLowerCase();
			return DBO_CRM_company.getCompanyByEmailAddress(keyword);
		case "ALL":
			return DBO_CRM_company.searchForCompany(keyword);
		default:
			return DBO_CRM_company.searchForCompany(keyword);
		}
	}

	/**
	 * A Function to remove ++ +XX 00 0 from a number;
	 * 
	 * @param keyword
	 * @return String with a clean phone number
	 */
	private String cleanTelNumber(String keyword) {
		keyword = keyword.replaceAll("\\D+", "");
		if (keyword.startsWith("0")) {
			keyword = keyword.substring(0, keyword.length());
		}
		if (keyword.startsWith("0")) {
			cleanTelNumber(keyword);
		}
		return keyword;
	}

}
