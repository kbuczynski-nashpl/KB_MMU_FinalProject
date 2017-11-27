package com.db.mysql;

import java.util.ArrayList;
import java.util.HashMap;

public class DBOEmployeUsers extends MySQL {
	public DBOEmployeUsers() {
		super();
	}
	
	public ArrayList<HashMap> getUserByUserName(String userName) {
		String queryString = "SELECT * FROM EmployeUsers WHERE username = " + userName;
		return query(queryString);
	}
}
