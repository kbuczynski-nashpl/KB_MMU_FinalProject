package com.crm.client.company;

public class CRM_company_phoneNo {
	private int id = 0;
	private int company_id = 0;
	private String company_phoneNo = "";
	private String company_phoneNo_prefix = "";
	
	public CRM_company_phoneNo() {}
	public CRM_company_phoneNo(int id, int companyId, String companyPhoneNo, String companyPhoneNoPrefix) {
		this.id = id;
		this.company_id = companyId;
		this.company_phoneNo = companyPhoneNo;
		this.company_phoneNo_prefix = companyPhoneNoPrefix;
	}
	public CRM_company_phoneNo(int companyId, String companyPhoneNo, String companyPhoneNoPrefix) {
		this.company_id = companyId;
		this.company_phoneNo = companyPhoneNo;
		this.company_phoneNo_prefix = companyPhoneNoPrefix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
