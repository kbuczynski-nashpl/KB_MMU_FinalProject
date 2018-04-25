package com.test;

import java.util.HashMap;
import java.util.Iterator;

import com.crm.client.company.CRM_company_phoneNo;
import com.crm.client.user.CRM_user;

/**
 * A class designed to test a functionality of CRM_company object
 * 
 * @author kbuczynski
 *
 */
public class TEST_CRM_user {

	private static HashMap<String, String> resultSet = new HashMap<String, String>();

	public static void main(String[] args) {
		// Test 1: Create and  print out empty object
		// Result: Creates and print out empty object
		
		try {
			CRM_user cu = new CRM_user();
			System.out.println(cu.toString());
			System.out.println("\n");
			resultSet.put("TEST 1", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 1", "FAIL");
			resultSet.put("TEST 1 Error", e.getMessage());
		}
		
		// Test 2: Create an object using a constructor
		// Result: Creates an object using a constructor
		try {
			CRM_user cu = new CRM_user(1, 1, "TEST USR", "TEST PSW", "EMAIL@EMAIL.COM");
			System.out.println(cu.toString());
			System.out.println("\n");
			resultSet.put("TEST 2", "PASS");
		}
		catch(Exception e) {
			resultSet.put("TEST 2", "FAIL");
			resultSet.put("TEST 2 Error", e.getMessage());
		}
		
		
		// Test 3: Create an object using getters and setters
		// Result: Creates an object using getters and setters
		try {
			CRM_user cu = new CRM_user();
			cu.setId(1);
			cu.setUser_email("email@email.com");
			System.out.println("ID: " + cu.getId());
			System.out.println("EMAIL: " + cu.getUser_email());
			System.out.println("\n");
			resultSet.put("TEST 3", "PASS");
			
		} catch(Exception e) {
			resultSet.put("TEST 3", "FAIL");
			resultSet.put("TEST 3 Error", e.getMessage());
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
