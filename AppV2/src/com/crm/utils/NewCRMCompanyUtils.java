package com.crm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.crm.client.company.CRM_company;
import com.crm.client.company.CRM_company_address;
import com.crm.client.company.CRM_company_email_address;
import com.crm.client.company.CRM_company_phoneNo;
import com.crm.client.user.CRM_user;
import com.db.mysql.models.DBO_CRM_company;
import com.db.mysql.models.DBO_CRM_company_address;
import com.db.mysql.models.DBO_CRM_company_email_address;
import com.db.mysql.models.DBO_CRM_company_phoneNo;

/**
 * NewCRMCompanyUtils is a class which focuses on creating new entry in Database
 * system when user wants to add new CRM company into a system. It validates all
 * the values and clean up database in case something goes wrong or value gets
 * missing
 * 
 * @author kbuczynski
 * @version 1.0
 */
public class NewCRMCompanyUtils {

	private static HashMap<String, String> response = new HashMap<String, String>();
	private static HashMap<String, String> objectStatus = new HashMap<String, String>();

	/**
	 * A main function of this class. It was designed to create objects and database
	 * entries when user adds new company into the system
	 * 
	 * @param details
	 * @param crm_user
	 * @return HashMap with response messages which will get display on JSP page
	 */
	public static HashMap<String, String> createNewCRMCompany(HashMap<String, String> details, CRM_user crm_user) {

		CRM_company cc = new CRM_company(crm_user.getUser_master_id(), details.get("companyName"));
		try {
			objectStatus = validateObject(cc, "getId");
			if (checkObjectStatus() == true) {
				return response;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		// CREATING THE CRM_company entry in Database
		response = DBO_CRM_company.createNewCrmCompany(cc);
		cc.setId(Integer.parseInt(response.get("GEN_ID").toString()));

		// CREATING CRM_company_address entry as a object
		CRM_company_address cca = new CRM_company_address(cc.getId(), details.get("companyAddressLine1"),
				details.get("companyAddressPostcode"), details.get("companyAddressCity"),
				details.get("companyAddressCountry"), true);
		try {
			objectStatus = validateObject(cca, "getCompany_address_line2");
			if (checkObjectStatus() == true) {
				cleanUpDatabase(cca.getCompany_id());
				return response;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		if (details.get("companyAddressLine2") != null) {
			cca.setCompany_address_line2(details.get("companyAddressLine2"));
		}

		// Creating a CRM_company_email_address entry as a object
		CRM_company_email_address ccea = new CRM_company_email_address(cc.getId(), details.get("companyEmailAddress"),
				details.get("companyEmailType"));
		try {
			objectStatus = validateObject(ccea, "NULL");
			if (checkObjectStatus() == true) {
				cleanUpDatabase(ccea.getCompany_id());
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

		// Creating CRM_company_phoneNo entry as a object
		CRM_company_phoneNo ccpn = new CRM_company_phoneNo(cc.getId(), details.get("companyPhoneNumber"),
				details.get("companyPhoneNoPrefix"));
		try {
			objectStatus = validateObject(ccpn, "NULL");
			if (checkObjectStatus() == true) {
				cleanUpDatabase(ccpn.getCompany_id());
				return response;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		// Create CRM_company_address entry in Database
		response = DBO_CRM_company_address.createNewCrmCompanyAddress(cca);
		if (response.get("STATUS").equals("ERROR")) {
			return response;
		}

		// Create CRM_company_email_address entry in Database
		response = DBO_CRM_company_email_address.createNewCRMEmailAddress(ccea);
		if (response.get("STATUS").equals("ERROR")) {
			return response;
		}

		// Create CRM_company_phoneNo entry in Database
		response = DBO_CRM_company_phoneNo.createNewCrmCompanyPhoneNo(ccpn);
		if (response.get("STATUS").equals("ERROR")) {
			return response;
		}

		response.put("cc-name", cc.getCompany_name());
		response.put("cc-id", cc.getId().toString());

		return response;
	}

	private static Boolean checkObjectStatus() {
		if (objectStatus.get("STATUS").equals("ERROR")) {
			response.put("VALUE_MISSING", objectStatus.get("VALUE"));
			return true;
		}

		return false;
	}

	private static HashMap<String, String> validateObject(Object objectVariable, String skipMethod)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> classObject = objectVariable.getClass();
		Method[] allClassMethods = classObject.getMethods();
		for (Method mt : allClassMethods) {
			if (mt.getName().startsWith("get") && !mt.getName().equals(skipMethod)) {
				String result = mt.invoke(objectVariable).toString();
				if (result == null || result.equals("")) {
					response.put("STATUS", "ERROR");
					response.put("MSG", "NULL VALUE");
					response.put("VALUE", mt.getName().replace("get", "").replace('_', ' '));
					return response;
				} else {
					response.put("STATUS", "OK");
				}
			}
		}
		return response;
	}

	private static void cleanUpDatabase(Integer companyId) {
		if (DBO_CRM_company.getById(companyId, null).getCompany_name() != null) {
			DBO_CRM_company.removeById(companyId);
		}
		if (DBO_CRM_company_address.getByCompanyId(companyId).isEmpty() != true) {
			DBO_CRM_company_address.removeByCompanyId(companyId);
		}
		if (DBO_CRM_company_email_address.getByCompanyId(companyId).isEmpty() != true) {
			DBO_CRM_company_email_address.removeByCompanyId(companyId);
		}
		if (DBO_CRM_company_phoneNo.getByCompanyId(companyId).isEmpty() != true) {
			DBO_CRM_company_phoneNo.removeByCompanyId(companyId);
		}
	}
}
