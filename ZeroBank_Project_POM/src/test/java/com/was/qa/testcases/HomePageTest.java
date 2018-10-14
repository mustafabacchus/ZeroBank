package com.was.qa.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;
import com.was.qa.pages.MainPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	MainPage mainPage;
	LoginPage loginPage;
	
	public  HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		mainPage = new MainPage();
		loginPage = mainPage.navigateToLoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//should land on home page at this point
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title  = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Zero - Account Summary");
	}
	
	@Test(priority=2)
	public void contextClickEnglishTranslationTest() {
		homePage.clickTermsOfUse();
	}
	

	
	@Test(priority=3)
	public void ctrlADeleteTest() throws InterruptedException {
		homePage.enterTextInSearchBar("To be deleted by pressing Ctrl A");
		Thread.sleep(3000);
		WebElement srchBar = homePage.getSearchBar();
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		Thread.sleep(3000);
		Assert.assertEquals("",srchBar.getText());
		
	}

	
	@Test(priority=4)
	public void selectHelpTest() throws InterruptedException {
		homePage.getSettingsDropDown().click();
		Thread.sleep(3000);
		homePage.getHelpLink().click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "Zero - Help");
	}

	//FIX
//	@Test(priority=6)
//	public void dragLogoToSearchBarTest() {
//		WebElement logo = homePage.getZeroBankLogoBtn();
//		WebElement sBar = homePage.getSearchBar();
//		homePage.dragAndDrop(logo, sBar);
//		String sbText = sBar.getText();
//		Assert.assertEquals(sbText, "http://zero.webappsecurity.com/index.html");
//	}
	
//FIX
//	@Test(priority=7)
//	public void validateUserTest() {
//		String username = homePage.getUserName();
//		Assert.assertEquals(username, prop.getProperty("username"));
//	}
	
	@AfterMethod
	public void cleanUp() {
		driver.close();
		driver.quit();
	}
	
}
