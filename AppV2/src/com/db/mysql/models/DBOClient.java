package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.db.mysql.MySQL;

public class DBOClient extends MySQL {
	public DBOClient() {
		super();
	}
	
	public ArrayList<HashMap> getUserByUserName(String userName) {
		String queryString = "SELECT * FROM client_user WHERE client_username = " + userName;
		return query(queryString);
	}
}
