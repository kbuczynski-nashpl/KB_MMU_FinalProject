package com.crm.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.user.CRM_user;
import com.crm.client.user.CRM_user_information;
import com.crm.client.user.CRM_user_master;
import com.crm.utils.ApplicationErrorLoging;
import com.crm.utils.ApplicationUtils;
import com.db.mysql.models.DBO_CRM_user;
import com.db.mysql.models.DBO_CRM_user_information;

public class UserSettingsServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	public UserSettingsServlet() {
		super();

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession _SESSION = request.getSession();
		String baseURI = ApplicationUtils.getBasePathOfURI(request);
		String type = new String();
		try {
			String url = ApplicationUtils.getPathURL(request);
			type = new String(url.substring(url.lastIndexOf('/') + 1).toString());
		} catch (NumberFormatException e) {
			ApplicationErrorLoging.log("UserSettings.java", e);
			response.sendRedirect(baseURI + "404");
			return;
		}
		
		if(type.equals("post")) {
			HashMap<String, String> result = this.handlePost(request, response);
			ApplicationUtils.updateUserSessionInformation(request,response);
			_SESSION.setAttribute("EDIT_RESPONSE", result);
			response.sendRedirect(baseURI + "settings");
			return;
		}
		
		if (_SESSION.getAttribute("EDIT_RESPONSE") != null) {
			if (((HashMap<String, String>) _SESSION.getAttribute("EDIT_RESPONSE")).get("STATUS").equals("ERROR")) {
				request.setAttribute("error", ((HashMap<String, String>) _SESSION.getAttribute("EDIT_RESPONSE")).get("MSG"));
			} else {
				request.setAttribute("success", ((HashMap<String, String>) _SESSION.getAttribute("EDIT_RESPONSE")).get("MSG"));
			}
		}
		
		request.setAttribute("CU", ((CRM_user) _SESSION.getAttribute("CLIENT")));
		request.setAttribute("CUI", ((CRM_user_information) _SESSION.getAttribute("CLIENT_INFO")));
		request.setAttribute("CUM", ((CRM_user_master) _SESSION.getAttribute("CLIENT_MASTER_INFO")));
		ApplicationUtils.openJSP(request, response, "/WEB-INF/views/userSettings.jsp");
		return;
	}

	private HashMap<String, String> handlePost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession _SESSION = request.getSession();
		HashMap<String, String> sqlResponse = new HashMap<String, String>();
		if(request.getParameter("usersettingstype") != null && request.getParameter("usersettingstype").toString().equals("true")) {
			if(request.getParameter("userSurname") == null) {
				sqlResponse.put("STATUS", "ERROR");
				sqlResponse.put("MSG", "Surname field can not be empty");
				return sqlResponse;
			}
			
			if(request.getParameter("userForname") == null) {
				sqlResponse.put("STATUS", "ERROR");
				sqlResponse.put("MSG", "Forname field can not be empty");
				return sqlResponse;
			}
			
			if(request.getParameter("userDOB") == null) {
				sqlResponse.put("STATUS", "ERROR");
				sqlResponse.put("MSG", "Date of Birth field can not be empty");
				return sqlResponse;
			}
			
			HashMap<String, String> postValues = new HashMap<String,String>();
			postValues.put("userSurname", request.getParameter("userSurname").toString());
			postValues.put("userForname",request.getParameter("userForname").toString());
			postValues.put("userDOB", request.getParameter("userDOB").toString());
			sqlResponse = DBO_CRM_user_information.updateInformation(postValues, ((CRM_user) _SESSION.getAttribute("CLIENT")).getId());
			if(sqlResponse.get("STATUS").equals("ERROR")) {
				sqlResponse.put("MSG", "Something went wrong. Please contact the administrator");
				return sqlResponse;
			}
		}
		
		if(request.getParameter("usersettingspswtype") != null && request.getParameter("usersettingspswtype").toString().equals("true")) {		
			if(!request.getParameter("userPsw").toString().equals(request.getParameter("userConfPsw").toString())) {
				sqlResponse.put("STATUS", "ERROR");
				sqlResponse.put("MSG", "Password does not match");
				return sqlResponse;
			}
			
			sqlResponse = DBO_CRM_user.updatePsw(request.getParameter("userPsw").toString(), ((CRM_user) _SESSION.getAttribute("CLIENT")).getId());
			
			if(sqlResponse.get("STATUS").equals("ERROR")){
				sqlResponse.put("MSG", "Something went wrong. Please contact the administrator");
				return sqlResponse;
			}
		}
		
		if(request.getParameter("usersettingsemailtype") != null && request.getParameter("usersettingsemailtype").equals("true")) {
			if(request.getParameter("userEmail") == null) {
				sqlResponse.put("STATUS", "ERROR");
				sqlResponse.put("MSG", "Email can not be empty");
				return sqlResponse;
			}
			
			sqlResponse = DBO_CRM_user.updateEmail(request.getParameter("userEmail").toString(), ((CRM_user) _SESSION.getAttribute("CLIENT")).getId());
		}
		
		sqlResponse.put("MSG", "Your details has been updated");
		return sqlResponse;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
