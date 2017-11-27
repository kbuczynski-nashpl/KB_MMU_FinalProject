package com.employe.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.utils.userLoginUtils;

public class EmployeClass {

	private String employeSurname = null;
	private String employeForname = null;
	private String EmployeEmail = null;
	private Date employeDoB = null;
	private Integer employeId = null;

	public String getEmployeSurname() {
		return employeSurname;
	}

	public void setEmployeSurname(String employeSurname) {
		this.employeSurname = employeSurname;
	}

	public String getEmployeForname() {
		return employeForname;
	}

	public void setEmployeForname(String employeForname) {
		this.employeForname = employeForname;
	}

	public Date getEmployeDoB() {
		return employeDoB;
	}

	public void setEmployeDoB(String string) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(string);
			this.employeDoB = date;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmployeEmail() {
		return EmployeEmail;
	}

	public void setEmployeEmail(String employeEmail) {
		if (userLoginUtils.validateEmail(employeEmail) == true) {
			EmployeEmail = employeEmail;
		} else {
			EmployeEmail = null;
		}
	}

	public Integer getEmployeId() {
		return employeId;
	}

	public void setEmployeId(String string) {
		this.employeId = Integer.parseInt(string);
	}

}
