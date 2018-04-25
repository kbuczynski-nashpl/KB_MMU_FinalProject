package com.test;

import java.util.HashMap;
import java.util.Iterator;

import com.crm.client.company.CRM_company_email_address;

public class TEST_CRM_company_email_address {

	private static HashMap<String, String> resultSet = new HashMap<String, String>();

	public static void main(String[] args) {

		// Test 1: Create an empty object
		// Result: Creates and prints an empty object
		try {
			System.out.println("TEST 1: Create an empty object");
			CRM_company_email_address ccea1 = new CRM_company_email_address();
			System.out.println(ccea1.toString());
			System.out.println("\n");
			resultSet.put("TEST 1", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 1", "FAIL");
			resultSet.put("TEST 1 Error", e.getMessage());
		}

		// Test 2: Create an object and populate all attributes using constructor
		// Result: Creates an object and populate all attributes using constructor
		try {
			System.out.println("TEST 2: Create an object and populate all attributes");
			CRM_company_email_address ccea2 = new CRM_company_email_address(1, 2, "Test String", "Test String");
			System.out.println(ccea2.toString());
			System.out.println("\n");
			resultSet.put("TEST 2", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 2", "FAIL");
			resultSet.put("TEST 2 Error", e.getMessage());
		}

		// Test 3: Create an object and populate some attributes using constructor
		// Result: Creates an object and populates some attributes using constructor
		try {
			System.out.println("TEST 3: Create an object and populate some attributes using constructor");
			CRM_company_email_address ccea3 = new CRM_company_email_address(2, "Test String", "Test String");
			System.out.println(ccea3.toString());
			System.out.println("\n");
			resultSet.put("TEST 3", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 3", "FAIL");
			resultSet.put("TEST 3 Error", e.getMessage());
		}

		// Test 4: Create an object and populate values using setters
		// Result: Creates an object and populates values using setters
		try {
			System.out.println("Test 4: Create an object and popluate values using setters");
			CRM_company_email_address ccea4 = new CRM_company_email_address();
			ccea4.setCompany_email_active(true);
			ccea4.setCompany_email_type("TEST STRING");
			System.out.println(ccea4.toString());
			System.out.println("\n");
			resultSet.put("TEST 4", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 4", "FAIL");
			resultSet.put("TEST 4 Error", e.getMessage());
		}

		// Test 5: Create an object with values and print out values using getters
		// Result: Creats an object with values and print out values using getters
		try {
			System.out.println("Test 5: Creat an object with values and print out values using getters");
			CRM_company_email_address ccea5 = new CRM_company_email_address(4, "Test String", "Test String2");
			System.out.println("COMPANY EMAIL ADDRESS: " + ccea5.getCompany_email_address());
			System.out.println("COMPANY EMAIL ADDRESS TYPE: " + ccea5.getCompany_email_type());
			System.out.println("\n");
			resultSet.put("TEST 5", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 5", "FAIL");
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
