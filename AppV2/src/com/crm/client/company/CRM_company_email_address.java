package com.crm.client.company;

import java.lang.reflect.Field;

/**
 * CRM_company_email_address class.
 * 
 * Its main design to story a company email address object. The main functions
 * of the object is to manipulate and store email information
 * 
 * @author kbuczynski
 *
 */
public class CRM_company_email_address {
	private Integer id = 0;
	private Integer company_id;
	private String company_email_address;
	private String company_email_type;
	private Boolean company_email_active = false;

	public CRM_company_email_address() {
	}

	/**
	 * A constructor which accepts information as parameter. It stores given
	 * information creating a object.
	 * 
	 * @param companyId
	 *            Integer holds a company id unique value which links to master
	 *            table.
	 * @param companyEmailAddress
	 *            String holds a email address value
	 * @param companyEmailType
	 *            String holds email type description
	 * @param companyEmailIsActive
	 *            Boolean holds a true/false value if the email object is used or
	 *            not withing the context of application
	 */
	public CRM_company_email_address(Integer companyId, String companyEmailAddress, String companyEmailType,
			Boolean companyEmailIsActive) {
		this.company_id = new Integer(companyId);
		this.company_email_active = companyEmailIsActive;
		this.company_email_type = new String(companyEmailType);
	}

	/**
	 * A constructor which accepts information as parameter. It stores given
	 * information creating a object.
	 * 
	 * @param companyId
	 *            Integer holds a company id unique value which links to master
	 *            table.
	 * @param companyEmailAddress
	 *            String holds a email address value
	 * @param companyEmailType
	 *            String holds email type description
	 */
	public CRM_company_email_address(Integer companyId, String companyEmailAddress, String companyEmailType) {
		this.company_id = new Integer(companyId);
		this.company_email_address = new String(companyEmailAddress);
		this.company_email_type = new String(companyEmailType);
	}

	/**
	 * A constructor which acepts information as paramter. It stores given
	 * information creating a object.
	 * 
	 * @param id
	 *            Integer holds a object unique value
	 * @param companyId
	 *            Integer holds a company id unique value which links to master
	 *            table.
	 * @param companyEmailAddress
	 *            String holds an email address value
	 * @param companyEmailType
	 *            String holds email type description
	 */
	public CRM_company_email_address(Integer id, Integer companyId, String companyEmailAddress,
			String companyEmailType) {
		this.id = new Integer(id);
		this.company_id = new Integer(companyId);
		this.company_email_address = new String(companyEmailAddress);
		this.company_email_type = new String(companyEmailType);
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompany_email_address() {
		return company_email_address;
	}

	public void setCompany_email_address(String company_email_address) {
		this.company_email_address = company_email_address;
	}

	public Boolean getCompany_email_active() {
		return company_email_active;
	}

	public void setCompany_email_active(Boolean company_email_active) {
		this.company_email_active = company_email_active;
	}

	public String getCompany_email_type() {
		return company_email_type;
	}

	public void setCompany_email_type(String company_email_Type) {
		this.company_email_type = company_email_Type;
	}

	/**
	 * A function witch return a integer value of a 1 or 0 depending if the email
	 * object is active or not
	 * 
	 * @return Integer value
	 */
	public Integer getCompany_email_activeToInt() {
		if (this.company_email_active.equals(true)) {
			return 1;
		} else {
			return 0;
		}
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
