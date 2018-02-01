package com.crm.client.company;

public class CRM_company_address{
	private int id = 0;
	private int company_id = 0;
	private String companyAddressLine1 = "";
	private String companyAddressLine2 = "";
	private String companyAddressPostCode = "";
	private String companyAddressCity = "";
	private String companyAddressCountry = "";
	
	public String getCompanyAddressLine1() {
		return companyAddressLine1;
	}

	public void setCompanyAddressLine1(String companyAddressLine1) {
		this.companyAddressLine1 = companyAddressLine1;
	}

	public String getCompanyAddressLine2() {
		return companyAddressLine2;
	}

	public void setCompanyAddressLine2(String companyAddressLine2) {
		this.companyAddressLine2 = companyAddressLine2;
	}

	public String getCompanyAddressPostCode() {
		return companyAddressPostCode;
	}

	public void setCompanyAddressPostCode(String companyAddressPostCode) {
		this.companyAddressPostCode = companyAddressPostCode;
	}

	public String getCompanyAddressCity() {
		return companyAddressCity;
	}

	public void setCompanyAddressCity(String companyAddressCity) {
		this.companyAddressCity = companyAddressCity;
	}

	public String getCompanyAddressCountry() {
		return companyAddressCountry;
	}

	public void setCompanyAddressCountry(String companyAddressCountry) {
		this.companyAddressCountry = companyAddressCountry;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
