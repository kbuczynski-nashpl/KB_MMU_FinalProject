package com.crm.client.company;

public class CRMCompanyEmail extends CRMCompany {
	private String companyEmailAddress = "";
	private Boolean companyEmailActive = false;
	private String companyEmailType = "";
	
	public CRMCompanyEmail() {
		super();
	}

	public String getCompanyEmailAddress() {
		return companyEmailAddress;
	}

	public void setCompanyEmailAddress(String companyEmailAddress) {
		this.companyEmailAddress = companyEmailAddress;
	}

	public Boolean getCompanyEmailActive() {
		return companyEmailActive;
	}

	public void setCompanyEmailActive(Boolean companyEmailActive) {
		this.companyEmailActive = companyEmailActive;
	}

	public String getCompanyEmailType() {
		return companyEmailType;
	}

	public void setCompanyEmailType(String companyEmailType) {
		this.companyEmailType = companyEmailType;
	}

}
