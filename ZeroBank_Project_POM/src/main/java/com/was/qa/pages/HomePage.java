package com.was.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.was.qa.base.TestBase;

public class HomePage extends TestBase{
	//add some locators here!
	
	//constructor
	public HomePage() {
		//Initializing the Page Objects
		PageFactory.initElements(driver, this);		
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	//add some actions here!
}
