package com.crm.client.user;

import java.lang.reflect.Field;

import com.crm.utils.LoginUtils;

/**
 * A class which holds a crm user information
 * 
 * @author kbuczynski
 *
 */
public class CRM_user {

	private Integer id;
	private Integer user_master_id;
	private String user_username;
	private String user_email;
	private String user_psw;
	private Boolean isLoggedIn = false;

	public CRM_user() {
	}

	/**
	 * A constructor assigns values to varaibles from the arguments.
	 * 
	 * @param id
	 * @param masterId
	 * @param username
	 * @param psw
	 * @param email
	 */
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

	/**
	 * setUser_email function. sets user email if the validation return true
	 * 
	 * @param clientEmail
	 *            String holds email address
	 */
	public void setUser_email(String clientEmail) {
		if (LoginUtils.validateEmail(clientEmail) == true) {
			this.user_email = clientEmail;
		} else {
			this.user_email = null;
		}
	}

	public Boolean getIsLogedIn() {
		return this.isLoggedIn;
	}

	/**
	 * setLogedIn function sets object login state to true or false based on user
	 * login actions.
	 * 
	 * It will query database for information to validate the login
	 * 
	 * 
	 * @param psw
	 *            String holds password string
	 * @param usrName
	 *            String holds username string
	 */
	public void setLogedIn(String psw, String usrName) {
		if (LoginUtils.validateLogin(psw, usrName) == true) {
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

	@Override
	/**
	 * A toString method which overwrites the build in function
	 * 
	 * @return String with a class variables and values
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		Field[] fields = this.getClass().getDeclaredFields();
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				result.append(field.getName() + ": " + field.get(this) + " ");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		result.append("}");

		return result.toString();
	}

}
