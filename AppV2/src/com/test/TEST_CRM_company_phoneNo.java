package com.test;

import java.util.HashMap;
import java.util.Iterator;

import com.crm.client.company.CRM_company_phoneNo;

/**
 * A class desinged to test a functionality of CRM_company object
 * 
 * @author kbuczynski
 *
 */
public class TEST_CRM_company_phoneNo {

	private static HashMap<String, String> resultSet = new HashMap<String, String>();

	public static void main(String[] args) {

		// Test 1 : Create empty object
		// Result : Creates empty object
		try {
			System.out.println("Test 1: Create an empty Object");
			CRM_company_phoneNo ccp = new CRM_company_phoneNo();
			System.out.println(ccp);
			System.out.println("\n");

			resultSet.put("TEST 1", "PASS");

		} catch (Exception e) {
			resultSet.put("TEST 1", "FAIL");
			resultSet.put("TEST 1 Error", e.getMessage());
		}

		// Test 2 : Create object using constructor and populate all information
		// Result : Creates object using constructor and populate all information
		try {
			System.out.println("Test 2: Create an Object using constructor and popluate all information");
			CRM_company_phoneNo ccp = new CRM_company_phoneNo(1, 1, "000 CAN CONTAIN NONE NUMBERS", "PREFIX");
			System.out.println(ccp);
			System.out.println("\n");

			resultSet.put("TEST 2", "PASS");

		} catch (Exception e) {
			resultSet.put("TEST 2", "FAIL");
			resultSet.put("TEST 2 Error", e.getMessage());
		}

		// Test 3 : Create object using constructor and populate some attributes
		// Result : Creates object using constructor and populate some attributes
		try {
			System.out.println("Test 3: Create an Object using constructor and popluate some information");
			CRM_company_phoneNo ccp = new CRM_company_phoneNo(1, "000 CAN CONTAIN NONE NUMBERS", "PREFIX");
			System.out.println(ccp);
			System.out.println("\n");

			resultSet.put("TEST 3", "PASS");

		} catch (Exception e) {
			resultSet.put("TEST 3", "FAIL");
			resultSet.put("TEST 3 Error", e.getMessage());
		}

		// Test 4 : Create object and populate information using setters, print out information using getters
		// Result : Creates object and populate information using setters, print out information using getters
		try {
			System.out.println("Test 4: object and populate information using setters, print out information using getters");
			CRM_company_phoneNo ccp = new CRM_company_phoneNo();
			ccp.setCompany_id(1);
			ccp.setCompany_phoneNo("123");
			System.out.println("COMPANY ID: " + ccp.getCompany_id());
			System.out.println("COMPANY PHONE NO: " + ccp.getCompany_phoneNo());
			System.out.println("\n");

			resultSet.put("TEST 4", "PASS");

		} catch (Exception e) {
			resultSet.put("TEST 4", "FAIL");
			resultSet.put("TEST 4 Error", e.getMessage());
		}

		System.out.println("\n");
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
