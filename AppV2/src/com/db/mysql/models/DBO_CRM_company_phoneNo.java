/**
 * 
 */
package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company_phoneNo;
import com.db.mysql.MySQL;

/**
 * @author kbuczynski
 *
 */
public class DBO_CRM_company_phoneNo extends MySQL{
	public DBO_CRM_company_phoneNo(){
		super();
	}
	
	public ArrayList<CRM_company_phoneNo> getByCompanyId(int id){
		String queryString = "SELECT * from CRM_company_phoneNo where company_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_phoneNo> companyPhones = new ArrayList<CRM_company_phoneNo>();
		for(HashMap<String, String> entries : resultFromMysql) {
			CRM_company_phoneNo companyPhoneNumber = new CRM_company_phoneNo();
			companyPhoneNumber.setId(Integer.parseInt(entries.get("id").toString()));
			companyPhoneNumber.setCompany_id(Integer.parseInt(entries.get("company_id").toString()));
			companyPhoneNumber.setCompany_phoneNo(entries.get("company_phoneNo").toString());
			companyPhoneNumber.setCompany_phoneNo_prefix(entries.get("company_phoneNo_prefix").toString());
			companyPhones.add(companyPhoneNumber);
		}
		return companyPhones;
	}
}
