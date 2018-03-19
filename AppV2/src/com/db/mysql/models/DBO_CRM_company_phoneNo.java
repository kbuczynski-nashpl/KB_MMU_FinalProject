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
public class DBO_CRM_company_phoneNo extends MySQL {
	public DBO_CRM_company_phoneNo() {
		super();
	}

	public ArrayList<CRM_company_phoneNo> getByCompanyId(int id) {
		String queryString = "SELECT * from CRM_company_phoneNo where company_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_phoneNo> companyPhones = new ArrayList<CRM_company_phoneNo>();
		for (HashMap<String, String> entries : resultFromMysql) {
			CRM_company_phoneNo companyPhoneNumber = new CRM_company_phoneNo(
					Integer.parseInt(entries.get("company_id").toString()), entries.get("company_phoneNo").toString(),
					entries.get("company_phoneNo_prefix").toString());
			companyPhoneNumber.setId(Integer.parseInt(entries.get("id").toString()));
			companyPhones.add(companyPhoneNumber);
		}
		return companyPhones;
	}

	public HashMap<String, String> createNewCrmCompanyPhoneNo(CRM_company_phoneNo ccpn) {
		String queryString = "INSERT INTO CRM_company_phoneNo (company_id, company_phoneNo, company_phoneNo_prefix) VALUES ("
				+ ccpn.getCompany_id() + ",'" + ccpn.getCompany_phoneNo() + "','" + ccpn.getCompany_phoneNo_prefix()
				+ "')";
		HashMap<String, String> response = update(queryString);
		return response;
	}

	public HashMap<String, String> removeByCompanyId(Integer id) {
		String queryString = "DELETE FROM CRM_company_phoneNo where company_id = " + id;
		HashMap<String, String> result = update(queryString);
		return result;
	}

}
