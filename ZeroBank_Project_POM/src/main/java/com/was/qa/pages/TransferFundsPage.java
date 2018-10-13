package com.was.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.was.qa.base.TestBase;

public class TransferFundsPage extends TestBase {

	//locators
	
	//from account drop down
	@FindBy(id="tf_fromAccountId")
	WebElement fromActDropDown;

	//to account drop down
	@FindBy(id="tf_toAccountId")
	WebElement toActDropDown;
	
	
	public TransferFundsPage() {
		super();
	}
	
	public void setUp() throws InterruptedException {
		PageFactory.initElements(driver, this);		
	}
	
	
	
	public String validateTransferFundsPage() {
		return driver.getTitle();
	}
	
	public boolean validateTransfer(Select d1, Select d2) {
		
		return false;//remove later
	}

	//---------------------getters--------------------------------
	public WebElement getTransferFromAccount() {
		return fromActDropDown;
	}

	public WebElement getTransferToAccount() {
		return toActDropDown;
	}	

}
