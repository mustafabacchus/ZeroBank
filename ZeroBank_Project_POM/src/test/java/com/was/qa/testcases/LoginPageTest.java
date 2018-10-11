package com.was.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization(); //set up driver and what not
		//create instance of LoginPage object
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		//explain or know exactly what assert does
		Assert.assertEquals(title, "Zero - Log in");
	}
	
	@Test(priority=2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void cleanUp() {
		//add take screenshotmethod(in test utils)
		driver.quit();
	}
	
	
}
