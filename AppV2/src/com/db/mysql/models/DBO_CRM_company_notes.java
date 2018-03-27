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
					entries.get("company_note_by_date").toString(),
					Integer.parseInt(entries.get("company_note_assigned_user").toString()),
					entries.get("company_note_status"), entries.get("company_note_duein"));
			companyNotes.add(companyNote);
		}
		return companyNotes;
	}

	public ArrayList<CRM_company_notes> getByCompanyIdTop5(Integer id) {
		String queryString = "SELECT * from CRM_company_notes where company_note_by_id = " + id
				+ " ORDER BY company_note_by_date DESC LIMIT 5";
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		ArrayList<CRM_company_notes> companyNotes = new ArrayList<CRM_company_notes>();
		for (HashMap<String, String> entries : resultFromMysql) {
			String companyNoteString = entries.get("company_note").toString();
			companyNoteString = companyNoteString.replaceAll("\r", "").replaceAll("\n", "");
			CRM_company_notes companyNote = new CRM_company_notes(Integer.parseInt(entries.get("id").toString()),
					Integer.parseInt(entries.get("company_id").toString()),
					entries.get("company_note_title").toString(), companyNoteString,
					Integer.parseInt(entries.get("company_note_by_id").toString()),
					entries.get("company_note_by_date").toString(),
					Integer.parseInt(entries.get("company_note_assigned_user").toString()),
					entries.get("company_note_status"), entries.get("company_note_duein"));
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
				resultFromMysql.get(0).get("company_note_by_date").toString(),
				Integer.parseInt(resultFromMysql.get(0).get("company_note_assigned_user").toString()),
				resultFromMysql.get(0).get("company_note_status"), resultFromMysql.get(0).get("company_note_duein"));
		return ccn;
	}

	public HashMap<String, String> updateNote(HashMap<String, String> newValues, Integer id) {
		String queryString = "UPDATE CRM_company_notes SET " + "company_note_title = '" + newValues.get("noteTitle")
				+ "', " + "company_note = '" + newValues.get("note") + "', " + "company_note_by_id = '"
				+ newValues.get("noteUserId") + "', " + "company_note_by_date = '" + newValues.get("noteDate") + "', "
				+ "company_note_assigned_user = '" + newValues.get("noteAssigne") + "', " + "company_note_status = '"
				+ newValues.get("noteStatus") + "', " + "company_note_duein = '" + newValues.get("noteDuein") + "' "
				+ "WHERE id = " + id;
		return update(queryString);
	}

	public HashMap<String, String> updateNoteAssgine(Integer assigne, Integer noteId) {
		String queryString = "UPDATE CRM_company_notes SET " + "company_note_assigned_user = " + assigne
				+ " WHERE id = " + noteId;
		return update(queryString);
	}

	public HashMap<String, String> updateNoteStatus(String status, Integer noteId) {
		String queryString = "UPDATE CRM_company_notes SET " + "company_note_status = '" + status + "' WHERE id = "
				+ noteId;
		return update(queryString);
	}

	public HashMap<String, String> removeNoteById(Integer id) {
		String queryString = "DELETE FROM CRM_company_notes where id = " + id;
		return update(queryString);
	}

	public HashMap<String, String> newNote(CRM_company_notes ccn) {
		String queryString = "INSERT INTO CRM_company_notes " + "(company_id, " + "company_note_title, "
				+ "company_note, " + "company_note_by_id, " + "company_note_by_date, " + "company_note_assigned_user, "
				+ "company_note_status, " + "company_note_duein" + ") " + "VALUES (" + ccn.getCompany_id() + ", " + "'"
				+ ccn.getCompany_note_title() + "', " + "'" + ccn.getCompany_note(0) + "', " + "'"
				+ ccn.getCompany_note_by_id() + "', " + "'" + ccn.getCompany_note_by_dateToString() + "', " + "'"
				+ ccn.getCompany_note_assigned_user() + "', " + "'" + ccn.getCompany_note_status() + "', " + "'"
				+ ccn.getCompany_note_dueinToString() + "')";
		return update(queryString);
	}

	public ArrayList<CRM_company_notes> getAllByDate(String date, Integer userId) {
		String queryString = "SELECT * FROM CRM_company_notes WHERE company_note_by_date <= '" + date
				+ "' AND company_note_assigned_user = " + userId
				+ " AND company_note_status NOT LIKE 'OPEN' ORDER BY company_note_by_date DESC LIMIT 5";
		ArrayList<CRM_company_notes> returnResult = new ArrayList<CRM_company_notes>();
		ArrayList<HashMap<String, String>> resultFromMysql = query(queryString);
		for (HashMap<String, String> entry : resultFromMysql) {
			CRM_company_notes ccn = new CRM_company_notes(Integer.parseInt(entry.get("id").toString()),
					Integer.parseInt(entry.get("company_id").toString()), entry.get("company_note_title").toString(),
					entry.get("company_note").toString(), Integer.parseInt(entry.get("company_note_by_id").toString()),
					entry.get("company_note_by_date").toString(),
					Integer.parseInt(entry.get("company_note_assigned_user").toString()),
					entry.get("company_note_status").toString(), entry.get("company_note_duein").toString());
			returnResult.add(ccn);
		}

		return returnResult;
	}

}
