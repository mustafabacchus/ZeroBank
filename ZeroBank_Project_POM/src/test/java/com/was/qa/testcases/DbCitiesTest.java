package com.was.qa.testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.was.qa.base.TestBase;
import com.was.qa.util.TestUtil;

public class DbCitiesTest extends TestBase {

	public static void main(String[] args) throws SQLException, IOException {
		
		/* ##### Due to special charcter limitaions, actual results are stored and read from a csv file rather
		than directly from the database. ##### */
		
		//Primary directory and files
		String workingDirectory = "\\src\\main\\java\\com\\was\\qa\\testdata";
		String actualResultFile = "actual-cities.csv";
		String expectedResultFile = "expected-cities.csv";
		
		
		
		//Create a database connection
		TestUtil.establishDbConnection();
		
		//Execute query
		TestUtil.smt = TestUtil.conn.createStatement();
		TestUtil.result = TestUtil.smt.executeQuery("select * from city");
		
		//Path for storing actual results
		FileOutputStream fout =  new FileOutputStream(System.getProperty("user.dir") + 
				workingDirectory + "\\" + actualResultFile);
		OutputStreamWriter ow = new OutputStreamWriter(fout);
		BufferedWriter bw = new BufferedWriter(ow);
		
		//Write each instance to the file
		while (TestUtil.result.next()) {
			String cityname = TestUtil.result.getString("Name");
			bw.write(cityname + "\n");
		}
		
		//Close buffer writer
		bw.close();
		System.out.println("Actual result appended.");
		//Close databse connection
		TestUtil.terminateDbConnection();
		System.out.println();
		
		
		
		//Path for reading expected results
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + 
				workingDirectory + "\\" + expectedResultFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fin));
		List<String> expected = new ArrayList<String>();
		String row = "";
		//Append each row to a expected list
		while ((row = br.readLine()) != null) {
			expected.add(row);
		}
		br.close();
		
		//Path for reading actual results
		fin = new FileInputStream(System.getProperty("user.dir") + 
				workingDirectory + "\\" + actualResultFile);
		br = new BufferedReader(new InputStreamReader(fin));
		List<String> actual = new ArrayList<String>();
		row = "";
		//Append each row to actual list
		while ((row = br.readLine()) != null) {
			actual.add(row);
		}
		br.close();
		
		
		
		//Compare actual vs. expected
		String failed = "";
		if (actual.size() == expected.size()) {
			for (int i = 0; i < actual.size(); i++) {
				String a = actual.get(i);
				String e = expected.get(i);
				//Store specfic mismatched values
				if (!a.equals(e)) {
					failed += a + "\n" + e + "\n\n";
				}
			}
		}
		
		//Display final result
		if (failed.equals("")) {
			System.out.println("######PASSED!######");
		} else {
			System.out.println("######FALIED!######");
			System.out.println(failed);
		}
		
		
		
		//Reset test case
		//Delete actual results
		new File(System.getProperty("user.dir") + 
				workingDirectory + "\\" + actualResultFile).delete();
		System.out.println();
		System.out.println("Test case purged.");
		
	}

}
