package com.employe.user;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.db.mysql.DBOEmployeUsers;

public class EmployeUserClass extends EmployeClass{

	private String EmployeUserName = null;
	private String EmployePsw = null;
	private String EmployeEmail = null;
	
	private final String emailPattern ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	Pattern pattern;
	Matcher matcher;
	
	public EmployeUserClass(String userName, String psw, String email) {
		super();
		this.EmployeUserName = validateUserName(userName);
		this.EmployePsw = validatePsw(psw);
		this.EmployeEmail = validateEmail(email);
	}
	
	public String validateUserName(String userName) {
		String returnValue = userName;
		if(userName.length() <= 0 || userName.length() > 25) {
			return "FAIL: Wrong userName Length";
		} else {
			return returnValue;
		}
	}
	
	public String validatePsw(String psw) {
		try {
			String genHashPSW = null;
			MessageDigest mdInstance = MessageDigest.getInstance("MD5");
			mdInstance.update(psw.getBytes());
			byte[] bytes = mdInstance.digest();
			StringBuilder stringBuilder = new StringBuilder();
			for(int iterator = 0; iterator < bytes.length; iterator++) {
				stringBuilder.append(Integer.toString((bytes[iterator] & 0xff)+ 0x100, 16).substring(1));
			}
			genHashPSW= stringBuilder.toString();
		}catch(NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		DBOEmployeUsers dbo = new DBOEmployeUsers();
		HashMap<Integer, HashMap<String, String>> result = dbo.getUserByUserName(this.EmployeUserName);
		//TODO: VALIDATE RESULT Hash 
		
		
		return "null";
	}
	
	//TODO: Validate Email Entry
	public String validateEmail(String email) {
		this.pattern = Pattern.compile(this.emailPattern);
		this.matcher = this.pattern.matcher(email);
		if(this.matcher.matches()) {
			return "FAIL: Invalid Email";
		}else {
			return email;
		}
	}
}
