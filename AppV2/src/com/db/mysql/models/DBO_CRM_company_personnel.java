package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company_personnel;
import com.db.mysql.MySQL;

public class DBO_CRM_company_personnel extends MySQL {
	public DBO_CRM_company_personnel() {
		super();
	}

	public ArrayList<CRM_company_personnel> getByCompanyId(int id) {
		String queryString = "SELECT * FROM CRM_company_personnel WHERE company_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_personnel> companyPersonnel = new ArrayList<CRM_company_personnel>();
		for (HashMap<String, String> entries : resultFromMysql) {
			CRM_company_personnel companyPersonnelEntry = new CRM_company_personnel(
					Integer.parseInt(entries.get("company_id").toString()),
					entries.get("company_personnel_surname").toString(),
					entries.get("company_personnel_forname").toString(),
					entries.get("company_personnel_email").toString(),
					entries.get("company_personnel_phoneNo").toString(),
					entries.get("company_personnel_phoneNo_prefix").toString(),
					entries.get("company_personnel_position").toString());
			companyPersonnelEntry.setId(Integer.parseInt(entries.get("id").toString()));
			companyPersonnel.add(companyPersonnelEntry);
		}
		return companyPersonnel;
	}

	public CRM_company_personnel getById(int id) {
		String queryString = "SELECT * from CRM_company_personnel where id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		if (resultFromMysql.size() > 0) {
			CRM_company_personnel ccp = new CRM_company_personnel(
					Integer.parseInt(resultFromMysql.get(0).get("id").toString()),
					Integer.parseInt(resultFromMysql.get(0).get("company_id").toString()),
					resultFromMysql.get(0).get("company_personnel_surname").toString(),
					resultFromMysql.get(0).get("company_personnel_forname").toString(),
					resultFromMysql.get(0).get("company_personnel_email").toString(),
					resultFromMysql.get(0).get("company_personnel_phoneNo").toString(),
					resultFromMysql.get(0).get("company_personnel_phoneNo_prefix").toString(),
					resultFromMysql.get(0).get("company_personnel_position").toString());
			return ccp;
		} else {
			CRM_company_personnel ccp = new CRM_company_personnel();
			return ccp;
		}
	}

	public HashMap<String, String> updateRecordById(HashMap<String, String> newValues, Integer id) {
		String queryString = "UPDATE CRM_company_personnel SET " + "company_personnel_surname = '"
				+ newValues.get("surname") + "'" + " ,company_personnel_forname = '" + newValues.get("forname") + "'"
				+ " ,company_personnel_email = '" + newValues.get("email") + "'" + " ,company_personnel_phoneNo = '"
				+ newValues.get("phoneNo") + "'" + " ,company_personnel_phoneNo_prefix = '"
				+ newValues.get("phoneNoPrefix") + "'" + " ,company_personnel_position = '" + newValues.get("position")
				+ "'" + " WHERE id = " + id;
		return update(queryString);
	}

	public HashMap<String, String> removePersonnelById(Integer id) {
		String queryString = "DELETE FROM CRM_company_personnel where id = " + id;
		return update(queryString);
	}

	public HashMap<String, String> newCompanyPersonnel(CRM_company_personnel ccp) {
		String queryString = "INSERT INTO CRM_company_personnel " + "(company_id, " + "company_personnel_surname, "
				+ "company_personnel_forname, " + "company_personnel_email, " + "company_personnel_phoneNo, "
				+ "company_personnel_phoneNo_prefix, " + "company_personnel_position) " + "VALUES ("
				+ ccp.getCompany_id() + ", " + "'" + ccp.getCompany_personnel_surname() + "', " + "'"
				+ ccp.getCompany_personnel_forname() + "', " + "'" + ccp.getCompany_personnel_email() + "', " + "'"
				+ ccp.getCompany_personnel_phoneNo() + "', " + "'" + ccp.getCompany_personnel_phoneNo_prefix() + "', "
				+ "'" + ccp.getCompany_personnel_position() + "')";
		return update(queryString);
	}

}
