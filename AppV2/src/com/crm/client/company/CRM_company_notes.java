package com.crm.client.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.crm.client.user.CRM_user_information;
import com.db.mysql.models.DOB_CRM_user_information;

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

	public CRM_company_notes(Integer id, Integer companyId, String noteTitle, String note, Integer userId,
			String dateStamp, Integer assignedUserId, String status, String dueInTimeStamp) {
		this.id = new Integer(id);
		this.company_id = new Integer(companyId);
		this.company_note_title = new String(noteTitle);
		this.company_note = new String(note);
		this.company_note_by_id = new Integer(userId);
		try {
			this.setCompany_note_by_date_fromString(dateStamp);
			this.setCompany_note_duein_fromString(dueInTimeStamp);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.company_note_assigned_user = new Integer(assignedUserId);
		this.company_note_status = new String(status);
	}

	public CRM_company_notes(Integer companyId, String noteTitle, String note, Integer userId, String dateStamp,
			Integer assignedUserId, String status, String dueInTimeStamp) {
		this.company_id = new Integer(companyId);
		this.company_note_title = new String(noteTitle);
		this.company_note = new String(note);
		this.company_note_by_id = new Integer(userId);
		try {
			this.setCompany_note_by_date_fromString(dateStamp);
			this.setCompany_note_duein_fromString(dueInTimeStamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.company_note_assigned_user = new Integer(assignedUserId);
		this.company_note_status = new String(status);

	}

	public CRM_company_notes(Integer companyId, String noteTitle, String note, Integer userId, String dateStamp) {
		this.company_id = new Integer(companyId);
		this.company_note_title = new String(noteTitle);
		this.company_note = new String(note);
		this.company_note_by_id = new Integer(userId);
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

	public String getCompany_note(int charAmount) {
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

	public String getCompany_note_by_dateToString() {
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return dataFormat.format(this.getCompany_note_by_date());

	}

	public String getCompany_note_dueinToString() {
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return dataFormat.format(this.getCompany_note_duein());

	}

	public Date getCompany_note_by_date() {
		return this.company_note_by_date;
	}

	public void setCompany_note_by_date(Date company_note_by_date) {
		this.company_note_by_date = company_note_by_date;
	}

	public void setCompany_note_by_date_fromString(String string) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.company_note_by_date = format.parse(string);

	}

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

	public CRM_user_information getCompany_note_assignedToName() throws NumberFormatException, ParseException {
		DOB_CRM_user_information cui = new DOB_CRM_user_information();
		return cui.getByUserId(this.company_note_assigned_user);
	}
	public CRM_user_information getLastEditedBy() throws NumberFormatException, ParseException {
		DOB_CRM_user_information cui = new DOB_CRM_user_information();
		return cui.getByUserId(this.company_note_by_id);
	}
}
