package com.was.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.was.qa.base.TestBase;

public class HomePage extends TestBase{
	//add some locators here!
	
	//download web inspect link
	@FindBy(id="download_webinspect_link")
	WebElement dWebInspecLink;
	//use switch to for using another tab
	
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
