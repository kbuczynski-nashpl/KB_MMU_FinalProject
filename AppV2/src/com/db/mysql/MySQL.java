package com.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySQL {

	private final String mysqlAddress = "localhost";
	private final String mysqlDataBase = "CRM";
	private final String mysqlUserName = "root";
	private final String mysqlPsw = "admin";

	private Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	protected void createConnection() {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName).newInstance();
			String url = "jdbc:mysql://" + this.mysqlAddress + "/" + this.mysqlDataBase;
			this.con = DriverManager.getConnection(url, this.mysqlUserName, this.mysqlPsw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HashMap> query(String query) {
		createConnection();
		ArrayList<HashMap> resultSet = new ArrayList();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			List<String> columnsList = new ArrayList<String>(rsmd.getColumnCount());
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				columnsList.add(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				HashMap<String, String> newEntry = new HashMap<String, String>();
				for (String col : columnsList) {
					newEntry.put(col, rs.getString(col));
					resultSet.add(newEntry);
				}
			}
		} catch (SQLException e) {
			// handle any errors
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} finally {
			closeConnection();
		}
		return resultSet;

	}

	public Connection getConnection() {
		return this.con;
	}

	public String dataBaseConnectionInfo() {
		return "Address: " + this.mysqlAddress + " Database: " + this.mysqlDataBase;
	}

	protected void closeConnection() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException sqlEx) {
			} // ignore
			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
			} // ignore
			stmt = null;
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException sqlEx) {
			} // ignore
			con = null;
		}
	}
}
