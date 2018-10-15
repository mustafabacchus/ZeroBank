package com.was.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;
import com.was.qa.pages.MainPage;
import com.was.qa.pages.PayBillsPage;

import junit.framework.Assert;

public class PayBillsPageTest extends TestBase {
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	PayBillsPage payBillsPage;
	
	public PayBillsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		mainPage =  new MainPage();
		loginPage= mainPage.navigateToLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		payBillsPage = homePage.clickPayBillsTab();
	}
	
	@Test(priority=1)
	public void payBillsPageTitleTest() {
		String title = payBillsPage.validatePayBillPageTitle();
		Assert.assertEquals("Zero - Pay Bills", title);
	}
	
//	@Test(priority=2)
//	public void currencyConversionTest() throws InterruptedException {
//		
//		System.out.println(payBillsPage.isValidConversion("Sweden (krona)"));
//		Thread.sleep(10000); //remove
//	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
}
