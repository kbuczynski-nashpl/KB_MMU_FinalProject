package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.db.mysql.MySQL;

public class DBO_CRMUser extends MySQL {
	public DBO_CRMUser() {
		super();
	}
	
	public ArrayList<HashMap<String, String>> getUserByUserName(String userName) {
		String queryString = "SELECT * FROM CRM_user WHERE user_username = " + "'" + userName + "'";
		return query(queryString);
	}
}
