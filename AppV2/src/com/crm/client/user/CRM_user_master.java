package com.crm.client.user;

public class CRM_user_master {

	private Integer id = 0;
	private String user_company_name = "";

	public CRM_user_master() {
	}

	public CRM_user_master(Integer id, String userCompanyName) {
		this.id = id;
		this.user_company_name = userCompanyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_company_name() {
		return user_company_name;
	}

	public void setUser_company_name(String user_company_name) {
		this.user_company_name = user_company_name;
	}

}