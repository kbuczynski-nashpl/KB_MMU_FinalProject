package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.db.mysql.MySQL;

public class DBO_CRMCompany extends MySQL{
	
	public DBO_CRMCompany() {
		super();
	}

	public ArrayList<HashMap> getById(String id){
		String queryString = "SELECT * FROM company WHERE id = '" + id + "'";
		return query(queryString);
	}
	
	public ArrayList<HashMap> getByName(String name){
		String queryString = "SELECT * FROM company WHERE name = '" + name + "'";
		return query(queryString);
	}
}
