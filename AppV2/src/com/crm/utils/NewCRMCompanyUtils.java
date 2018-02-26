package com.crm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

import com.crm.client.company.CRM_company;
import com.crm.client.company.CRM_company_address;
import com.crm.client.company.CRM_company_email_address;
import com.crm.client.company.CRM_company_phoneNo;
import com.crm.client.user.CRM_user;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_phoneNo;

public class NewCRMCompanyUtils {

	public static HashMap<String, String> createNewCRMCompany(HashMap<String, String> details, CRM_user crm_user) {
		HashMap<String, String> response = new HashMap<String, String>();
		HashMap<String, String> objectStatus = new HashMap<String, String>();
		for (Entry<String, String> str : details.entrySet()) {
			if (str.getValue() == null && !str.getKey().equals("companyAddressLine2")) {
				response.put("STATUS", "MISSING");
				response.put("VALUE_MISSING", str.getKey());
				return response;
			}
		}

		DBO_CRM_company dbo0 = new DBO_CRM_company();
		DBO_CRM_company_address dbo1 = new DBO_CRM_company_address();
		DBO_CRM_company_email_address dbo2 = new DBO_CRM_company_email_address();
		DBO_CRM_company_phoneNo dbo3 = new DBO_CRM_company_phoneNo();

		CRM_company cc = new CRM_company(crm_user.getUser_master_id(), details.get("companyName"));
		try {
			objectStatus = validateObject(cc, "NULL");
			if (objectStatus.get("STATUS").equals("ERROR")) {
				response.put("VALUE_MISSING", objectStatus.get("VALUE"));
				return response;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		response = dbo0.createNewCrmCompany(cc);

		CRM_company_address cca = new CRM_company_address(Integer.parseInt(response.get("GEN_ID")),
				details.get("companyAddressLine1"), details.get("companyAddressPostcode"),
				details.get("companyAddressCity"), details.get("companyAddressCountry"), true);
		try {
			objectStatus = validateObject(cca, "NULL");
			if (objectStatus.get("STATUS").equals("ERROR")) {
				response.put("VALUE_MISSING", objectStatus.get("VALUE"));
				return response;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		if (details.get("companyAddressLine2") != null) {
			cca.setCompany_address_line2(details.get("companyAddressLine2"));
		}

		CRM_company_email_address ccea = new CRM_company_email_address(Integer.parseInt(response.get("GEN_ID")),
				details.get("companyEmailAddress"), details.get("companyEmailType"));
		try {
			objectStatus = validateObject(ccea, "NULL");
			if (objectStatus.get("STATUS").equals("ERROR")) {
				response.put("VALUE_MISSING", objectStatus.get("VALUE"));
				return response;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		if (details.get("companyEmailActive").equals("on")) {
			ccea.setCompany_email_active(true);
		} else {
			ccea.setCompany_email_active(false);
		}

		CRM_company_phoneNo ccpn = new CRM_company_phoneNo(Integer.parseInt(response.get("GEN_ID")),
				details.get("companyPhoneNumber"), details.get("companyPhoneNoPrefix"));
		try {
			objectStatus = validateObject(ccpn, "NULL");
			if (objectStatus.get("STATUS").equals("ERROR")) {
				response.put("VALUE_MISSING", objectStatus.get("VALUE"));
				dbo0.removeById(Integer.parseInt(response.get("GEN_ID").toString()));
				return response;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		response = dbo1.createNewCrmCompanyAddress(cca);
		response = dbo2.createNewCRMEmailAddress(ccea);
		response = dbo3.createNewCrmCompanyPhoneNo(ccpn);

		if (response.get("STATUS").equals("ERROR")) {
			return response;
		}
		response.put("cc-name", cc.getCompany_name());

		return response;
	}

	private static HashMap<String, String> validateObject(Object objectVariable, String skipMethod)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> classObject = objectVariable.getClass();
		Method[] allClassMethods = classObject.getMethods();
		HashMap<String, String> respond = new HashMap<String, String>();
		for (Method mt : allClassMethods) {
			if (mt.getName().startsWith("get") && !mt.getName().equals(skipMethod)) {
				String result = mt.invoke(objectVariable).toString();
				if (result == null) {
					respond.put("STATUS", "ERROR");
					respond.put("MSG", "NULL VALUE");
					respond.put("VALUE", mt.toString());
					return respond;
				} else {
					respond.put("STATUS", "OK");
				}
			}
		}
		return respond;
	}
}
