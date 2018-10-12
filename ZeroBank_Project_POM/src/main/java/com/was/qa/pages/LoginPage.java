package com.was.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.was.qa.pages.HomePage;
import com.was.qa.base.TestBase;

public class LoginPage extends TestBase{
		
	//user name text input box
	@FindBy(id="user_login")
	WebElement usrNameBox;
	
	//password text input box
	@FindBy(id="user_password")
	WebElement pwdBox;
	
	//keep me signed in check box
	@FindBy(id="user_remember_me")
	WebElement remCheckBox;
	
	//sign in button
	@FindBy(name="submit")
	WebElement signInBtn;

	//constructor
	public LoginPage() {
		//Initializing the Page Objects
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateLoginPageTitle() { 
		return driver.getTitle();
	}
	
	public HomePage login(String usr, String pwd){
		usrNameBox.clear();
		usrNameBox.sendKeys(usr);
		pwdBox.clear();
		pwdBox.sendKeys(pwd);
		signInBtn.click();
		//user is navigated to home page after login
		return new HomePage();
	}
	
	
	
	
}
