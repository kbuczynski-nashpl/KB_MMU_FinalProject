package com.crm.client.company;

public class CRM_company_phoneNo {
	private int id = 0;
	private int company_id = 0;
	private Integer company_phoneNo = 0;
	private String company_phoneNo_prefix = "";

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

	public Integer getCompany_phoneNo() {
		return company_phoneNo;
	}

	public void setCompany_phoneNo(Integer company_phoneNo) {
		this.company_phoneNo = company_phoneNo;
	}

	public String getCompany_phoneNo_prefix() {
		return company_phoneNo_prefix;
	}

	public void setCompany_phoneNo_prefix(String company_phoneNo_prefix) {
		this.company_phoneNo_prefix = company_phoneNo_prefix;
	}

}
