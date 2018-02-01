package com.crm.client.company;

public class CRM_company_email_address{
	private int id = 0;
	private int company_id = 0;
	private String company_email_address = "";
	private Boolean company_email_active = false;
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
	public String getCompany_email_Type() {
		return company_email_Type;
	}
	public void setCompany_email_Type(String company_email_Type) {
		this.company_email_Type = company_email_Type;
	}
	private String company_email_Type = "";

}
