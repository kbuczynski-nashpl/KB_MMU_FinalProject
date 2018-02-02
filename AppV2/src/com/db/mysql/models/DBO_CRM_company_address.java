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
			crmCompanyAddress.setCompanyAddressCity(entries.get("company_address_city").toString());
			crmCompanyAddress.setCompanyAddressCountry(entries.get("company_address_country").toString());
			crmCompanyAddress.setCompanyAddressLine1(entries.get("company_address_line1").toString());
			if(!StringUtils.isNullOrEmpty(entries.get("company_address_line2"))) {
				crmCompanyAddress.setCompanyAddressLine2(entries.get("company_address_line2").toString());
			}
			crmCompanyAddress.setCompanyAddressPostCode(entries.get("company_address_postcode").toString());
			crmCompanyAddress.setId(Integer.parseInt(entries.get("id").toString()));
			companyAddresses.add(crmCompanyAddress);
		}
		return companyAddresses;
	}

}
