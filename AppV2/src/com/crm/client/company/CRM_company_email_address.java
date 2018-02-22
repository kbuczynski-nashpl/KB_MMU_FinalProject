package com.crm.client.company;

public class CRM_company_email_address{
	private int id = 0;
	private int company_id = 0;
	private String company_email_address = "";
	private Boolean company_email_active = false;
	private String company_email_type = "";
	
	public CRM_company_email_address() {}
	public CRM_company_email_address(int id, int companyId, String companyEmailAddress, String companyEmailType, Boolean companyEmailIsActive) {
		this.id = id;
		this.company_id = companyId;
		this.company_email_active = companyEmailIsActive;
		this.company_email_type = companyEmailType;
	}
	public CRM_company_email_address(int companyId, String companyEmailAddress, String companyEmailType) {
		this.company_id = companyId;
		this.company_email_address = companyEmailAddress;
		this.company_email_type = companyEmailType;
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
	public int getCompany_email_activeToInt() {
		if(this.company_email_active.equals(true)) {
			return 1;
		} else {
			return 0;
		}
	}
	public String toString() {
		String str = "ID: " + this.id + 
				" Company ID: " + this.company_id + 
				" Email Address: " + this.company_email_address + 
				" Email Active: "  + this.company_email_active + 
				" Email Type: " + this.company_email_type;
		return str;
	}

}
