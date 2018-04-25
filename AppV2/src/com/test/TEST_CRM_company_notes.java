package com.test;

import java.util.HashMap;
import java.util.Iterator;

import com.crm.client.company.CRM_company;
import com.crm.client.company.CRM_company_address;
import com.crm.client.company.CRM_company_notes;

/**
 * A class designed to test a functionality of CRM_company object
 * 
 * @author kbuczynski
 *
 */
public class TEST_CRM_company_notes {

	private static HashMap<String, String> resultSet = new HashMap<String, String>();

	public static void main(String[] args) {

		// Test 1: Create an empty object
		// Result: Creates an empty object
		try {
			System.out.println("Test 1: Create an empty object");
			CRM_company_notes ccn1 = new CRM_company_notes();
			System.out.println(ccn1.toString());
			System.out.println("\n");
			resultSet.put("TEST 1", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 1", "FAIL");
			resultSet.put("TEST 1 Error", e.getMessage());
		}

		// Test 2: Create object with some attributes using constructor
		// Result: Creates object with some attributes using constructor
		try {
			System.out.println("Test 2: Creates an object with some attributes using constructor");
			CRM_company_notes ccn2 = new CRM_company_notes(1, 1, "Test Title", "Test note", 1, "2017-01-01 12:12", 1,
					"TEST STATUS", "2017-01-02 12:12");
			System.out.println(ccn2.toString());
			System.out.println("\n");
			resultSet.put("TEST 2", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 2", "FAIL");
			resultSet.put("TEST 2 Error", e.getMessage());
		}

		// Test 3: Create object with some attributes using constructor
		// Result: Creates object with some attributes using constructor
		try {
			System.out.println("Test 3: Creates an object with some attributes using constructor");
			CRM_company_notes ccn3 = new CRM_company_notes(1, "Test Title", "Test Note", 1, "2017-01-01 00:00", 1,
					"Test Status", "2018-01-01 00:00");
			System.out.println(ccn3.toString());
			System.out.println("\n");
			resultSet.put("TEST 3", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 3", "FAIL");
			resultSet.put("TEST 3 Error", e.getMessage());
		}

		// Test 4: Create object with some attributes using constructor
		// Result: Creates object with some attributes using constructor
		try {
			System.out.println("Test 4: Creates an object with some attributes using constructor");
			CRM_company_notes ccn4 = new CRM_company_notes(1, "Test title", "Test note", 1, "2017-01-01 00:00");
			System.out.println(ccn4.toString());
			System.out.println("\n");
			resultSet.put("TEST 4", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 4", "FAIL");
			resultSet.put("TEST 4 Error", e.getMessage());
		}
		
		// Test 5: Create object and populate date attributes using fromString methods. It returns the values using fromString setters methods.
		// Result: Creates object and populate date attributes using fromString methods. It returns the values using fromString setters methods.
		try {
			System.out.println("Test 5: Creates an object and populate date attributes using fromString methods. It returns the values using fromString setters methods.");
			CRM_company_notes ccn5 = new CRM_company_notes();
			ccn5.setCompany_note_by_date_fromString("2017-01-01 00:00");
			ccn5.setCompany_note_duein_fromString("2017-01-01 00:00");
			System.out.println("COMPANY NOTE BY DATE FROM STRING: " + ccn5.getCompany_note_by_dateToString());
			System.out.println("COMPANY NOTE DUEIN FROM STRING: " + ccn5.getCompany_note_dueinToStringToFrom());
			System.out.println("\n");
			resultSet.put("TEST 5", "PASS");
		} catch(Exception e) {
			resultSet.put("TEST 5", "FAIL");
			resultSet.put("TEST 5 Error", e.getMessage());
		}
		
		// Test 6: Create object and populate note. Return first 10 characters and whole note string
		// Result: Creates object and populate note. Return first 10 characters and whole note string
		try {
			System.out.println("Test 6: Create object and populate note. Return first 10 characters and whole note string");
			CRM_company_notes ccn6 = new CRM_company_notes();
			ccn6.setCompany_note("TEST NOTE OVER 10 CHARACTERS NOTE");
			System.out.println("CRM COMPANY NOTE WHOLE: " + ccn6.getCompany_note(0));
			System.out.println("COMPANY NOTE FIRST 10 CHARACTERS: " + ccn6.getCompany_note(10) + " Number of char: " + (ccn6.getCompany_note(10).length() - 3)); // number of character - 3 to remove "..." string from a finnal count
	
			System.out.println("\n");
			resultSet.put("TEST 6", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 6", "FAIL");
			resultSet.put("TEST 6 Error", e.getMessage());
		}
		
		// Test 7: Create object and populate a note from string. Convert note to string suitable for form using toForm Method.		// Test 7: Create object and populate a note from string. Convert note to string suitable for form using toForm Method.
		// Result: Creates object and populate a note from string. Convert note to string suitable for form using toForm Method.		// Test 7: Create object and populate a note from string. Convert note to string suitable for form using toForm Method.
		try {
			System.out.println("Test 7: Create object and populate a note from string. Convert note to string suitable for form using toForm Method.		// Test 7: Create object and populate a note from string. Convert note to string suitable for form using toForm Method.");
			CRM_company_notes ccn7 = new CRM_company_notes();
			ccn7.setCompany_note_duein_fromString("2018-01-10 00:00");
			System.out.println("FORM STRING COMPANY NOTE BY DATE: " + ccn7.getCompany_note_dueinToStringToFrom());
			System.out.println("\n");
			resultSet.put("TEST 7", "PASS");
		} catch (Exception e) {
			resultSet.put("TEST 7", "FAIL");
			resultSet.put("TEST 7 Error", e.getMessage());
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
