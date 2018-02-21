package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company;
import com.crm.client.user.CRM_user;
import com.db.mysql.MySQL;

public class DBO_CRM_user extends MySQL {
	public DBO_CRM_user() {
		super();
	}

	public CRM_user getUserByUserName(String userName) {
		String queryString = "SELECT * FROM CRM_user WHERE user_username = " + "'" + userName + "'";
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		CRM_user cuc = new CRM_user();
		for (HashMap<String, String> entries : resultFromMysql) {
			cuc = new CRM_user(Integer.parseInt(entries.get("id").toString()),
					Integer.parseInt(entries.get("user_master_id").toString()), entries.get("user_username").toString(),
					entries.get("user_psw").toString(), entries.get("user_email").toString());
		}
		return cuc;
	}
}
