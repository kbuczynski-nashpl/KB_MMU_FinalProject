package com.crm.client.user;

import com.crm.utils.userLoginUtils;

public class ClientUserClass extends ClientClass{

	private String clientUsername = "";
	private String clientPsw = "";
	private String clientEmail = "";
	private Boolean isLoggedIn = false;
	
	public ClientUserClass() {
		super();
	}
	public String getClientPsw() {
		return clientPsw;
	}

	public void setClientPsw(String clientPsw) {
		String hashPsw = userLoginUtils.HashPsw(clientPsw);
		this.clientPsw = hashPsw;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		if (userLoginUtils.validateEmail(clientEmail) == true) {
			this.clientEmail = clientEmail;
		} else {
			this.clientEmail = null;
		}
	}
	
	public Boolean getIsLogedIn() {
		return this.isLoggedIn;
	}

	public void setLogedIn() {
		if (userLoginUtils.validateLogin(this.clientPsw, this.clientUsername) == true) {
			this.isLoggedIn = true;
		} else {
			this.isLoggedIn = false;
		}
	}

	public String getClientUsername() {
		return clientUsername;
	}

	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}
}
