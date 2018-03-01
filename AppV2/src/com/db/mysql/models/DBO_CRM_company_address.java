package com.db.mysql.models;

import java.util.ArrayList;
import java.util.HashMap;
import com.crm.client.company.CRM_company_address;
import com.db.mysql.MySQL;
import com.mysql.jdbc.StringUtils;

public class DBO_CRM_company_address extends MySQL {
	public DBO_CRM_company_address() {
		super();
	}

	public ArrayList<CRM_company_address> getByCompanyId(int id) {
		String queryString = "SELECT * from CRM_company_address where company_id =" + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_address> companyAddresses = new ArrayList<CRM_company_address>();
		for (HashMap<String, String> entries : resultFromMysql) {
			CRM_company_address crmCompanyAddress = new CRM_company_address(
					Integer.parseInt(entries.get("company_id").toString()),
					entries.get("company_address_line1").toString(), entries.get("company_address_postcode").toString(),
					entries.get("company_address_city").toString(), entries.get("company_address_country").toString(),
					false);
			if (!StringUtils.isNullOrEmpty(entries.get("company_address_line2"))) {
				crmCompanyAddress.setCompany_address_line2(entries.get("company_address_line2").toString());
			}
			if (entries.get("company_address_active").toString().equals("1")) {
				crmCompanyAddress.setCompany_address_active(true);
			} else {
				crmCompanyAddress.setCompany_address_active(false);

			}
			crmCompanyAddress.setId(Integer.parseInt(entries.get("id").toString()));
			companyAddresses.add(crmCompanyAddress);
		}
		return companyAddresses;
	}

	public HashMap<String, String> createNewCrmCompanyAddress(CRM_company_address cca) {
		String queryString = "";
		int activeValue = 0;
		if(cca.getCompany_address_active() == true) {
			activeValue = 1;
		} else {
			activeValue = 0;
		}
		
		if (cca.getCompany_address_line2() != null) {
			queryString = "INSERT INTO CRM_company_address (company_id, company_address_line1, company_address_line2, company_address_postcode, company_address_city, company_address_country, company_address_active) VALUES ("
					+ cca.getCompany_id() + ", '" + cca.getCompany_address_line1() + "', '"
					+ cca.getCompany_address_line2() + "', '" + cca.getCompany_address_postcode() + "', '"
					+ cca.getCompany_address_city() + "', '" + cca.getCompany_address_country() + "', '"
					+ activeValue + "')";
		} else {
			queryString = "INSERT INTO CRM_company_address (company_id, company_address_line1, company_address_postcode, company_address_city, company_address_country, company_address_active) VALUES ("
					+ cca.getCompany_id() + ", '" + cca.getCompany_address_line1() + ", '"
					+ cca.getCompany_address_postcode() + "', '" + cca.getCompany_address_city() + "', '"
					+ cca.getCompany_address_country() + "', '" + activeValue + "')";
		}
		HashMap<String, String> response = update(queryString);
		return response;
	}
	
	public HashMap<String, String> removeByCompanyId(Integer id){
		String queryString = "DELETE FROM CRM_company_address where company_id = " + id;
		HashMap<String, String> result = update(queryString);
		return result;
	}

}
