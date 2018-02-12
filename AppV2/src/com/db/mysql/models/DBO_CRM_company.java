package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company;
import com.db.mysql.MySQL;

public class DBO_CRM_company extends MySQL {
	private ArrayList<CRM_company> crmCompaniesSearchResult = new ArrayList<CRM_company>();

	public DBO_CRM_company() {
		super();
	}

	public CRM_company getById(int id) {
		String queryString = "SELECT * FROM CRM_company WHERE id = '" + id + "'";
		ArrayList<HashMap<String, String>> responseFromMysql = query(queryString);
		CRM_company newCompany = new CRM_company();
		newCompany.setId(Integer.parseInt(responseFromMysql.get(0).get("id").toString()));
		newCompany
				.setCRM_user_master_id(Integer.parseInt(responseFromMysql.get(0).get("CRM_user_master_id").toString()));
		newCompany.setCompany_name(responseFromMysql.get(0).get("company_name").toString());
		return newCompany;
	}

	public ArrayList<HashMap<String, String>> getByName(String name) {
		String queryString = "SELECT * FROM CRM_company WHERE name = '" + name + "'";
		return query(queryString);
	}

	public ArrayList<CRM_company> getCompanyByPhoneNumber(int number) {
		String queryString = "SELECT * from CRM_company_phoneNo where phoneNo like %" + number + "%";
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company> crmCompanies = new ArrayList<CRM_company>();
		for (HashMap<String, String> entries : resultFromMysql) {
			int companyId = Integer.parseInt(entries.get("company_id").toString());
			CRM_company resultFromMysql1 = this.getById(companyId);
			crmCompanies.add(resultFromMysql1);
		}
		return crmCompanies;
	}

	public ArrayList<CRM_company> getCompanyByEmailAddress(String email) {
		String queryString = "SELECT * from CRM_company_email_address where company_email_address like %" + email;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company> crmCompanies = new ArrayList<CRM_company>();
		for (HashMap<String, String> entries : resultFromMysql) {
			int companyId = Integer.parseInt(entries.get("company_id").toString());
			CRM_company resultFromMysql1 = this.getById(companyId);
			crmCompanies.add(resultFromMysql1);
		}
		return crmCompanies;
	}

	public ArrayList<CRM_company> searchForCompany(String keyword) {
		ArrayList<HashMap<String, String>> resultFromMysql = new ArrayList<HashMap<String, String>>();

		// 1st Search
		String queryString = "SELECT * from CRM_company where company_name like %" + keyword + "%";
		resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			this.parseSearchQuery(resultFromMysql);
		}

		// 2nd Search
		queryString = "SELECT * FROM CRM_company_address WHERE (company_address_line1 LIKE %" + keyword
				+ "%) OR (company_address_line2 LIKE %" + keyword + "%) OR (company_address_postcode like %" + keyword
				+ "%) OR (company_address_city like %" + keyword + "%) OR (company_address_country like %" + keyword
				+ "%)";
		resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			this.parseSearchQuery(resultFromMysql);
		}

		// 3rd Search
		queryString = "SELECT * FROM CRM_company_notes WHERE 1 company_note_title like %" + keyword + "%";
		resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			this.parseSearchQuery(resultFromMysql);
		}

		// 4th Search
		queryString = "SELECT * FROM CRM_company_personnel WHERE (company_personnel_surname LIKE %" + keyword
				+ "%) OR (company_personnel_forname LIKE %" + keyword + "%) OR (company_personnel_email LIKE %"
				+ keyword + "%) OR (company_personnel_phoneNo LIKE %" + keyword + "%)";
		resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			this.parseSearchQuery(resultFromMysql);
		}

		return this.crmCompaniesSearchResult;
	}

	private void parseSearchQuery(ArrayList<HashMap<String, String>> result) {
		for (HashMap<String, String> entries : result) {
			if (entries.get("id") != null) {
				crmCompaniesSearchResult.add(this.getById(Integer.parseInt(entries.get("id").toString())));
			} else if (entries.get("company_id") != null) {
				crmCompaniesSearchResult.add(this.getById(Integer.parseInt(entries.get("company_id").toString())));
			}
		}
	}
}
