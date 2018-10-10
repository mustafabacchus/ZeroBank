package com.was.qa.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.was.qa.base.TestBase;
import com.was.qa.util.TestUtil;

public class DbCitiesTest extends TestBase {

	public static void main(String[] args) throws SQLException {
		//TestUtil util = null;
		
		TestUtil.establishDbConnection();
		TestUtil.smt = TestUtil.conn.createStatement();
		TestUtil.result = TestUtil.smt.executeQuery("select * from city");
		
		while (TestUtil.result.next()) {
			String cityname = TestUtil.result.getString("Name");
			System.out.println(cityname);
		}
		
		TestUtil.terminateDbConnection();
	}

}
