package com.crm.client.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientCompanyNotes extends ClientCompanyClass{
	private String clientCompanyNote = "";
	private Integer clientCompanyNoteUserId = 0;
	private Date clientCompanyNoteDate = new Date();
	
	public ClientCompanyNotes() {
		super();
	}

	public String getClientCompanyNote() {
		return clientCompanyNote;
	}

	public void setClientCompanyNote(String clientCompanyNote) {
		this.clientCompanyNote = clientCompanyNote;
	}

	public Integer getClientCompanyNoteUserId() {
		return clientCompanyNoteUserId;
	}

	public void setClientCompanyNoteUserId(Integer clientCompanyNoteUserId) {
		this.clientCompanyNoteUserId = clientCompanyNoteUserId;
	}

	public Date getClientCompanyNoteDate() {
		return clientCompanyNoteDate;
	}

	public void setClientCompanyNoteDate(String clientCompanyNoteDate) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(clientCompanyNoteDate);
			this.clientCompanyNoteDate = date;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
