package com.was.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;
import com.was.qa.pages.HomePage;
import com.was.qa.pages.LoginPage;
import com.was.qa.pages.MainPage;
import com.was.qa.pages.MyMoneyMapPage;

public class MyMoneyMapPageTest extends TestBase{
	LoginPage loginPage;
	MainPage mainPage;
	HomePage homePage;
	MyMoneyMapPage myMoneyMapPage;
	
	public MyMoneyMapPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization(); //set up driver and what not
		//create instance of LoginPage object
//		myMoneyMapPage = new MyMoneyMapPage();
//		loginPage = new LoginPage();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		driver.navigate().to("http://zero.webappsecurity.com/bank/money-map.html");
		mainPage = new MainPage();
		loginPage = mainPage.navigateToLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));//should land on home page at this point
		myMoneyMapPage = homePage.clickMyMoneyMapTab();//works here!
	}
	
	@Test(priority=1)
	public void test1() throws InterruptedException {
		
//		myMoneyMapPage.pieChartVisibility();

		myMoneyMapPage.pieHover();
		
		System.out.println("\nNow running addsUp");
		System.out.println("---------------------------------");
		System.out.println("Adds Up = " + myMoneyMapPage.addsUp());
		System.out.println("---------------------------------------------------------------\n");
		
		
		System.out.println("\nNow running findCategoryNames with 'DESC'");
		System.out.println("---------------------------------");
		System.out.println("Sorted Correctly = " + myMoneyMapPage.checkAlphaAscDesc(myMoneyMapPage.findCategoryNames(),"DESC"));
		System.out.println("Same Category Coulumn and PieLabel = " + 
				myMoneyMapPage.sameColAndLabel(myMoneyMapPage.findCategoryNames(), myMoneyMapPage.getPieSlicesText()));
		System.out.println("---------------------------------------------------------------\n");
		
		myMoneyMapPage.reverseCategoryOrder();
		
		System.out.println("\nNow running checkAlphaAscDesc with 'ASC'");
		System.out.println("---------------------------------");
		System.out.println("Sorted Correctly = " + myMoneyMapPage.checkAlphaAscDesc(myMoneyMapPage.findCategoryNames(),"ASC"));

		System.out.println("Same Category Coulumn and PieLabel = " + 
				myMoneyMapPage.sameColAndLabel(myMoneyMapPage.findCategoryNames(), myMoneyMapPage.getPieSlicesText()));
		System.out.println("---------------------------------------------------------------\n");
		
		myMoneyMapPage.reverseCategoryOrder();
		
		System.out.println("\nNow running checkAlphaAscDesc with 'DESC'");
		System.out.println("---------------------------------");
		System.out.println("Sorted Correctly = " + myMoneyMapPage.checkAlphaAscDesc(myMoneyMapPage.findCategoryNames(),"DESC"));
		System.out.println("Same Category Coulumn and PieLabel = " + 
				myMoneyMapPage.sameColAndLabel(myMoneyMapPage.findCategoryNames(), myMoneyMapPage.getPieSlicesText()));
		System.out.println("---------------------------------------------------------------\n");
		
		
		
		myMoneyMapPage.reverseMoneyOrder();
		
		System.out.println("\nNow running checkDoubleAscDesc with 'DESC'");
		System.out.println("---------------------------------");
		System.out.println("Sorted Correctly = " + myMoneyMapPage.checkDoubleAscDesc(myMoneyMapPage.findMoneyValues(),"DESC"));
		System.out.println("Same Category Coulumn and PieLabel = " + 
				myMoneyMapPage.sameColAndLabel(myMoneyMapPage.findCategoryNames(), myMoneyMapPage.getPieSlicesText()));
		System.out.println("---------------------------------------------------------------\n");
		
		myMoneyMapPage.reverseMoneyOrder();
		
		System.out.println("\nNow running checkDoubleAscDesc with 'ASC'");
		System.out.println("---------------------------------");
		System.out.println("Sorted Correctly = " + myMoneyMapPage.checkDoubleAscDesc(myMoneyMapPage.findMoneyValues(),"ASC"));
		System.out.println("Same Category Coulumn and PieLabel = " + 
				myMoneyMapPage.sameColAndLabel(myMoneyMapPage.findCategoryNames(), myMoneyMapPage.getPieSlicesText()));
		System.out.println("---------------------------------------------------------------\n");

	}
	
//	@Test(priority=2)
//	public void loginTest() {
//
//	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
}
