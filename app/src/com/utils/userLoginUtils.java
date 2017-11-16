package com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import com.db.mysql.DBOEmployeUsers;

public class userLoginUtils {

	public static void validatePsw(String psw, String userName) {
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
		HashMap<Integer, HashMap<String, String>> result = dbo.getUserByUserName(userName);
		//TODO: VALIDATE RESULT Hash 
		
	}
}
