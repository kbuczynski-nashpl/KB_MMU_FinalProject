package com.crm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crm.client.user.CRMUser;
import com.crm.servlet.sessionHandler.SessionProperties;
import com.db.mysql.models.DBO_CRMUser;

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
		DBO_CRMUser dbo = new DBO_CRMUser();
		ArrayList<HashMap> result = dbo.getUserByUserName(userName);
		for (HashMap<String, String> res : result) {
			String entryPsw = res.get("user_psw");
			String entryUsrName = res.get("user_username");
			if (entryPsw.equals(psw) && entryUsrName.equals(userName)) {
				return true;
			}
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

	public static List logIn(String usrname, String psw) {
		DBO_CRMUser dob = new DBO_CRMUser();
		ArrayList<HashMap> usr = dob.getUserByUserName(usrname);
		List result = new ArrayList();


		if (usr.size() < 1) {
			result.add("false");
			return result;
		}

		CRMUser cuc = new CRMUser();
		cuc.setClientPsw(psw);
		cuc.setClientUsername(usrname);
		try {
			cuc.setClientEmail(usr.get(0).get("user_email").toString());
			cuc.setId(Integer.valueOf(usr.get(0).get("user_master_id").toString()));
			cuc.setLogedIn();
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
		
		if (cuc.getIsLogedIn() == true) {
			result.add("true");
			result.add(cuc);
			return result;
		} else {
			result.add("false");
			return result;
		}
	}
	public static boolean checkUserSession(HttpServletRequest request) {
		HttpSession _SESSION = request.getSession();
		String _SESSION_ID = _SESSION.getId();
		long _SESSION_START_TIME = _SESSION.getCreationTime();
		long _SESSION_LAST_ACCESS_TIME = _SESSION.getLastAccessedTime();
		Boolean _SESSION_IS_NEW = _SESSION.isNew();
		System.out.println(_SESSION_IS_NEW);
		if(_SESSION_IS_NEW == true || _SESSION.getAttribute("CLIENT") == null) {
			 SessionProperties _SESSION_PROPERTIES = new SessionProperties(_SESSION_ID, _SESSION_START_TIME, _SESSION_LAST_ACCESS_TIME, _SESSION_IS_NEW);
			_SESSION.setAttribute("SESSION", _SESSION_PROPERTIES);
		} else {
			SessionProperties _SESSION_PROPERTIES = (SessionProperties) _SESSION.getAttribute("SESSION");
			CRMUser client = (CRMUser) _SESSION.getAttribute("CLIENT");
			if(client.getIsLogedIn() == true) {
				return true;
			}
		}
		return false;
	}
}
