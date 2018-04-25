package com.test;

import java.util.HashMap;
import java.util.Iterator;

import com.crm.client.company.CRM_company;

/**
 * A class desinged to test a functionality of CRM_company object
 * 
 * @author kbuczynski
 *
 */
public class TEST_CRM_company {

	private static HashMap<String, String> resultSet = new HashMap<String, String>();

	public static void main(String[] args) {

		// Test 1 use empty constructor
		// Expected Result: an empty class
		try {
			System.out.println("TEST 1: Create an Empty Object");
			CRM_company cc1 = new CRM_company();
			System.out.println(cc1.toString());
			resultSet.put("TEST_1", "PASS");
			System.out.println("\n");
		} catch (Exception e) {
			resultSet.put("TEST_1", "FAIL");
			resultSet.put("TEST_1_ERROR", e.getMessage());
		}

		// Test 2 Create an object using populating all attributes
		// Expected Result: a class with expected data
		try {
			System.out.println("TEST 2: Create an Object with test data");
			CRM_company cc2 = new CRM_company(1, 1, "Test Company Name");
			System.out.println(cc2.toString());
			resultSet.put("TEST_2", "PASS");
			System.out.println("\n");

		} catch (Exception e) {
			resultSet.put("TEST_2", "FAIL");
			resultSet.put("TEST_2_ERROR", e.getMessage());
		}

		// Test 3 Create an object using populating some attributes
		// Expected Result: a class with expected data
		try {
			System.out.println("TEST 3: Create an Object with some test data");
			CRM_company cc3 = new CRM_company(1, "Test Company Name");
			System.out.println(cc3.toString());
			resultSet.put("TEST_3", "PASS");
			System.out.println("\n");
		} catch (Exception e) {
			resultSet.put("TEST_3", "FAIL");
			resultSet.put("TEST_3_ERROR", e.getMessage());
		}

		// Test 4 Create an object using setters method
		// Expected Result: a class with expected data
		try {
			System.out.println("TEST 4: Create an Object with test data using setters");
			CRM_company cc4 = new CRM_company();
			cc4.setId(1);
			cc4.setCRM_user_master_id(2);
			cc4.setCompany_name("Test name from setters");
			System.out.println(cc4.toString());
			resultSet.put("TEST_4", "PASS");
			System.out.println("\n");

		} catch (Exception e) {
			resultSet.put("TEST_4", "FAIL");
			resultSet.put("TEST_4_ERROR", e.getMessage());
		}

		// Test 5 Get Object data using getters
		// Expected Result: a class with expected data
		try {
			System.out.println("TEST 5: Create an Object with test data and get values using getters");
			CRM_company cc5 = new CRM_company(2,3, "Test number 5");
			System.out.println(cc5.toString());
			System.out.println("COMPANY NAME: " + cc5.getCompany_name());
			System.out.println("COMPANY USER MASTER ID: " + cc5.getCRM_user_master_id());
			System.out.println("OBJECT ID: " + cc5.getId());
			
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
