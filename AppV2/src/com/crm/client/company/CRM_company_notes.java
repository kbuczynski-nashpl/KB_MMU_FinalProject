package com.crm.client.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CRM_company_notes {
	private int id = 0;
	private int company_id = 0;
	private String crm_company_note_title = "";
	private String company_note = "";
	private Integer company_note_by_id = 0;
	private Date company_note_by_date = new Date();

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
		if(charAmount == 0 || this.company_note.length() <= charAmount) {
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
	public Date getCompany_note_by_date() {
		return this.company_note_by_date;
	}

	public void setCompany_note_by_date(Date company_note_by_date) {
		this.company_note_by_date = company_note_by_date;
	}

	public void setCompany_note_by_date_fromString(String string) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.company_note_by_date = format.parse(string);
		
	}

	public String getCrm_company_note_title() {
		return crm_company_note_title;
	}

	public void setCrm_company_note_title(String crm_company_note_title) {
		this.crm_company_note_title = crm_company_note_title;
	}
}
