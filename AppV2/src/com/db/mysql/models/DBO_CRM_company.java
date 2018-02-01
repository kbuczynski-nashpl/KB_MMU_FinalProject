package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company;
import com.db.mysql.MySQL;

public class DBO_CRM_company extends MySQL{
	
	public DBO_CRM_company() {
		super();
	}

	public  CRM_company getById(int id){
		String queryString = "SELECT * FROM CRM_company WHERE id = '" + id + "'";
		ArrayList<HashMap<String,String>> responseFromMysql= query(queryString);
		CRM_company newCompany = new CRM_company();
		newCompany.setId(Integer.parseInt(responseFromMysql.get(0).get("id").toString()));
		newCompany.setCRM_user_master_id(Integer.parseInt(responseFromMysql.get(0).get("CRM_user_master_id").toString()));
		newCompany.setCompany_name(responseFromMysql.get(0).get("company_name").toString());
		return newCompany;
	}
	
	public  ArrayList<HashMap<String, String>> getByName(String name){
		String queryString = "SELECT * FROM CRM_company WHERE name = '" + name + "'";
		return query(queryString);
	}
}
