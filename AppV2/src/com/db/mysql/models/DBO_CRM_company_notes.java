/**
 * 
 */
package com.db.mysql.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.crm.client.company.CRM_company_notes;
import com.db.mysql.MySQL;

/**
 * @author kbuczynski
 *
 */
public class DBO_CRM_company_notes extends MySQL{
	public DBO_CRM_company_notes(){
		super();
	}
	
	public ArrayList<CRM_company_notes> getByCompanyId(int id) throws ParseException {
		String queryString = "SELECT * from CRM_company_notes where company_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_notes> companyNotes = new ArrayList<CRM_company_notes>();
		for(HashMap<String, String> entries : resultFromMysql) {
			CRM_company_notes companyNote = new CRM_company_notes();
			companyNote.setId(Integer.parseInt(entries.get("id").toString()));
			companyNote.setCompany_id(Integer.parseInt(entries.get("company_id").toString()));
			companyNote.setCrm_company_note_title(entries.get("company_note_title").toString());
			String companyNoteString = entries.get("company_note").toString();
			companyNoteString = companyNoteString.replaceAll("\r", "").replaceAll("\n", "");
			companyNote.setCompany_note(companyNoteString);
			companyNote.setCompany_note_by_date_fromString(entries.get("company_note_by_date").toString());
			companyNote.setCompany_note_by_id(Integer.parseInt(entries.get("company_note_by_id").toString()));
			companyNotes.add(companyNote);		}
		return companyNotes;
	}
}
