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
			CRM_company_personnel companyPersonnelEntry = new CRM_company_personnel();
			companyPersonnelEntry.setId(Integer.parseInt(entries.get("id").toString()));
			companyPersonnelEntry.setCompany_id(Integer.parseInt(entries.get("company_id").toString()));
			companyPersonnelEntry.setCompany_personnel_email(entries.get("company_personnel_email").toString());
			companyPersonnelEntry.setCompany_personnel_forname(entries.get("company_personnel_forname").toString());
			companyPersonnelEntry.setCompany_personnel_phoneNo(entries.get("company_personnel_phoneNo").toString());
			companyPersonnelEntry.setCompany_personnel_phoneNo_prefix(entries.get("company_personnel_phoneNo_prefix").toString());
			companyPersonnelEntry.setCompany_personnel_position(entries.get("company_personnel_position").toString());
			companyPersonnelEntry.setCompany_personnel_surname(entries.get("company_personnel_surname").toString());
			companyPersonnel.add(companyPersonnelEntry);
		}

		return companyPersonnel;

	}

}
