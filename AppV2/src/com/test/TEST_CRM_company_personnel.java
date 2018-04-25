package com.test;

import java.util.HashMap;
import java.util.Iterator;

import com.crm.client.company.CRM_company_personnel;

/**
 * A class desinged to test a functionality of CRM_company object
 * 
 * @author kbuczynski
 *
 */
public class TEST_CRM_company_personnel {

	private static HashMap<String, String> resultSet = new HashMap<String, String>();

	public static void main(String[] args) {

		// Test 1 use empty constructor
		// Expected Result: an empty class
		try {
			System.out.println("TEST 1: Create an Empty Object");
			CRM_company_personnel ccp1 = new CRM_company_personnel();
			System.out.println(ccp1.toString());
			resultSet.put("TEST_1", "PASS");
			System.out.println("\n");
		} catch (Exception e) {
			resultSet.put("TEST_1", "FAIL");
			resultSet.put("TEST_1_ERROR", e.getMessage());
		}

		// Test 2 populate a class with all the attribute
		// Expected Result: an object with all attribute populated
		try {
			System.out.println("TEST 2: Create an Object with all the attributes");
			CRM_company_personnel ccp2 = new CRM_company_personnel(1, 2, "Test Surname", "Test Forname", "Test Email",
					"Phone number 0000 This can be string becuase validation comes from front end",
					"Phone number prefix 0000 This can be string becuase validation comes from front end",
					"Test Position");
			System.out.println(ccp2);
			resultSet.put("TEST_2", "PASS");
			System.out.println("\n");
		} catch (Exception e) {
			resultSet.put("TEST_2", "FAIL");
			resultSet.put("TEST_2_ERROR", e.getMessage());
		}

		// Test 3 populate a class with some attributes
		// Expected Result : an object with some attributes populated
		try {
			System.out.println("Test 3: Create an Object with some attributes populated");
			CRM_company_personnel ccp3 = new CRM_company_personnel(99, "Test Surname", "Test forname", "Test Email",
					"Phone number 0000 This can be string becuase validation comes from front end",
					"Phone number prefix 0000 This can be string becuase validation comes from front end",
					"Test Position");
			System.out.println(ccp3.toString());
			resultSet.put("TEST_3", "PASS");
			System.out.println("\n");
		} catch (Exception e) {
			resultSet.put("TEST_3", "FAIL");
			resultSet.put("TEST_3_ERROR", e.getMessage());
		}

		// Test 4 populate a class with attributes using setters
		// Expected Result : an object with some attributes populated using setters
		try {
			System.out.println("Test 4: Create an Object with some attributes using setters methods");
			CRM_company_personnel ccp4 = new CRM_company_personnel();
			System.out.println(ccp4.toString());
			ccp4.setCompany_id(100);
			ccp4.setCompany_personnel_email("TEST EMAIL");
			ccp4.setCompany_personnel_surname("SURNAME");
			resultSet.put("TEST_4", "PASS");
			System.out.println("\n");
		} catch (Exception e) {
			resultSet.put("TEST_4", "FAIL");
			resultSet.put("TEST_4_ERROR", e.getMessage());
		}

		// Test 5 Print out an object values using getters
		// Expected Result : Printed object values
		try {
			System.out.println("Test 5: Print out object variables using getter methods");
			CRM_company_personnel ccp5 = new CRM_company_personnel();
			System.out.println(ccp5.toString());
			ccp5.setCompany_id(100);
			ccp5.setCompany_personnel_email("TEST EMAIL");
			ccp5.setCompany_personnel_surname("SURNAME");
			System.out.println("COMPANY ID: " + ccp5.getCompany_id());
			System.out.println("COMPANY PERSONNEL SURNAME: " + ccp5.getCompany_personnel_surname());
			System.out.println("COMPANY PERSONNEL FORNAME: " + ccp5.getCompany_personnel_forname());
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
