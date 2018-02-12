package com.crm.client.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CRM_user_information{
	
	private int id = 0;
	private int user_master_id = 0;
	private String user_surname = "";
	private String user_forname = "";
	private Date user_dob = new Date();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_master_id() {
		return user_master_id;
	}
	public void setUser_master_id(int user_master_id) {
		this.user_master_id = user_master_id;
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
		DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		this.user_dob = format.parse(user_dob);
	}


}
