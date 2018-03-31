package com.crm.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crm.client.user.CRM_user;
import com.crm.client.user.CRM_user_information;
import com.crm.client.user.CRM_user_master;
import com.db.mysql.models.DBO_CRM_user;
import com.db.mysql.models.DBO_CRM_user_information;
import com.db.mysql.models.DBO_CRM_user_master;

public final class ApplicationUtils {
	public final static String[] note_status = { "IN REVIEW", "OPEN", "REQUIRE RESPONSE", "CLOSED" };
	public final static String[] countires = { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
			"Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia",
			"Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
			"Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil",
			"British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia",
			"Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
			"Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
			"Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
			"Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
			"Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
			"Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France",
			"France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon",
			"Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe",
			"Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands",
			"Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia",
			"Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
			"Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait",
			"Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia",
			"Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau",
			"Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali",
			"Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico",
			"Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco",
			"Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
			"New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island",
			"Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay",
			"Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania",
			"Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines",
			"Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone",
			"Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
			"South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena",
			"St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden",
			"Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan",
			"Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia",
			"Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
			"United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
			"Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
			"Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe" };

	public static String getPathURI(HttpServletRequest request) {
		return ((HttpServletRequest) request).getRequestURI();
	}

	public static String getPathURL(HttpServletRequest request) {
		return request.getRequestURL().toString();
	}

	public static String getBasePathOfURI(HttpServletRequest request) {
		String path = getPathURI(request);
		return path.substring(0, path.length() - ((HttpServletRequest) request).getRequestURI().length())
				+ ((HttpServletRequest) request).getContextPath() + "/";
	}

	public static void openJSP(HttpServletRequest request, HttpServletResponse response, String jspPath)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(jspPath);
		dispatcher.forward(request, response);
		return;
	}

	public static String[] urlSplit(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		return url.split("/");
	}
	
	public static String getDate(Integer plusDays, String format) {
		Date currentDate = new Date();
		DateFormat dataFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(currentDate); 
		cal.add(Calendar.DATE, plusDays);
		currentDate = cal.getTime();
		return dataFormat.format(currentDate);
	}
	
	public static void updateUserSessionInformation(HttpServletRequest request, HttpServletResponse response) {
		HttpSession _SESSION = request.getSession();
		String baseURI = ApplicationUtils.getBasePathOfURI(request);
		CRM_user cu = ((CRM_user) _SESSION.getAttribute("CLIENT"));
		CRM_user_information cui = ((CRM_user_information) _SESSION.getAttribute("CLIENT_INFO"));
		CRM_user_master cum = ((CRM_user_master) _SESSION.getAttribute("CLIENT_MASTER_INFO"));
		
		try {
			cu = DBO_CRM_user.getUserById(cu.getId());
			cui = DBO_CRM_user_information.getByUserId(cu.getId());
			cum = DBO_CRM_user_master.getById(cu.getUser_master_id());
		} catch (NumberFormatException e) {
			ApplicationErrorLoging.log("ApplicationUtils.java", e);
			try {
				response.sendRedirect(baseURI + "404");
			} catch (IOException e1) {
				ApplicationErrorLoging.log("ApplicationUtils.java", e1);
			}
			return;
		} catch (ParseException e) {
			ApplicationErrorLoging.log("ApplicationUtils.java", e);
			try {
				response.sendRedirect(baseURI + "404");
			} catch (IOException e1) {
				ApplicationErrorLoging.log("ApplicationUtils.java", e);
			}
			return;
		}
		
		_SESSION.setAttribute("CLIENT", cu);
		_SESSION.setAttribute("CLIENT_MASTER_INFO", cum);
		_SESSION.setAttribute("CLIENT_INFO", cui);
		return;
	}

}
