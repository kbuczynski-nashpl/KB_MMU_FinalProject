package com.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.crm.utils.ApplicationErrorLoging;

public class MySQL {

	private final static String mysqlAddress = "167.99.202.160";
	private final static String mysqlDataBase = "CRM";
	private final static String mysqlUserName = "webkbCRM";
	private final static String mysqlPsw = "bpKD3YWCD6rfjKu";

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;

	private static void createConnection() {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName).newInstance();
			String url = "jdbc:mysql://" + mysqlAddress + "/" + mysqlDataBase;
			con = DriverManager.getConnection(url, mysqlUserName, mysqlPsw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<HashMap<String, String>> query(String query) {
		createConnection();
		ArrayList<HashMap<String, String>> resultSet = new ArrayList<HashMap<String, String>>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			List<String> columnsList = new ArrayList<String>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				columnsList.add(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				HashMap<String, String> newEntry = new HashMap<String, String>();
				for (String col : columnsList) {
					newEntry.put(col, rs.getString(col));
				}
				resultSet.add(newEntry);
			}
		} catch (SQLException e) {
			ApplicationErrorLoging.log("MySQLDriver", e);
		} finally {
			closeConnection();
		}
		return resultSet;

	}

	public static HashMap<String, String> update(String query) {
		createConnection();
		HashMap<String, String> response = new HashMap<String, String>();
		Integer generatedId = 0;
		try {
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				generatedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			ApplicationErrorLoging.log("MySQLDriver", e);

			// Put response so we can notify user the request could not be saved.
			response.put("STATUS", "ERROR");
		} finally {
			closeConnection();
		}
		response.put("STATUS", "OK");
		response.put("GEN_ID", generatedId.toString());

		return response;
	}

	public static Connection getConnection() {
		return con;
	}

	public static String dataBaseConnectionInfo() {
		return "Address: " + mysqlAddress + " Database: " + mysqlDataBase;
	}

	private static void closeConnection() {

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
