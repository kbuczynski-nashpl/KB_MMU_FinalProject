package com.crm.client.company;

public class CRMCompanyAddress extends CRMCompany {
	
	private String companyAddressLine1 = "";
	private String companyAddressLine2 = "";
	private String companyAddressPostCode = "";
	private String companyAddressCity = "";
	private String companyAddressCountry = "";
	
	public CRMCompanyAddress() {
		super();
	}

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

}
