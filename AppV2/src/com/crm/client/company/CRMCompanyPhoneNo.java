package com.crm.client.company;

public class CRMCompanyPhoneNo extends CRMCompany {
	private Integer companyPhoneNumber = 0;
	private String companyPhoneNumberPrefix = "";

	public CRMCompanyPhoneNo() {
		super();
	}

	public Integer getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	public void setCompanyPhoneNumber(Integer companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public String getCompanyPhoneNumberPrefix() {
		return companyPhoneNumberPrefix;
	}

	public void setCompanyPhoneNumberPrefix(String companyPhoneNumberPrefix) {
		this.companyPhoneNumberPrefix = companyPhoneNumberPrefix;
	}

	
}
