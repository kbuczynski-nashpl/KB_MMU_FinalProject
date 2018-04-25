package com.crm.client.company;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.crm.client.user.CRM_user_information;
import com.db.mysql.models.DBO_CRM_user_information;

/**
 * CRM_company_notes class
 * A object which holds a notes data. It has been designed to hold and manipulate a String objects.
 * 
 * @author kbuczynski
 *
 */
public class CRM_company_notes {
	private Integer id;
	private Integer company_id;
	private String company_note_title;
	private String company_note;
	private Integer company_note_by_id;
	private Date company_note_by_date;
	private Integer company_note_assigned_user;
	private String company_note_status;
	private Date company_note_duein;

	public CRM_company_notes() {
	}

	/**
	 * A constructor which accepts parameters. It uses arguments to populates a variables.
	 * 
	 * @param id Integer holds a object unique id value.
	 * @param companyId Integer holds a unique id value which links to master table.
	 * @param noteTitle String holds a note title value.
	 * @param note String holds a main note informations.
	 * @param company_note_by_id Integer holds a unique id value which links to company table. The value links to company who made the note.
	 * @param dateStamp String object which holds a note update date as a String value.
	 * @param assignedUserId Integer holds a unique id value which links to user table. The value links to a user who is assigned to the note. 
	 * @param status String holds a value which states the current status of the note.
	 * @param dueInTimeStamp String holds a value which specifies when the note is about to expire
	 */
	public CRM_company_notes(Integer id, Integer companyId, String noteTitle, String note, Integer company_note_by_id,
			String dateStamp, Integer assignedUserId, String status, String dueInTimeStamp) {
		this.id = new Integer(id);
		this.company_id = new Integer(companyId);
		this.company_note_title = new String(noteTitle);
		this.company_note = new String(note);
		this.company_note_by_id = new Integer(company_note_by_id);
		try {
			this.setCompany_note_by_date_fromString(dateStamp);
			this.setCompany_note_duein_fromString(dueInTimeStamp);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.company_note_assigned_user = new Integer(assignedUserId);
		this.company_note_status = new String(status);
	}

	/**
	 * A constructor which accepts parameters. It uses arguments to populates a variables.
	 * 
	 * @param companyId Integer holds a unique id value which links to master table.
	 * @param noteTitle String holds a note title value.
	 * @param note String holds a main note informations.
	 * @param company_note_by_id Integer holds a unique id value which links to company table. The value links to company who made the note.
	 * @param dateStamp String object which holds a note update date as a String value.
	 * @param assignedUserId Integer holds a unique id value which links to user table. The value links to a user who is assigned to the note. 
	 * @param status String holds a value which states the current status of the note.
	 * @param dueInTimeStamp String holds a value which specifies when the note is about to expire
	 */
	public CRM_company_notes(Integer companyId, String noteTitle, String note, Integer company_note_by_id, String dateStamp,
			Integer assignedUserId, String status, String dueInTimeStamp) {
		this.company_id = new Integer(companyId);
		this.company_note_title = new String(noteTitle);
		this.company_note = new String(note);
		this.company_note_by_id = new Integer(company_note_by_id);
		try {
			this.setCompany_note_by_date_fromString(dateStamp);
			this.setCompany_note_duein_fromString(dueInTimeStamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.company_note_assigned_user = new Integer(assignedUserId);
		this.company_note_status = new String(status);

	}
	
	/**
	 * A constructor which accepts parameters. It uses arguments to populates a variables.
	 *
	 * @param companyId Integer holds a unique id value which links to master table.
	 * @param noteTitle String holds a note title value.
	 * @param note String holds a main note informations.
	 * @param company_note_by_id Integer holds a unique id value which links to company table. The value links to company who made the note.
	 * @param dateStamp String object which holds a note update date as a String value.
	 */
	public CRM_company_notes(Integer companyId, String noteTitle, String note, Integer company_note_by_id, String dateStamp) {
		this.company_id = new Integer(companyId);
		this.company_note_title = new String(noteTitle);
		this.company_note = new String(note);
		this.company_note_by_id = new Integer(company_note_by_id);
		try {
			this.setCompany_note_by_date_fromString(dateStamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	/**
	 * A function which return a note value. If an argument is passed and it is greaten than 0 it will return specified number of character in the note variable followed by "..." other wise it will return a full string. 
	 * @param charAmount Integer with amount of characters to return if is set to 0 or lower it will return a full string
	 * @return String with a note value
	 */
	public String getCompany_note(Integer charAmount) {
		if (charAmount == 0 || this.company_note.length() <= charAmount) {
			return this.company_note;
		} else {
			return this.company_note.substring(0, charAmount) + "...";
		}
	}

	public void setCompany_note(String company_note) {
		this.company_note = company_note;
	}

	public Integer getCompany_note_by_id() {
		return company_note_by_id;
	}

	public void setCompany_note_by_id(Integer company_note_by_id) {
		this.company_note_by_id = company_note_by_id;
	}

	/**
	 * A function which return date in format of yyyy-MM-dd HH:mm i.e. 2018-01-01 00:01.
	 * @return String parsed date to specific format
	 */
	public String getCompany_note_by_dateToString() {
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return dataFormat.format(this.getCompany_note_by_date());

	}

	/**
	 * A function which return date in format of yyyy-MM-dd HH:mm i.e. 2018-01-01 00:11
	 * @return String parsed date to specific format
	 */
	public String getCompany_note_dueinToString() {
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return dataFormat.format(this.getCompany_note_duein());

	}

	/**
	 * A function which return a date in a string from contains "T" instead of space value
	 * @return String parsed date to specific format
	 */
	public String getCompany_note_dueinToStringToFrom() {
		String dueInDate = this.getCompany_note_dueinToString();
		return dueInDate.replace(" ", "T");
	}

	public Date getCompany_note_by_date() {
		return this.company_note_by_date;
	}

	public void setCompany_note_by_date(Date company_note_by_date) {
		this.company_note_by_date = company_note_by_date;
	}

	/**
	 * A function which creates a date object from a string formated as yyyy-MM-dd HH:mm i.e 2018-01-01 00:01
	 * @param string String contain a date value
	 * @throws ParseException
	 */
	public void setCompany_note_by_date_fromString(String string) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.company_note_by_date = format.parse(string);

	}
	/**
	 * A function which creates a date object from a string formated as yyyy-MM-dd HH:mm i.e 2018-01-01 00:01
	 * @param string String contain a date value
	 * @throws ParseException
	 */
	public void setCompany_note_duein_fromString(String string) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		string = string.replace("T", " ");

		this.company_note_duein = format.parse(string);

	}

	public String getCompany_note_title() {
		return company_note_title;
	}

	public void setCompany_note_title(String company_note_title) {
		this.company_note_title = company_note_title;
	}

	public String getCompany_note_status() {
		return company_note_status;
	}

	public void setCompany_note_status(String company_note_status) {
		this.company_note_status = company_note_status;
	}

	public Integer getCompany_note_assigned_user() {
		return company_note_assigned_user;
	}

	public void setCompany_note_assigned_user(Integer company_note_assigned_user) {
		this.company_note_assigned_user = company_note_assigned_user;
	}

	public Date getCompany_note_duein() {
		return company_note_duein;
	}

	public void setCompany_note_duein(Date company_note_duein) {
		this.company_note_duein = company_note_duein;
	}
	
	/**
	 * Function which returns a surname and forname of a user assigned to the note.
	 * It queries a database for the information so might not be usable unless correct link is created. 
	 * @return
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public CRM_user_information getCompany_note_assignedToName() throws NumberFormatException, ParseException {
		return DBO_CRM_user_information.getByUserId(this.company_note_assigned_user);
	}

	/**
	 * Function which returns a surname and forname of a user who last edited the note.
	 * It queries a database for the information so might not be usable unless correct link is created. 
	 * @return
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public CRM_user_information getLastEditedBy() throws NumberFormatException, ParseException {
		return DBO_CRM_user_information.getByUserId(this.company_note_by_id);
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
