package com.employe.user;

import com.utils.userLoginUtils;

public class EmployeUserClass extends EmployeClass {

	private String EmployeUserName = null;
	private String EmployePsw = null;
	private Boolean LogedIn = false;

	public EmployeUserClass(String userName, String psw) {
		super();
		this.EmployeUserName = userName;
		this.EmployePsw = psw;
	}

	public String getEmployeUserName() {
		return EmployeUserName;
	}

	public void setEmployeUserName(String employeUserName) {
		if (userLoginUtils.validateUserName(employeUserName) == true) {
			EmployeUserName = employeUserName;
		} else {
			EmployeUserName = "FAIL: Wrong User Name";
		}
	}

	public String getEmployePsw() {
		return EmployePsw;
	}

	public void setEmployePsw(String employePsw) {
		String hashPsw = userLoginUtils.HashPsw(employePsw);
		EmployePsw = hashPsw;
	}

	public Boolean getLogedIn() {
		return LogedIn;
	}

	public void setLogedIn() {
		if (userLoginUtils.validateLogin(this.EmployePsw, this.EmployeUserName) == true) {
			LogedIn = true;
		} else {
			LogedIn = false;
		}
	}

}
