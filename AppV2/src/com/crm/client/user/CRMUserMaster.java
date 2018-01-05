package com.crm.client.user;

public class CRMUserMaster {

	private Integer id = 0;
	private String userCompanyName = "";
	
	public String getClientName() {
		return userCompanyName;
	}
	public void setClientName(String clientName) {
		this.userCompanyName = clientName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}