package com.crm.client.user;

import java.lang.reflect.Field;

/**
 * CRM_user_master. Class witch holds a master record details for a user and company
 * @author kbuczynski
 *
 */
public class CRM_user_master {

	private Integer id = 0;
	private String user_company_name = "";

	public CRM_user_master() {
	}

	/**
	 * Constructor, creates variables from arguments
	 * @param id Integer holds id number of a company
	 * @param userCompanyName String holds company name
	 */
	public CRM_user_master(Integer id, String userCompanyName) {
		this.id = id;
		this.user_company_name = userCompanyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_company_name() {
		return user_company_name;
	}

	public void setUser_company_name(String user_company_name) {
		this.user_company_name = user_company_name;
	}

	@Override
	/**
	 * A toString method which overwrites the build in function
	 * 
	 * @return String with a class variables and values
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		Field[] fields = this.getClass().getDeclaredFields();
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				result.append(field.getName() + ": " + field.get(this) + " ");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		result.append("}");

		return result.toString();
	}

}