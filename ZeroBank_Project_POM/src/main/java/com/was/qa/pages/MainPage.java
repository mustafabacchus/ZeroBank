package com.was.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.was.qa.base.TestBase;

public class MainPage extends TestBase {
	
	//login link button
	@FindBy(id="signin_button")
	WebElement loginLinkBtn;
	
	//search bar
	@FindBy(id="searchTerm")
	WebElement searchBar;
	
	//logo as link
	@FindBy(xpath="//a[contains(@class,'brand')]")
	WebElement logoLink;
	
	//constructor
	public MainPage() {
		//Initializing the Page Objects
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateMainPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateZeroBankLogo() {
		return logoLink.isDisplayed();
	}
	
	public LoginPage navigateToLoginPage() throws InterruptedException {
		clickSignIn();
		Thread.sleep(3000);
		return new LoginPage();
	}
	
	public void clickSignIn() {
		loginLinkBtn.click();
	}
	
}
