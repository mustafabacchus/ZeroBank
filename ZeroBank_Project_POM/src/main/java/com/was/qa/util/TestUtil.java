package com.was.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.was.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	
	
	//Database connection
	public static Connection conn;
	public static Statement smt = null;
	public static ResultSet result = null; 
	
	public static void establishDbConnection() throws IOException {
		//Load driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver loaded.");
		
		//load properties file
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir") +
				"\\src\\main\\java\\com\\was\\qa\\config\\config.properties");
		prop.load(fin);
		
		//Connect to database
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://" + prop.getProperty("dbhost") + ":" + 
							prop.getProperty("port") + "/" + prop.getProperty("dbname"), 
							prop.getProperty("dbuser"), prop.getProperty("dbpass"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection established.");
	}
	
	//Close database connection
	public static void terminateDbConnection() throws SQLException {
		if (conn != null){
			try {
				conn.close();
				System.out.println("Connection terminated.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
