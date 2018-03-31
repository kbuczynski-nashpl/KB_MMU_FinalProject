package com.crm.client.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CRM_user_information {

	private Integer id;
	private Integer user_id;
	private String user_surname;
	private String user_forname;
	private Date user_dob;

	public CRM_user_information() {
	}

	public CRM_user_information(Integer id, Integer user_id, String surname, String forname, String DOB)
			throws ParseException {
		this.id = id;
		this.user_id = user_id;
		this.user_surname = surname;
		this.user_forname = forname;
		setUser_dobFromString(DOB);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_master_id) {
		this.user_id = user_master_id;
	}

	public String getUser_surname() {
		return user_surname;
	}

	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}

	public String getUser_forname() {
		return user_forname;
	}

	public void setUser_forname(String user_forname) {
		this.user_forname = user_forname;
	}

	public Date getUser_dob() {
		return user_dob;
	}

	public void setUser_dob(Date user_dob) {
		this.user_dob = user_dob;
	}

	public void setUser_dobFromString(String user_dob) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.user_dob = format.parse(user_dob);
	}

	public String getUser_dobFromString() {
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dataFormat.format(this.getUser_dob());

	}
	public String getFullName() {
		return this.user_surname + " " + this.user_forname;
	}

}
