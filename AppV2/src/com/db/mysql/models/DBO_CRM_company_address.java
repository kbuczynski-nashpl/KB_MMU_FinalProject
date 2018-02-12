package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;
import com.crm.client.company.CRM_company_address;
import com.db.mysql.MySQL;
import com.mysql.jdbc.StringUtils;

public class DBO_CRM_company_address extends MySQL{
	public DBO_CRM_company_address(){
		super();
	}

	public ArrayList<CRM_company_address> getByCompanyId(int id) {
		String queryString = "SELECT * from CRM_company_address where company_id =" + id;
		ArrayList<HashMap<String,String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_address> companyAddresses = new ArrayList<CRM_company_address>();
		for(HashMap<String, String> entries : resultFromMysql) {
			CRM_company_address crmCompanyAddress = new CRM_company_address();
			crmCompanyAddress.setCompany_id(Integer.parseInt(entries.get("company_id").toString()));
			crmCompanyAddress.setCompany_address_city(entries.get("company_address_city").toString());
			crmCompanyAddress.setCompany_address_country(entries.get("company_address_country").toString());
			crmCompanyAddress.setCompany_address_line1(entries.get("company_address_line1").toString());
			if(!StringUtils.isNullOrEmpty(entries.get("company_address_line2"))) {
				crmCompanyAddress.setCompany_address_line2(entries.get("company_address_line2").toString());
			}
			if (entries.get("company_address_active").toString().equals("1")) {
				crmCompanyAddress.setCompany_address_active(true);
			} else {
				crmCompanyAddress.setCompany_address_active(false);

			}
			crmCompanyAddress.setCompany_address_postcode(entries.get("company_address_postcode").toString());
			crmCompanyAddress.setId(Integer.parseInt(entries.get("id").toString()));
			companyAddresses.add(crmCompanyAddress);
		}
		return companyAddresses;
	}

}
