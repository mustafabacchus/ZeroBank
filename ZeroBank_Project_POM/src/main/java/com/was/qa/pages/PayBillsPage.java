package com.was.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.was.qa.base.TestBase;

public class PayBillsPage extends TestBase {
	
	@FindBy(linkText = "a.Pay Bills")
	WebElement payBill;
	
	@FindBy(linkText = "Pay Saved Payee")
	WebElement paysavepayee;
	
	@FindBy(xpath = "//*[@id= 'sp_payee']")
	WebElement payee;
	
	@FindBy(xpath = "//*[@id= 'sp_account']")
	WebElement account;
	
	@FindBy(css = "input.sp_amount")
	WebElement amount;
	
	@FindBy(css = "input.sp_date")
	WebElement date;
	
	@FindBy(css = "input.sp_description")
	WebElement description;
	
	@FindBy(css = "input.pay_saved_payees")
	WebElement save_payee;
	
	@FindBy(linkText = "a.Add New Payee")
	WebElement new_pay;
		
	@FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[3]/a")
	WebElement purForCurrTab;
	
	@FindBy(id="pc_currency")
	WebElement currDropDown;
		
	@FindBy(id="pc_amount")
	WebElement amtForCurr;
	
	@FindBy(id="sp_sell_rate")
	WebElement sellRate;
	

	
	public PayBillsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePayBillPageTitle() {
		return driver.getTitle();
	}
	
	public WebElement getPurForCurrTab() {
		return purForCurrTab;
	}
	
	public boolean isValidConversion(String curType) throws InterruptedException {
		purForCurrTab.click();
		new Select(currDropDown).selectByVisibleText(curType);
		if (curType=="Select One")
			return false;
		
		for(int i=2; i<8; i++) {
			new Select (currDropDown).selectByIndex(i);
			String sr = sellRate.getText();
//			System.out.println(sr);
			String usDolPer1For = sr.substring(sr.indexOf('='), sr.indexOf('U'));
			System.out.println(usDolPer1For);
			Thread.sleep(300);
		}
		
//		String sr = sellRate.getText();
//		
//		System.out.println("Before");
//		System.out.println(sr);
//		System.out.println("After");
		
		return true;//remove later
	}
}
