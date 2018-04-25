package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company;
import com.db.mysql.MySQL;

public class DBO_CRM_company extends MySQL {
	private static HashMap<Integer, CRM_company> resultMap = new HashMap<Integer, CRM_company>();

	public DBO_CRM_company() {
		super();
	}

	public static CRM_company getById(Integer id, Integer masterID) {
		String queryString = "";
		if (masterID == null) {
			queryString = "SELECT * FROM CRM_company WHERE id = '" + id + "'";
		} else { 
			queryString = "SELECT * FROM CRM_company WHERE id = '" + id + "' and CRM_user_master_id = '" + masterID + "'";

		}
		ArrayList<HashMap<String, String>> responseFromMysql = query(queryString);
		
		return new CRM_company(Integer.parseInt(responseFromMysql.get(0).get("id").toString()),
				Integer.parseInt(responseFromMysql.get(0).get("CRM_user_master_id").toString()),
				responseFromMysql.get(0).get("company_name").toString());
	}
	

	public static ArrayList<HashMap<String, String>> getByName(String name) {
		String queryString = "SELECT * FROM CRM_company WHERE name = '" + name + "'";
		return query(queryString);
	}

	public static HashMap<Integer, CRM_company> getCompanyByPhoneNumber(Integer number) {
		String queryString = "SELECT * from CRM_company_phoneNo where company_phoneNo like \"%" + number + "%\"";
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		HashMap<Integer, CRM_company> crmCompanies = new HashMap<Integer, CRM_company>();
		for (HashMap<String, String> entries : resultFromMysql) {
			Integer companyId = Integer.parseInt(entries.get("company_id").toString());
			CRM_company resultFromMysql1 = getById(companyId, null);
			crmCompanies.put(companyId, resultFromMysql1);
		}
		return crmCompanies;
	}

	public static HashMap<Integer, CRM_company> getCompanyByEmailAddress(String email) {
		String queryString = "SELECT * from CRM_company_email_address where company_email_address like \"%" + email
				+ "\"";
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		HashMap<Integer, CRM_company> crmCompanies = new HashMap<Integer, CRM_company>();
		for (HashMap<String, String> entries : resultFromMysql) {
			int companyId = Integer.parseInt(entries.get("company_id").toString());
			CRM_company resultFromMysql1 = getById(companyId, null);
			crmCompanies.put(companyId, resultFromMysql1);
		}
		return crmCompanies;
	}

	public static  HashMap<Integer, CRM_company> searchForCompany(String keyword) {
		ArrayList<HashMap<String, String>> resultFromMysql = new ArrayList<HashMap<String, String>>();
		resultMap = new HashMap<Integer, CRM_company>();

		// 1st Search
		String queryString = "SELECT * from CRM_company where company_name like \"%" + keyword + "%\"";
		resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			for (HashMap<String, String> entries : resultFromMysql) {
				resultMap.put(Integer.parseInt(entries.get("id").toString()),
						getById(Integer.parseInt(entries.get("id").toString()), Integer.parseInt(entries.get("CRM_user_master_id").toString())));
			}
		}

		// 2nd Search
		queryString = "SELECT * FROM CRM_company_address WHERE (company_address_line1 LIKE \"%" + keyword
				+ "%\") OR (company_address_line2 LIKE \"%" + keyword + "%\") OR (company_address_postcode like \"%"
				+ keyword + "%\") OR (company_address_city like \"%" + keyword
				+ "%\") OR (company_address_country like \"%" + keyword + "%\")";
		resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			parseSearchQuery(resultFromMysql);
		}

		// 3rd Search
		queryString = "SELECT * FROM CRM_company_notes WHERE company_note_title like \"%" + keyword + "%\"";
		resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			parseSearchQuery(resultFromMysql);
		}

		// 4th Search
		queryString = "SELECT * FROM CRM_company_personnel WHERE (company_personnel_surname LIKE \"%" + keyword
				+ "%\") OR (company_personnel_forname LIKE \"%" + keyword + "%\") OR (company_personnel_email LIKE \"%"
				+ keyword + "%\") OR (company_personnel_phoneNo LIKE \"%" + keyword + "%\")";
		resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			parseSearchQuery(resultFromMysql);
		}
		return resultMap;
	}

	public static HashMap<String, String> createNewCrmCompany(CRM_company cc) {
		String queryString = "INSERT INTO CRM_company (CRM_user_master_id, company_name) VALUES ('"
				+ cc.getCRM_user_master_id() + "', '" + cc.getCompany_name() + "')";
		return update(queryString);
	}

	private static void parseSearchQuery(ArrayList<HashMap<String, String>> result) {
		for (HashMap<String, String> entries : result) {
			if (entries.get("company_id") != null) {
				resultMap.put(Integer.parseInt(entries.get("company_id").toString()),
						getById(Integer.parseInt(entries.get("company_id").toString()), null));
			}
		}
	}

	public static HashMap<String, String> removeById(Integer id) {
		String queryString = "DELETE FROM CRM_company WHERE id = " + id;
		return update(queryString);
	}
	
	public static HashMap<String,String> updateCompanyName(String companyName, Integer companyId){
		String queryString = "UPDATE CRM_company SET company_name =  '" + companyName +"' "
				+ "WHERE id = " + companyId;
		return update(queryString);
	}

}
