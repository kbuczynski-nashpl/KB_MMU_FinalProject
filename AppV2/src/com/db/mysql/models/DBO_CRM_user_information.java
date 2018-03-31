package com.db.mysql.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.user.CRM_user_information;
import com.db.mysql.MySQL;

public class DBO_CRM_user_information extends MySQL {
	public DBO_CRM_user_information() {
		super();
	}

	public static CRM_user_information getByUserId(Integer id) throws NumberFormatException, ParseException {
		String queryString = "SELECT * FROM CRM_user_information WHERE user_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		CRM_user_information cui = new CRM_user_information();
		for (HashMap<String, String> entries : resultFromMysql) {
			cui = new CRM_user_information(Integer.parseInt(entries.get("id").toString()),
					Integer.parseInt(entries.get("user_id").toString()), entries.get("user_surname").toString(),
					entries.get("user_forname").toString(), entries.get("user_dob").toString());
		}
		return cui;
	}
	
	public static ArrayList<CRM_user_information> getByIdFromList(ArrayList<Integer> ids) {
		String queryString = "SELECT id, user_surname, user_forname FROM CRM_user_information WHERE id = ";
		ArrayList<CRM_user_information> result = new ArrayList<CRM_user_information>();
		ArrayList<HashMap<String, String>> resultFromMysql = new ArrayList<HashMap<String, String>>();
		for (Integer n : ids) {
			resultFromMysql = query(queryString + n);
			System.out.println(resultFromMysql);
			CRM_user_information cui = new CRM_user_information();
			cui.setUser_forname(resultFromMysql.get(0).get("user_forname"));
			cui.setUser_surname(resultFromMysql.get(0).get("user_surname"));
			cui.setId(Integer.parseInt(resultFromMysql.get(0).get("id").toString()));
			result.add(cui);
		}
		return result;
	}

	public static HashMap<String, String> updateInformation(HashMap<String, String> postValues, Integer id) {
		String queryString = "UPDATE CRM_user_information SET "
				+ "user_surname = '" + postValues.get("userSurname") + "',"
				+ " user_forname = '" + postValues.get("userForname") + "',"
				+ " user_dob = '" + postValues.get("userDOB") + "'"
				+ " WHERE user_id = " + id;
		return update(queryString);
	}

}
