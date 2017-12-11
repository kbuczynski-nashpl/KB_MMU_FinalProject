package com.crm.client.company;

public class ClientCompanyAddress extends ClientCompanyClass {
	
	private String clientCompanyAddressLine1 = "";
	private String clientCompanyAddressLine2 = "";
	private String clientCompanyAddressPostCode = "";
	private String clientCompanyAddressCity = "";
	private String clientCompanyAddressCountry = "";
	
	public ClientCompanyAddress() {
		super();
	}

	public String getClientCompanyAddressLine1() {
		return clientCompanyAddressLine1;
	}

	public void setClientCompanyAddressLine1(String clientCompanyAddressLine1) {
		this.clientCompanyAddressLine1 = clientCompanyAddressLine1;
	}

	public String getClientCompanyAddressLine2() {
		return clientCompanyAddressLine2;
	}

	public void setClientCompanyAddressLine2(String clientCompanyAddressLine2) {
		this.clientCompanyAddressLine2 = clientCompanyAddressLine2;
	}

	public String getClientCompanyAddressPostCode() {
		return clientCompanyAddressPostCode;
	}

	public void setClientCompanyAddressPostCode(String clientCompanyAddressPostCode) {
		this.clientCompanyAddressPostCode = clientCompanyAddressPostCode;
	}

	public String getClientCompanyAddressCity() {
		return clientCompanyAddressCity;
	}

	public void setClientCompanyAddressCity(String clientCompanyAddressCity) {
		this.clientCompanyAddressCity = clientCompanyAddressCity;
	}

	public String getClientCompanyAddressCountry() {
		return clientCompanyAddressCountry;
	}

	public void setClientCompanyAddressCountry(String clientCompanyAddressCountry) {
		this.clientCompanyAddressCountry = clientCompanyAddressCountry;
	}

}
