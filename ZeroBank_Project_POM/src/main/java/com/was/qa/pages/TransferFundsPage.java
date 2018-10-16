package com.was.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	WebElement continueBtn;
	
	//cancel button
	@FindBy(id="btn_cancel")
	WebElement cancelBtn;

	public TransferFundsPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public String validateTransferFundsPage() {
		return driver.getTitle();
	}
	
	public void selectFromAccount(int value) {
		new Select(fromActDropDown).selectByValue(Integer.toString(value));
	}
	
	public void selectToAccount(int value) {
		new Select(toActDropDown).selectByValue(Integer.toString(value));
		
	}

	public void enterAmount(double value) {
		amtField.clear();
		amtField.sendKeys(Double.toString(value));
	}
	
	public void enterDescription(String value) {
		descriptField.clear();
		descriptField.sendKeys(value);
	}
	
	public void clickContinue() {
		continueBtn.click();
	}
	
	public boolean validateTransfer(int from, int to, double transAmount, String description) {
		selectFromAccount(from);
		String fromSel = new Select(fromActDropDown).getFirstSelectedOption().getText();
		// get from account type
		String fromAcc = fromSel.substring(0, fromSel.indexOf('(')).replaceAll(" ", "");
		//get from account amount
		double fromAmt = Double.parseDouble(fromSel.substring(fromSel.indexOf('$') + 2, fromSel.indexOf(')')));
		System.out.println(fromAcc + ": " + fromAmt);
		
		selectToAccount(to);
		String toSel = new Select(toActDropDown).getFirstSelectedOption().getText();
		//get to account type
		String toAcc = toSel.substring(0, toSel.indexOf('(')).replaceAll(" ", "");
		//get to account amount
		double toAmt = Double.parseDouble(toSel.substring(toSel.indexOf('$')+  2, toSel.indexOf(')')));
		System.out.println(toAcc + ": " + toAmt);
		
		enterAmount(transAmount);
		enterDescription(description);
		clickContinue();
		
		if ((fromAcc.equals(toAcc)) && cancelBtn.isDisplayed()) { 
			System.out.println("Can not make transfer from " + fromAcc + " to " + toAcc + "." ); 
			return false;
		}
		if ((fromAmt <= transAmount) && cancelBtn.isDisplayed()) {
			System.out.println("Insufficient funds.");
			return false;
		}
		return true;
	}  

}
