package com.was.qa.testcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;
import com.was.qa.pages.MainPage;
import com.was.qa.pages.TransferFundsPage;

public class TransferFundsPageTest extends TestBase{
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	TransferFundsPage tnfrFundsPage;
	
	public TransferFundsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		mainPage =  new MainPage();
		loginPage= mainPage.navigateToLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		tnfrFundsPage = homePage.clickTransferFundsTab();
			
		
	}
	
	@Test(priority=1)
	public void transferFundsPageTitleTest() {
		String title = tnfrFundsPage.validateTransferFundsPage();
		Assert.assertEquals(title,"Zero - Transfer Funds");
	}
	
	@Test(priority=2)
	public void validateTransferTest() {
		tnfrFundsPage.validateTransfer(new Select(tnfrFundsPage.getTransferFromAccount()), 
				new Select(tnfrFundsPage.getTransferToAccount()));
	}
	
	
	@AfterMethod
	public void cleanUp() {
		driver.close();
		driver.quit();
	}
}
