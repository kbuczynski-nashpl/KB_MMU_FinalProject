package com.test;

import java.util.HashMap;
import java.util.Iterator;

import com.crm.client.company.CRM_company;
import com.crm.client.company.CRM_company_address;

/**
 * A class desinged to test a functionality of CRM_company object
 * 
 * @author kbuczynski
 *
 */
public class TEST_CRM_company_address {

	private static HashMap<String, String> resultSet = new HashMap<String, String>();

	public static void main(String[] args) {

		// Test 1: Create an empty Object
		// Expected Result: empty Object
		try {
			System.out.println("TEST 1: Create Empty Object");
			CRM_company_address cca1 = new CRM_company_address();
			System.out.println(cca1);
			resultSet.put("TEST_1", "PASS");
			System.out.println("\n");

		} catch (Exception e) {
			resultSet.put("TEST_1", "FAIL");
			resultSet.put("TEST_1_ERROR", e.getMessage());
		}

		// Test 2: Create a full Object
		// Expected Result: full Object
		try {
			System.out.println("TEST 2: Create full Object");
			CRM_company_address cca1 = new CRM_company_address(1, "Line1", "MMA", "MANCHESTER", "ALBANIA", true);
			cca1.setId(99);
			cca1.setCompany_address_line2("Line2");

			System.out.println(cca1);
			resultSet.put("TEST_2", "PASS");
			System.out.println("\n");

		} catch (Exception e) {
			resultSet.put("TEST_2", "FAIL");
			resultSet.put("TEST_2_ERROR", e.getMessage());
		}
		
		// Test 3: Create a Object using some attributes
		// Expected Result: Object with some attributes
		try {
			System.out.println("TEST 3: Create Object using some attributes");
			CRM_company_address cca1 = new CRM_company_address(1, "Line1", "MMA", "MANCHESTER", "ALBANIA", true);
			System.out.println(cca1);
			resultSet.put("TEST_3", "PASS");
			System.out.println("\n");

		} catch (Exception e) {
			resultSet.put("TEST_3", "FAIL");
			resultSet.put("TEST_3_ERROR", e.getMessage());
		}
		
		// Test 4: Create a Object using setters
		// Expected Result: Object with some attributes
		try {
			System.out.println("TEST 4: Create Object using setters");
			CRM_company_address cca1 = new CRM_company_address();
			cca1.setId(99);
			cca1.setCompany_address_line2("Line2");
			System.out.println(cca1);
			resultSet.put("TEST_4", "PASS");
			System.out.println("\n");

		} catch (Exception e) {
			resultSet.put("TEST_4", "FAIL");
			resultSet.put("TEST_4_ERROR", e.getMessage());
		}
		
		// Test 5: Print out object variable using getters
		// Expected Result: Print out of object variables
		try {
			System.out.println("TEST 5: Print out object variables using getters");
			CRM_company_address cca1 = new CRM_company_address(1, "Line1", "MMA", "MANCHESTER", "ALBANIA", true);
			System.out.println("COMPANY ADDRESS CITY: " + cca1.getCompany_address_city());
			System.out.println("COMPANY ADDRESS LINE 2: " + cca1.getCompany_address_line2());
			resultSet.put("TEST_5", "PASS");
			System.out.println("\n");

		} catch (Exception e) {
			resultSet.put("TEST_5", "FAIL");
			resultSet.put("TEST_5_ERROR", e.getMessage());
		}

		System.out.println("\n\n");
		printResultSet();
	}

	private static void printResultSet() {
		Iterator<?> it = resultSet.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			HashMap.Entry pair = (HashMap.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}

	}
}
