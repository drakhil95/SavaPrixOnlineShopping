package com.savaprix.ecom.databaseutility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
import com.savaprix.ecom.fileutility.FileUtility;

public class DatabasseUtility {
	Connection conn;
	FileUtility fU = new FileUtility();
	
	public void getDBConnection() throws SQLException, IOException {
		String dbUrl = fU.getDataFromPropertyFile("dbUrl");
		String dbUn = fU.getDataFromPropertyFile("dbUn");
		String dbPw = fU.getDataFromPropertyFile("dbPw");
		
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		conn = DriverManager.getConnection(dbUrl, dbUn, dbPw);
	}
	
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
		Statement stat = conn.createStatement();
		ResultSet res = stat.executeQuery(query);
		return res;
		
	}
	
	public int executeNonSelectQuery(String query) throws SQLException {
		int res = 0;
		try {
			Statement stat = conn.createStatement();
			res = stat.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("Error occured while executing the non select Query");
		}
		return res;
	}
	
	public void disconnectDb() throws SQLException {
		conn.close();
	}
}
