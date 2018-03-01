package com.crm.client.company;

public class CRM_company_phoneNo {
	private Integer id = 0;
	private Integer company_id;
	private String company_phoneNo;
	private String company_phoneNo_prefix;
	
	public CRM_company_phoneNo() {}

	public CRM_company_phoneNo(int companyId, String companyPhoneNo, String companyPhoneNoPrefix) {
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

}
