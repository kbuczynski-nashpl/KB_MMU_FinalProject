package com.crm.client.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CRMCompanyNotes extends CRMCompany{
	private String companyNote = "";
	private Integer companyNoteUserId = 0;
	private Date companyNoteDate = new Date();
	
	public CRMCompanyNotes() {
		super();
	}
	
	public Date getCompanyNoteDate() {
		return this.companyNoteDate;
	}

	public String getCompanyNote() {
		return companyNote;
	}

	public void setCompanyNote(String companyNote) {
		this.companyNote = companyNote;
	}

	public Integer getCompanyNoteUserId() {
		return companyNoteUserId;
	}

	public void setCompanyNoteUserId(Integer companyNoteUserId) {
		this.companyNoteUserId = companyNoteUserId;
	}

	public void setCompanyNoteDate(String clientCompanyNoteDate) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(clientCompanyNoteDate);
			this.companyNoteDate = date;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
