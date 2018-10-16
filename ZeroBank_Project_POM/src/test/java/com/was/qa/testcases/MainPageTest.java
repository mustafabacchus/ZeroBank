package com.was.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.MainPage;

public class MainPageTest extends TestBase {
	public static MainPage mainPage;
	
	public MainPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		mainPage = new MainPage();
	}
	
	@Test(priority=1)
	public void mainPageTitleTest() {
		String title = mainPage.validateMainPageTitle();
		Assert.assertEquals(title, "Zero - Personal Banking - Loans - Credit Cards");
		
	}
	
	@Test(priority=2)
	public void zeroBankLogoTest() {
		boolean flag = mainPage.validateZeroBankLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void navigateToLoginPageTest() throws InterruptedException {
 		mainPage.clickSignIn();
		Thread.sleep(3000);
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Zero - Log in");
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.close();
		driver.quit();
	}
	
}
