package com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.db.mysql.DBOEmployeUsers;
import com.employe.user.EmployeUserClass;

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
		DBOEmployeUsers dbo = new DBOEmployeUsers();
		ArrayList<HashMap> result = dbo.getUserByUserName(userName);
		for (HashMap<String, String> res : result) {
			String entryPsw = res.get("password");
			String entryUsrName = res.get("username");
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

	public static boolean logIn(String usrname, String psw) {
		DBOEmployeUsers dob = new DBOEmployeUsers();
		ArrayList<HashMap> usr = dob.getUserByUserName(usrname);

		if (usr.size() > 1) {
			return false;
		}

		EmployeUserClass euc = new EmployeUserClass(usrname, psw);
		euc.setEmployeDoB(usr.get(0).get("DOB").toString());
		euc.setEmployeEmail(usr.get(0).get("Email").toString());
		euc.setEmployeForname(usr.get(0).get("Forname").toString());
		euc.setEmployeSurname(usr.get(0).get("Surname").toString());
		euc.setEmployeId(usr.get(0).get("Id").toString());
		euc.setLogedIn();

		if (euc.getLogedIn() == true) {
			return true;
		} else {
			return false;
		}
	}
}
