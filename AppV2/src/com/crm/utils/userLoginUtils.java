package com.crm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crm.client.user.CRM_user;
import com.crm.client.user.CRM_user_information;
import com.crm.client.user.CRM_user_master;
import com.db.mysql.models.DBO_CRM_user;
import com.db.mysql.models.DOB_CRM_user_information;
import com.db.mysql.models.DOB_CRM_user_master;

public class userLoginUtils {

	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	static Pattern pattern;
	static Matcher matcher;

	public static String HashPsw(String psw) {
		String genHashPSW = null;
		try {
			MessageDigest mdInstance = MessageDigest.getInstance("MD5");
			mdInstance.update(psw.getBytes());
			byte[] bytes = mdInstance.digest();
			StringBuilder stringBuilder = new StringBuilder();
			for (int iterator = 0; iterator < bytes.length; iterator++) {
				stringBuilder.append(Integer.toString((bytes[iterator] & 0xff) + 0x100, 16).substring(1));
			}
			genHashPSW = stringBuilder.toString();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return genHashPSW;
	}

	public static boolean validateLogin(String psw, String userName) {
		DBO_CRM_user dbo = new DBO_CRM_user();
		CRM_user cuc = dbo.getUserByUserName(userName);
			String entryPsw = cuc.getUser_psw();
			String entryUsrName = cuc.getUser_username();
			if (entryPsw.equals(psw) && entryUsrName.equals(userName)) {
				return true;
			}
		return false;
	}

	public static boolean validateUserName(String userName) {
		if (userName.length() <= 0 || userName.length() > 25) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validateEmail(String email) {
		pattern = Pattern.compile(emailPattern);
		matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return false;
		} else {
			return true;
		}
	}

	public static HashMap<String, Object> logIn(String usrname, String psw){
		DBO_CRM_user dob0 = new DBO_CRM_user();
		DOB_CRM_user_master dob1 = new DOB_CRM_user_master();
		DOB_CRM_user_information dob2 = new DOB_CRM_user_information();
		CRM_user cuc = dob0.getUserByUserName(usrname);
		CRM_user_master cum = dob1.getById(cuc.getId());
		CRM_user_information cui = new CRM_user_information();
		try {
			cui = dob2.getByUserId(cuc.getId());
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		HashMap<String, Object> result = new HashMap<String, Object>();
				
		try {
			cuc.setLogedIn();
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		if (cuc.getIsLogedIn() == true) {
			result.put("isLogged", "true");
			result.put("CRM_User", cuc);
			result.put("CRM_user_master", cum);
			result.put("CRM_user_information", cui);
		} else {
			result.put("isTrue","false");
		}

		return result;

	}

	public static boolean getUserLoginSession(HttpServletRequest request) {
		HttpSession _SESSION = request.getSession();
		CRM_user client = (CRM_user) _SESSION.getAttribute("CLIENT");
		if(client != null) {
			if(client.getIsLogedIn() == true) {
				return true;
			}
		}
		return false;
	}
}
