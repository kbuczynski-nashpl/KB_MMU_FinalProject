package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company_email_address;
import com.db.mysql.MySQL;

public class DBO_CRM_company_email_address extends MySQL{
	public DBO_CRM_company_email_address() {
		super();
	}

	public ArrayList<CRM_company_email_address> getByCompanyId(int id) {
		String queryString = "SELECT * from CRM_company_email_address where company_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_email_address> companyEmailAddresses = new ArrayList<CRM_company_email_address>();
		for(HashMap<String, String> entries : resultFromMysql) {
			CRM_company_email_address crmCompanyEmailAddress = new CRM_company_email_address();
			if (entries.get("company_email_active").toString().equals("1")) {
				crmCompanyEmailAddress.setCompany_email_active(true);
			} else {
				crmCompanyEmailAddress.setCompany_email_active(false);

			}
			crmCompanyEmailAddress.setCompany_email_address(entries.get("company_email_address").toString());
			crmCompanyEmailAddress.setCompany_email_Type(entries.get("company_email_type").toString());
			crmCompanyEmailAddress.setCompany_id(Integer.parseInt(entries.get("company_id").toString()));
			crmCompanyEmailAddress.setId(Integer.parseInt(entries.get("id").toString()));
			companyEmailAddresses.add(crmCompanyEmailAddress);
		}
		return companyEmailAddresses;
	}
	

}
