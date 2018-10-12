package com.was.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.was.qa.base.TestBase;

public class HomePage extends TestBase{
	//add some locators here!
	
	//download web inspect link
	@FindBy(id="download_webinspect_link")
	WebElement dWebInspecLink;

	//terms of use link
	@FindBy(id="terms_of_use_link")
	WebElement termsUseLink;
	
	//contact micro focus link
	@FindBy(id="contact_hp_link")
	WebElement contactMF;
	
	//privacy statement link
	@FindBy(id="privacy_statement_link")
	WebElement pStmtLink;
	
	//Account Activity Tab
	@FindBy(xpath="//li[@id='account_activity_tab']/a")
	WebElement accountActivityTab;
	
	//Transfer Funds		
	@FindBy(xpath="//li[@id='transfer_funds_tab']/a")
	WebElement transferFundsTab;
	
	//Pay Bills
	@FindBy(xpath="//li[@id='pay_bills_tab']/a")
	WebElement payBillsTab;	
		
	//My Money Map Tab
	@FindBy(xpath="//li[@id='money_map_tab']/a")
	WebElement myMoneyMapTab;
	
	//Online Statements
	@FindBy(xpath="//li[@id='online_statements_tab']/a")
	WebElement onlineStatementsTab;	
		
	//search bar
	@FindBy(id="searchTerm")
	WebElement searchBar;
	
	//settings drop down
	@FindBy(className = "dropdown-toggle")
	WebElement settingsDropDown;
	
	//help link
	@FindBy(id="help_link")
	WebElement helpLink;
	
	//zero bank logo button
	@FindBy(xpath="//a[text()='Zero Bank']")
	WebElement zBLogoBtn;
	
	//displayed username
	@FindBy(xpath="//*[contains(@class, 'dropdown-toggle')][1]")
	WebElement userToggle;
	
	////*[@id="settingsBox"]/ul/li[3]/a/text()
	
	////*[contains(@class, 'dropdown-toggle')][2]
		
	//constructor
	public HomePage() {
		//Initializing the Page Objects
		PageFactory.initElements(driver, this);		
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	//----------------------click on link methods----------------
	public void clickWebInspectElement() {
		dWebInspecLink.click();
	}
	
	public void clickTermsOfUse() {
		termsUseLink.click();
	}
	
	public void clickContactMicroFocus() {
		contactMF.click();
	}
	
	public void clickPrivacyStatement() {
		pStmtLink.click();
	}
	
	//-----------------------click on tab actions-----------------
	public AccountActivityPage clickAccountActivityTab() {
		accountActivityTab.click();
		return new AccountActivityPage();
	}
	
	public TransferFundsPage clickTransferFundsTab() {
		transferFundsTab.click();
		return new TransferFundsPage();
	}	
	
	public PayBillsPage clickPayBillsTab() {
		payBillsTab.click();
		return new PayBillsPage();
	}

	public MyMoneyMapPage clickMyMoneyMapTab() {
		myMoneyMapTab.click();
		return new MyMoneyMapPage();
	}
	
	public OnlineStatementsPage clickOnlineStatementsTab() {
		onlineStatementsTab.click();
		return new OnlineStatementsPage();
	}
	
	//------------------------------------------------------------
	public void enterTextInSearchBar(String str) {
		searchBar.clear();
		searchBar.sendKeys(str);
	}
	
	public WebElement getSearchBar() {
		return searchBar;
	}
	
	public WebElement getSettingsDropDown() {
		return settingsDropDown;
	}
	
	public WebElement getHelpLink() {
		return helpLink;
	}
	
	public WebElement getZeroBankLogoBtn() {
		return zBLogoBtn;
	}
	
	public void dragAndDrop(WebElement source, WebElement target) {
//		act.dragAndDrop(source, target).build().perform();
//		act.clickAndHold(source).moveToElement(target).release().build().perform();
		act.clickAndHold(source );
		act.moveToElement(target );
		act.release(source );
		act.moveByOffset(0, 5);
		act.build().perform();

	}
	
	public String getUserName() {
//		String username = "";
		return userToggle.getText();
//		return username;
	}

}
