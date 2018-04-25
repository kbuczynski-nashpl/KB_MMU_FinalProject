package com.crm.client.company;

import java.lang.reflect.Field;

/**
 * CRM_company_address class.
 * 
 * The class has been designed to store and manipulate a company address objects.
 * It variables names are names the same as database table headers.  
 * 
 * @author kbuczynski
 * @version 1.2
 * 
 *
 */
public class CRM_company_address {
	
	private Integer id = 0;
	private Integer company_id;
	private String company_address_line1;
	private String company_address_line2;
	private String company_address_postcode;
	private String company_address_city;
	private String company_address_country;
	private Boolean company_address_active = false;

	/**
	 * Empty constructor placed so the object can be build dynamically.
	 */
	public CRM_company_address() {
	}

	/**
	 * A standard constructor which populates the object variables (except address line 2 due to no guarantee variable)
	 *  
	 * @param companyId Integer Holds a company id value
	 * @param companyAddressLine1 String Holds a company address line 1 entry
	 * @param companyAddressPostcode String Holds a company address post code entry
	 * @param companyAddressCity String Holds a company address city
	 * @param companyAddressCountry String Holds a company Country
	 * @param companyAddressIsActive Boolean Holds a true or false value which determinate if the address object is the main address to use or not. 
	 */
	public CRM_company_address(Integer companyId, String companyAddressLine1, String companyAddressPostcode,
			String companyAddressCity, String companyAddressCountry, Boolean companyAddressIsActive) {
		this.company_id = new Integer(companyId);
		this.company_address_line1 = new String(companyAddressLine1);
		this.company_address_postcode = new String(companyAddressPostcode);
		this.company_address_city = new String(companyAddressCity);
		this.company_address_country = new String(companyAddressCountry);
		this.company_address_active = companyAddressIsActive;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompany_address_line1() {
		return company_address_line1;
	}

	public void setCompany_address_line1(String company_address_line1) {
		this.company_address_line1 = company_address_line1;
	}

	public String getCompany_address_line2() {
		return company_address_line2;
	}

	public void setCompany_address_line2(String company_address_line2) {
		this.company_address_line2 = company_address_line2;
	}

	public String getCompany_address_postcode() {
		return company_address_postcode;
	}

	public void setCompany_address_postcode(String company_address_postcode) {
		this.company_address_postcode = company_address_postcode;
	}

	public String getCompany_address_city() {
		return company_address_city;
	}

	public void setCompany_address_city(String company_address_city) {
		this.company_address_city = company_address_city;
	}

	public String getCompany_address_country() {
		return company_address_country;
	}

	public void setCompany_address_country(String company_address_country) {
		this.company_address_country = company_address_country;
	}

	public Boolean getCompany_address_active() {
		return company_address_active;
	}

	public void setCompany_address_active(Boolean company_address_active) {
		this.company_address_active = company_address_active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	/**
	 * A toString method which overwrites the build in function
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
