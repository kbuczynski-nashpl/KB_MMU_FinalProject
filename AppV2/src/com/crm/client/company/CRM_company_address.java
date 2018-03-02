package com.crm.client.company;

public class CRM_company_address {
	private Integer id = 0;
	private Integer company_id;
	private String company_address_line1;
	private String company_address_line2;
	private String company_address_postcode;
	private String company_address_city;
	private String company_address_country;
	private Boolean company_address_active = false;
	
	public CRM_company_address() {}	
	public CRM_company_address(int companyId,  String companyAddressLine1, String companyAddressPostcode, String companyAddressCity, String companyAddressCountry, Boolean companyAddressIsActive) {
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
	
	public String toString() {
		if(this.company_address_line2 != null) {
			return this.company_address_line1 + " " + this.company_address_line2 + " " + this.company_address_postcode + " " + this.company_address_city + " " + this.company_address_country;
		} else {
			return this.company_address_line1 + " " + this.company_address_postcode + " " + this.company_address_city + " " + this.company_address_country;
		}
	}


}
