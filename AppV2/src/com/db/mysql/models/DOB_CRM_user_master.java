package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.user.CRM_user_master;
import com.db.mysql.MySQL;

public class DOB_CRM_user_master extends MySQL {

	public DOB_CRM_user_master() {
		super();
	}
	
	public CRM_user_master getById(Integer id) {
		String queryString = "SELECT * FROM CRM_user_master WHERE id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		CRM_user_master cum = new CRM_user_master();
		for (HashMap<String, String> entries : resultFromMysql) {
			cum = new CRM_user_master(Integer.parseInt(entries.get("id").toString()), entries.get("user_company_name").toString());
		}
		return cum;
	}
}
