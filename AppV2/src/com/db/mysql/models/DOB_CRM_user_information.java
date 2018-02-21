package com.db.mysql.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.user.CRM_user_information;
import com.crm.client.user.CRM_user_master;
import com.db.mysql.MySQL;

public class DOB_CRM_user_information extends MySQL{
	public DOB_CRM_user_information(){
		super();
	}
	
	public CRM_user_information getByUserId(Integer id) throws NumberFormatException, ParseException {
		String queryString = "SELECT * FROM CRM_user_information WHERE user_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		CRM_user_information cui = new CRM_user_information();
		for (HashMap<String, String> entries : resultFromMysql) {
			cui = new CRM_user_information(Integer.parseInt(entries.get("id").toString()), Integer.parseInt(entries.get("user_id").toString()), entries.get("user_surname").toString(), entries.get("user_forname").toString(), entries.get("user_dob").toString());
		}
		return cui;
	}

}
