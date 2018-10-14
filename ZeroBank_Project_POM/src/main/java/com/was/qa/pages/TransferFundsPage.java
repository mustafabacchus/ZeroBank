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
	public WebElement fromActDropDown;

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
	

	public void setUp() throws InterruptedException {
		PageFactory.initElements(driver, this);		
	}
	
	public String validateTransferFundsPage() {
		return driver.getTitle();
	}
	
	public void selectFromAccount(int value) {
		WebElement fromActDropDown = driver.findElement(By.id("tf_fromAccountId"));
		new Select(fromActDropDown).selectByValue(Integer.toString(value));
	}
	
	public void selectToAccount(int value) {
		WebElement toActDropDown = driver.findElement(By.id("tf_toAccountId"));
		new Select(toActDropDown).selectByValue(Integer.toString(value));
	}

	public void enterAmount(long value) {
		WebElement amtField = driver.findElement(By.id("tf_amount"));
		amtField.clear();
		amtField.sendKeys(Long.toString(value));
	}
	
	public void enterDescription(String value) {
		WebElement descriptField = driver.findElement(By.id("tf_description"));
		descriptField.clear();
		descriptField.sendKeys(value);
	}
	
	public void clickContinue() {
		WebElement continueBtn = driver.findElement(By.id("btn_submit"));
		continueBtn.click();
	}
	
	public void validateTransfer(int from, int to, long amount, String description) {
		selectFromAccount(from);
		selectToAccount(to);
		enterAmount(amount);
		enterDescription(description);
		clickContinue();
		//return false;
	}

}
