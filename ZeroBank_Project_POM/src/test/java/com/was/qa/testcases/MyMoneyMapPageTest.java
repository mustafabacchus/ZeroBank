package com.was.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;
import com.was.qa.pages.MainPage;
import com.was.qa.pages.MyMoneyMapPage;

public class MyMoneyMapPageTest extends TestBase{
	LoginPage loginPage;
	MainPage mainPage;
	HomePage homePage;
	MyMoneyMapPage myMoneyMapPage;
	
	public MyMoneyMapPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization(); //set up driver and what not
		//create instance of LoginPage object
//		myMoneyMapPage = new MyMoneyMapPage();
//		loginPage = new LoginPage();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		driver.navigate().to("http://zero.webappsecurity.com/bank/money-map.html");
		mainPage = new MainPage();
		loginPage = mainPage.navigateToLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));//should land on home page at this point
		myMoneyMapPage = homePage.clickMyMoneyMapTab();//works here!
	}
	
	@Test(priority=1)
	public void test1() throws InterruptedException {
		
//		myMoneyMapPage.pieChartVisibility();
//		myMoneyMapPage.checkDoubleAscDesc("DESC");
//		myMoneyMapPage.checkAlphaAscDesc("DESC");
		myMoneyMapPage.findPieSlicesAndHover();
		
		
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
