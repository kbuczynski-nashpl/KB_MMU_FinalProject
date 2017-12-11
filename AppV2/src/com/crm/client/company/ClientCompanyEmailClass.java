package com.crm.client.company;

public class ClientCompanyEmailClass extends ClientCompanyClass {
	private String clientCompanyEmailAddress = "";
	private Boolean clientCompanyEmailActive = false;
	private String clientCompanyEmailType = "";
	
	public ClientCompanyEmailClass() {
		super();
	}


	public String getClientCompanyEmailAddress() {
		return clientCompanyEmailAddress;
	}

	public void setClientCompanyEmailAddress(String clientCompanyEmailAddress) {
		this.clientCompanyEmailAddress = clientCompanyEmailAddress;
	}

	public Boolean getClientCompanyEmailActive() {
		return clientCompanyEmailActive;
	}

	public void setClientCompanyEmailActive(Boolean clientCompanyEmailActive) {
		this.clientCompanyEmailActive = clientCompanyEmailActive;
	}

	public String getClientCompanyEmailType() {
		return clientCompanyEmailType;
	}

	public void setClientCompanyEmailType(String clientCompanyEmailType) {
		this.clientCompanyEmailType = clientCompanyEmailType;
	}
	
	
}
