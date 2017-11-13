package com.db.mysql;

import java.util.HashMap;

public class DBOEmployeUsers extends MySQL {
	public DBOEmployeUsers() {
		super();
	}
	
	public HashMap<Integer, HashMap<String, String>> getUserByUserName(String userName) {
		String queryString = "SELECT * FROM EmployeUsers WHERE username = " + userName;
		return query(queryString);
	}
}
