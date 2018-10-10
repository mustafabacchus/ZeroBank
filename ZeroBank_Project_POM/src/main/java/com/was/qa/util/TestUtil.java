package com.was.qa.util;

import static org.testng.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.was.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() {
		super();
	}
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	
	
	//Database connection
	public static Connection conn;
	public static Statement smt = null;
	public static ResultSet result = null; 
	
	public static void establishDbConnection() {
		//Load driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver loaded.");
		
		//Connect to database
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://db4free.net:3306/gts_db01", prop.getProperty("dbuser"), "11@one@11");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection successful.");
	}
	
	public static void terminateDbConnection() throws SQLException {
		if (conn != null){
			try {
				conn.close();
				System.out.println("Connection closed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
