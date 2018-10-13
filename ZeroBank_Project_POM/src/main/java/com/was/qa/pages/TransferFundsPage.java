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
	
	//amount field
	@FindBy(id="tf_amount")
	WebElement amtField;
	
	//description field
	@FindBy(id="tf_description")
	WebElement descriptField;
	
	//submit button
	@FindBy(id="btn_submit")
	WebElement submitBtn;
	
	
	public TransferFundsPage() {
		super();
	}
	
	public void setUp() throws InterruptedException {
		PageFactory.initElements(driver, this);		
	}
	
	public String validateTransferFundsPage() {
		return driver.getTitle();
	}
	
	public void selectFromAccount(int value) {
		new Select(fromActDropDown).selectByIndex(value);
	}
	
	public void selectToAccoutn(int value) {
		new Select(toActDropDown).selectByIndex(value);
	}

	public void enterAmount(String value) {
		amtField.clear();
		amtField.sendKeys(value);
	}
	
	public void enterDescription(String value) {
		descriptField.clear();
		descriptField.sendKeys(value);
	}
	
	public void clickSubmit() {
		submitBtn.click();
	}
	
	public boolean validateTransfer(int to, int from) {
		return false;//remove later
	}

}
