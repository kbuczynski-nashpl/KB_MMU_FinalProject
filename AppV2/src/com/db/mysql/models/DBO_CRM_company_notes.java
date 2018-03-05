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
public class DBO_CRM_company_notes extends MySQL {
	public DBO_CRM_company_notes() {
		super();
	}

	public ArrayList<CRM_company_notes> getByCompanyId(int id) throws ParseException {
		String queryString = "SELECT * from CRM_company_notes where company_id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_notes> companyNotes = new ArrayList<CRM_company_notes>();
		for (HashMap<String, String> entries : resultFromMysql) {
			String companyNoteString = entries.get("company_note").toString();
			companyNoteString = companyNoteString.replaceAll("\r", "").replaceAll("\n", "");
			CRM_company_notes companyNote = new CRM_company_notes(Integer.parseInt(entries.get("id").toString()),
					Integer.parseInt(entries.get("company_id").toString()),
					entries.get("company_note_title").toString(), companyNoteString,
					Integer.parseInt(entries.get("company_note_by_id").toString()),
					entries.get("company_note_by_date").toString());
			companyNotes.add(companyNote);
		}
		return companyNotes;
	}

	public CRM_company_notes getById(Integer id) {
		String queryString = "SELECT * from CRM_company_notes where id = " + id;
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		String companyNoteString = resultFromMysql.get(0).get("company_note").toString();
		companyNoteString = companyNoteString.replaceAll("\r", "").replaceAll("\n", "");
		CRM_company_notes ccn = new CRM_company_notes(Integer.parseInt(resultFromMysql.get(0).get("id").toString()),
				Integer.parseInt(resultFromMysql.get(0).get("company_id").toString()),
				resultFromMysql.get(0).get("company_note_title"), companyNoteString,
				Integer.parseInt(resultFromMysql.get(0).get("company_note_by_id").toString()),
				resultFromMysql.get(0).get("company_note_by_date").toString());
		return ccn;
	}
	
	public HashMap<String, String> updateNote(HashMap<String, String> newValues, Integer id){
		String queryString = "UPDATE CRM_company_notes SET "
				+ "company_note_title = '" + newValues.get("noteTitle") + "', "
				+ "company_note = '" + newValues.get("note") + "', "
				+ "company_note_by_id = '" + newValues.get("noteUserId") + "', "
				+ "company_note_by_date = '" + newValues.get("noteDate")
				+ "' WHERE id = " + id;
		
		return update(queryString);
	}
	
}
