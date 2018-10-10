package com.was.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;
import com.was.qa.pages.MyMoneyMapPage;

public class MyMoneyMapPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	MyMoneyMapPage myMoneyMapPage;
	
	public MyMoneyMapPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(); //set up driver and what not
		//create instance of LoginPage object
		myMoneyMapPage = new MyMoneyMapPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.navigate().to("http://zero.webappsecurity.com/bank/money-map.html");
	}
	
	@Test(priority=1)
	public void test1() throws InterruptedException {
		
//		myMoneyMapPage.pieChartVisibility();
//		myMoneyMapPage.hoverPie();
		myMoneyMapPage.checkAlphaAscDesc("DESC");
		
	}
	
//	@Test(priority=2)
//	public void loginTest() {
//
//	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
}
