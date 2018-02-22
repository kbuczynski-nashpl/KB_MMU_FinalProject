package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company_email_address;
import com.db.mysql.MySQL;

public class DBO_CRM_company_email_address extends MySQL {
	public DBO_CRM_company_email_address() {
		super();
	}

	public ArrayList<CRM_company_email_address> getByCompanyId(int id) {
		String queryString = "SELECT * from CRM_company_email_address where company_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_email_address> companyEmailAddresses = new ArrayList<CRM_company_email_address>();
		for (HashMap<String, String> entries : resultFromMysql) {
			Boolean isActive = false;
			if (entries.get("company_email_active").toString().equals("1")) {
				isActive = true;
			} else {
				isActive = false;

			}
			CRM_company_email_address crmCompanyEmailAddress = new CRM_company_email_address(
					Integer.parseInt(entries.get("id").toString()),
					Integer.parseInt(entries.get("company_id").toString()),
					entries.get("company_email_address").toString(), entries.get("company_email_type").toString(),
					isActive);
			crmCompanyEmailAddress.setCompany_email_address(entries.get("company_email_address").toString());
			companyEmailAddresses.add(crmCompanyEmailAddress);
		}
		return companyEmailAddresses;
	}

	public void createNewCRMEmailAddress(CRM_company_email_address ccea) {
		String queryString = "INSERT INTO CRM_company_email_address (company_id, company_email_address, company_email_active, company_email_type) VALUES ("
				+ ccea.getCompany_id() + ", '" + ccea.getCompany_email_address() + "', '"
				+ ccea.getCompany_email_activeToInt() + "', '" + ccea.getCompany_email_type() + "')";
		query(queryString);
	}

}
