package com.was.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;
import com.was.qa.pages.MainPage;

public class LoginPageTest extends TestBase{
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization(); 
		mainPage = new MainPage();
		loginPage = mainPage.navigateToLoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Zero - Log in");
		
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
	
	
}
