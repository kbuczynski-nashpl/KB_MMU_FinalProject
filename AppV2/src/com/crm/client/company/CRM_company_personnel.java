package com.crm.client.company;

public class CRM_company_personnel {

	private int id = 0;
	private int company_id = 0;
	private String company_personnel_surname = "";
	private String company_personnel_forname = "";
	private String company_personnel_email = "";
	private String company_personnel_phoneNo = "";
	private String company_personnel_phoneNo_prefix = "";
	private String company_personnel_position = "";

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

	public String getCompany_personnel_surname() {
		return company_personnel_surname;
	}

	public void setCompany_personnel_surname(String company_personnel_surname) {
		this.company_personnel_surname = company_personnel_surname;
	}

	public String getCompany_personnel_forname() {
		return company_personnel_forname;
	}

	public void setCompany_personnel_forname(String company_personnel_forname) {
		this.company_personnel_forname = company_personnel_forname;
	}

	public String getCompany_personnel_email() {
		return company_personnel_email;
	}

	public void setCompany_personnel_email(String company_personnel_email) {
		this.company_personnel_email = company_personnel_email;
	}

	public String getCompany_personnel_phoneNo() {
		return company_personnel_phoneNo;
	}

	public void setCompany_personnel_phoneNo(String company_personnel_phoneNo) {
		this.company_personnel_phoneNo = company_personnel_phoneNo;
	}

	public String getCompany_personnel_phoneNo_prefix() {
		return company_personnel_phoneNo_prefix;
	}

	public void setCompany_personnel_phoneNo_prefix(String company_personnel_phoneNo_prefix) {
		this.company_personnel_phoneNo_prefix = company_personnel_phoneNo_prefix;
	}

	public String getCompany_personnel_position() {
		return company_personnel_position;
	}

	public void setCompany_personnel_position(String company_personnel_position) {
		this.company_personnel_position = company_personnel_position;
	}
}