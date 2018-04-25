package com.crm.client.company;

import java.lang.reflect.Field;

/**
 * CRM_company_phone class
 * 
 * A object which stores a phone number details.
 * 
 * @author kbuczynski
 *
 */
public class CRM_company_phoneNo {
	private Integer id = 0;
	private Integer company_id;
	private String company_phoneNo;
	private String company_phoneNo_prefix;

	public CRM_company_phoneNo() {
	}

	/**
	 * A constructor which accepts attributes and populate.
	 * 
	 * @param companyId
	 *            Integer which holds a unique id of company. Relates to master
	 *            table record.
	 * @param companyPhoneNo
	 *            String holding a phone number.
	 * @param companyPhoneNoPrefix
	 *            String holds a phone prefix number.
	 */
	public CRM_company_phoneNo(Integer companyId, String companyPhoneNo, String companyPhoneNoPrefix) {
		this.company_id = new Integer(companyId);
		this.company_phoneNo = new String(companyPhoneNo);
		this.company_phoneNo_prefix = new String(companyPhoneNoPrefix);
	}

	/**
	 * A constructor which accepts attributes and populate.
	 * 
	 * @param id
	 *            Integer holds a object id number
	 * @param companyId
	 *            Integer which holds a unique id of company. Relates to master
	 *            table record.
	 * @param companyPhoneNo
	 *            String holding a phone number.
	 * @param companyPhoneNoPrefix
	 *            String holds a phone prefix number.
	 */
	public CRM_company_phoneNo(Integer id, Integer companyId, String companyPhoneNo, String companyPhoneNoPrefix) {
		this.id = new Integer(id);
		this.company_id = new Integer(companyId);
		this.company_phoneNo = new String(companyPhoneNo);
		this.company_phoneNo_prefix = new String(companyPhoneNoPrefix);
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int string) {
		this.company_id = string;
	}

	public String getCompany_phoneNo() {
		return company_phoneNo;
	}

	public void setCompany_phoneNo(String string) {
		this.company_phoneNo = string;
	}

	public String getCompany_phoneNo_prefix() {
		return company_phoneNo_prefix;
	}

	public void setCompany_phoneNo_prefix(String company_phoneNo_prefix) {
		this.company_phoneNo_prefix = company_phoneNo_prefix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	/**
	 * toString method which is a override. It creates a much more readable output
	 * of a object
	 * 
	 * @return String with a build up JSON like format output.
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
