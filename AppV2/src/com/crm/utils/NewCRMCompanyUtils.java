package com.crm.utils;
import java.util.HashMap;
import java.util.Map.Entry;

import com.crm.client.company.CRM_company;
import com.crm.client.user.CRM_user;
import com.db.mysql.models.DBO_CRM_company;

public class NewCRMCompanyUtils {

	public static HashMap<String,String> createNewCRMCompany(HashMap<String, String> details, CRM_user crm_user) {
		HashMap<String, String> response = new HashMap<String, String>();
		for(Entry<String, String> str: details.entrySet()) {
			if(str.getValue() == null) {
				response.put("status", "MISSING");
				response.put("value_missing", str.getKey());
				return response;
			}
		}
		
		CRM_company cc = new CRM_company(crm_user.getUser_master_id(), details.get("companyName"));
		DBO_CRM_company dbo0 = new DBO_CRM_company();
		dbo0.createNewCrmCompany(cc);
		
		return null;
	}	
}
