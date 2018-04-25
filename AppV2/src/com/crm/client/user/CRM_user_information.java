package com.crm.client.user;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CRM_user information Class. It holds user personal information
 * 
 * @author kbuczynski
 *
 */
public class CRM_user_information {

	private Integer id;
	private Integer user_id;
	private String user_surname;
	private String user_forname;
	private Date user_dob;

	public CRM_user_information() {
	}

	/**
	 * A constructor. Creates an object and passed information to it from arguments
	 * 
	 * @param id
	 *            Integer Object id number
	 * @param user_id
	 *            Integer holds a user unique number. Relates to a database record
	 * @param surname
	 *            String holds user surname
	 * @param forname
	 *            String holds user forname
	 * @param DOB
	 *            String holds a String version of user Date of Birth
	 * @throws ParseException
	 */
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

	/**
	 * Creates Date object of DOB from String
	 * 
	 * @param user_dob
	 *            String holds DOB date string
	 * @throws ParseException
	 */
	public void setUser_dobFromString(String user_dob) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.user_dob = format.parse(user_dob);
	}

	/**
	 * Returns a readable string from DOB Date object
	 * 
	 * @return String holds a date readable to human
	 */
	public String getUser_dobFromString() {
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dataFormat.format(this.getUser_dob());

	}

	/**
	 * Print user full name
	 * 
	 * @return String user full name.
	 */
	public String getFullName() {
		return this.user_surname + " " + this.user_forname;
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
