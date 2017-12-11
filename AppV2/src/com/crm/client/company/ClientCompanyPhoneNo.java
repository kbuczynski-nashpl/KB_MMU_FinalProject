package com.crm.client.company;

public class ClientCompanyPhoneNo extends ClientCompanyClass {
	private Integer clientCompanyPhoneNumber = 0;
	private String clientCompanyPhoneNumberPrefix = "";

	public ClientCompanyPhoneNo() {
		super();
	}

	public Integer getClientCompanyPhoneNumber() {
		return clientCompanyPhoneNumber;
	}

	public void setClientCompanyPhoneNumber(Integer clientCompanyPhoneNumber) {
		this.clientCompanyPhoneNumber = clientCompanyPhoneNumber;
	}

	public String getClientCompanyPhoneNumberPrefix() {
		return clientCompanyPhoneNumberPrefix;
	}

	public void setClientCompanyPhoneNumberPrefix(String clientCompanyPhoneNumberPrefix) {
		this.clientCompanyPhoneNumberPrefix = clientCompanyPhoneNumberPrefix;
	}

}
