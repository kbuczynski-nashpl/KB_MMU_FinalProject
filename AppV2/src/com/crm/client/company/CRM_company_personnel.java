package com.crm.client.company;

import java.lang.reflect.Field;

/**
 * A class which holds a personal information. It has been designed to hold any
 * user information.
 * 
 * @author kbuczynski
 *
 */
public class CRM_company_personnel {

	private Integer id;
	private Integer company_id;
	private String company_personnel_surname;
	private String company_personnel_forname;
	private String company_personnel_email;
	private String company_personnel_phoneNo;
	private String company_personnel_phoneNo_prefix;
	private String company_personnel_position;

	public CRM_company_personnel() {
	};

	/**
	 * Constructor which populates object variables from argument values.
	 * 
	 * @param id
	 *            Integer holds an object id
	 * @param companyId
	 *            Integer holds a company unique it reference to a master table
	 *            record.
	 * @param surname
	 *            String holding a surname of a personnel
	 * @param forname
	 *            String holds a forname of a personnel
	 * @param email
	 *            String holds a email value of a personnel
	 * @param phoneNo
	 *            String holds a phone number of a personnel (it might contain
	 *            character)
	 * @param phoneNoPrefix
	 *            String holds a phone prefix value
	 * @param position
	 *            String holds a description value for a personnel status within the
	 *            business
	 */
	public CRM_company_personnel(Integer id, Integer companyId, String surname, String forname, String email,
			String phoneNo, String phoneNoPrefix, String position) {
		this.id = new Integer(id);
		this.company_id = new Integer(companyId);
		this.company_personnel_surname = new String(surname);
		this.company_personnel_forname = new String(forname);
		this.company_personnel_email = new String(email);
		this.company_personnel_phoneNo = new String(phoneNo);
		this.company_personnel_phoneNo_prefix = new String(phoneNoPrefix);
		this.company_personnel_position = new String(position);
	}

	/**
	 * 
	 * @param companyId
	 *            Integer holds a company unique it reference to a master table
	 *            record.
	 * @param surname
	 *            String holding a surname of a personnel
	 * @param forname
	 *            String holds a forname of a personnel
	 * @param email
	 *            String holds a email value of a personnel
	 * @param phoneNo
	 *            String holds a phone number of a personnel (it might contain
	 *            character)
	 * @param phoneNoPrefix
	 *            String holds a phone prefix value
	 * @param position
	 *            String holds a description value for a personnel status within the
	 *            business
	 */
	public CRM_company_personnel(Integer companyId, String surname, String forname, String email, String phoneNo,
			String phoneNoPrefix, String position) {
		this.company_id = new Integer(companyId);
		this.company_personnel_surname = new String(surname);
		this.company_personnel_forname = new String(forname);
		this.company_personnel_email = new String(email);
		this.company_personnel_phoneNo = new String(phoneNo);
		this.company_personnel_phoneNo_prefix = new String(phoneNoPrefix);
		this.company_personnel_position = new String(position);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompany_personnel_surname() {
		return company_personnel_surname;
	}

	public void setCompany_personnel_surname(String company_personnel_surname) {
		this.company_personnel_surname = company_personnel_surname;
	}

	public String getCompany_personnel_forname() {
		return company_personnel_forname;
	}

	public void setCompany_personnel_forname(String company_personnel_forname) {
		this.company_personnel_forname = company_personnel_forname;
	}

	public String getCompany_personnel_email() {
		return company_personnel_email;
	}

	public void setCompany_personnel_email(String company_personnel_email) {
		this.company_personnel_email = company_personnel_email;
	}

	public String getCompany_personnel_phoneNo() {
		return company_personnel_phoneNo;
	}

	public void setCompany_personnel_phoneNo(String company_personnel_phoneNo) {
		this.company_personnel_phoneNo = company_personnel_phoneNo;
	}

	public String getCompany_personnel_phoneNo_prefix() {
		return company_personnel_phoneNo_prefix;
	}

	public void setCompany_personnel_phoneNo_prefix(String company_personnel_phoneNo_prefix) {
		this.company_personnel_phoneNo_prefix = company_personnel_phoneNo_prefix;
	}

	public String getCompany_personnel_position() {
		return company_personnel_position;
	}

	public void setCompany_personnel_position(String company_personnel_position) {
		this.company_personnel_position = company_personnel_position;
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