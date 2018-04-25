package com.test;

import java.util.HashMap;
import java.util.Iterator;

import com.crm.client.company.CRM_company_phoneNo;
import com.crm.client.user.CRM_user;
import com.crm.client.user.CRM_user_information;
import com.crm.client.user.CRM_user_master;

/**
 * A class designed to test a functionality of CRM_company object
 * 
 * @author kbuczynski
 *
 */
public class TEST_CRM_user_information {

	private static HashMap<String, String> resultSet = new HashMap<String, String>();

	public static void main(String[] args) {
		// Test 1: Create and print out empty object
		// Result: Creates and print out empty object

		try {
			CRM_user_information cui = new CRM_user_information();
			System.out.println(cui.toString());
			System.out.println("\n");
			resultSet.put("TEST 1", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 1", "FAIL");
			resultSet.put("TEST 1 Error", e.getMessage());
		}

		// Test 2: Create an object using a constructor
		// Result: Creates an object using a constructor
		try {
			CRM_user_information cui = new CRM_user_information(1, 1, "TEST SURNAME", "TEST FORNAME", "2018-01-01");
			System.out.println(cui.toString());
			System.out.println("\n");
			resultSet.put("TEST 2", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 2", "FAIL");
			resultSet.put("TEST 2 Error", e.getMessage());
		}

		// Test 3: Create an object using getters and setters
		// Result: Creates an object using getters and setters
		try {
			CRM_user_information cui = new CRM_user_information();
			cui.setId(1);
			cui.setUser_forname("TEST FORNAME");
			System.out.println("ID: " + cui.getId());
			System.out.println("FORNAME: " + cui.getUser_forname());
			System.out.println("\n");
			resultSet.put("TEST 3", "PASS");

		} catch (Exception e) {
			resultSet.put("TEST 3", "FAIL");
			resultSet.put("TEST 3 Error", e.getMessage());
		}

		// Test 4: Create an object and print out full name and surname together
		// Result: Creates an object and print out full name and surname together
		try {
			CRM_user_information cui = new CRM_user_information();
			cui.setUser_surname("TEST SURNAME");
			cui.setUser_forname("TEST FORNAME");
			System.out.println("FULLNAME: " + cui.getFullName());
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
