package com.was.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;
import com.was.qa.pages.MainPage;
import com.was.qa.pages.TransferFundsPage;

public class TransferFundsPageTest extends TestBase {
	LoginPage loginPage;
	MainPage mainPage;
	HomePage homePage;
	TransferFundsPage tnfrFundsPage;
	
	public TransferFundsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization(); //set up driver and what not
		mainPage = new MainPage();
		loginPage = mainPage.navigateToLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));//should land on home page at this point
		tnfrFundsPage = homePage.clickTransferFundsTab();
	}
	
	@Test(priority=1)
	public void transferFundsPageTitleTest() {
		String title = tnfrFundsPage.validateTransferFundsPage();
		Assert.assertEquals(title,"Zero - Transfer Funds");
	}
	
	
	@Test(priority=2)
	public void insuffcientFundsTest() {
		Assert.assertTrue(tnfrFundsPage.validateTransfer(1, 2, 1500.89, "test transfer"));
	}
	
	@Test(priority=-1000)
	public void accountTransferToSameAccountTest() {
		Assert.assertTrue(tnfrFundsPage.validateTransfer(1, 1, 400, ""));
	}
	
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
}
