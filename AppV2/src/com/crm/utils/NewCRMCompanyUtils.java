package com.crm.utils;
import java.util.HashMap;
import java.util.Map.Entry;

import com.crm.client.company.CRM_company;
import com.crm.client.company.CRM_company_address;
import com.crm.client.company.CRM_company_email_address;
import com.crm.client.user.CRM_user;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;

public class NewCRMCompanyUtils {

	public static HashMap<String,String> createNewCRMCompany(HashMap<String, String> details, CRM_user crm_user) {
		HashMap<String, String> response = new HashMap<String, String>();
		for(Entry<String, String> str: details.entrySet()) {
			if(str.getValue() == null && !str.getKey().equals("companyAddressLine2")) {
				response.put("status", "MISSING");
				response.put("value_missing", str.getKey());
				return response;
			}
		}
		
		CRM_company cc = new CRM_company(crm_user.getUser_master_id(), details.get("companyName"));
		DBO_CRM_company dbo0 = new DBO_CRM_company();
		dbo0.createNewCrmCompany(cc);
		
		CRM_company_address cca = new CRM_company_address(crm_user.getUser_master_id(), details.get("companyAddressLine1"), details.get("companyAddressPostcode"), details.get("companyAddressCity"), details.get("companyAddressCountry"), true);
		if(details.get("companyAddressLine2") != null) {
			cca.setCompany_address_line2(details.get("companyAddressLine2"));
		}
		
		DBO_CRM_company_address dbo1 = new DBO_CRM_company_address();
		dbo1.createNewCrmCompanyAddress(cca);
		
		CRM_company_email_address ccea = new CRM_company_email_address(crm_user.getUser_master_id(), details.get("emailaddress"), details.get("emailtype"));
		if(details.get("").equals("true")) {
			ccea.setCompany_email_active(true);
		}else {
			ccea.setCompany_email_active(false);
		}
		DBO_CRM_company_email_address dbo2 = new DBO_CRM_company_email_address();
		dbo2.createNewCRMEmailAddress(ccea);
		
		
		return null;
	}	
}
