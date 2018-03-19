package com.crm.client.user;

import com.crm.utils.userLoginUtils;

public class CRM_user {

	private Integer id;
	private Integer user_master_id ;
	private String user_username;
	private String user_email;
	private String user_psw;
	private Boolean isLoggedIn = false;

	public CRM_user() {
	}

	public CRM_user(Integer id, Integer masterId, String username, String psw, String email) {
		this.id = id;
		this.user_master_id = masterId;
		this.user_username = username;
		this.user_psw = psw;
		this.user_email = email;
	}

	public String getUser_email() {
		return user_email;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_psw() {
		return user_psw;
	}

	public void setUser_psw(String user_psw) {
		this.user_psw = user_psw;
	}

	public void setUser_email(String clientEmail) {
		if (userLoginUtils.validateEmail(clientEmail) == true) {
			this.user_email = clientEmail;
		} else {
			this.user_email = null;
		}
	}

	public Boolean getIsLogedIn() {
		return this.isLoggedIn;
	}

	public void setLogedIn(String psw, String usrName) {
		if (userLoginUtils.validateLogin(psw, usrName) == true) {
			this.isLoggedIn = true;
		} else {
			this.isLoggedIn = false;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_master_id() {
		return user_master_id;
	}

	public void setUser_master_id(Integer user_master_id) {
		this.user_master_id = user_master_id;
	}

}
