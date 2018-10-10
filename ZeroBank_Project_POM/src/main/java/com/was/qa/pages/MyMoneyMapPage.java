package com.was.qa.pages;

import org.testng.Assert;


import java.text.NumberFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;

public class MyMoneyMapPage extends TestBase{
	
	//LOCATORS

	
	//Auto
	@FindBy(xpath="//tspan[contains(text(),'Auto')][1]")
	WebElement autoLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Auto')][2]")
	WebElement autoToggle;
	
	//Charity
	@FindBy(xpath="//tspan[contains(text(),'Charity')][1]")
	WebElement charityLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Charity')][2]")
	WebElement charityToggle;
	
	//Checks Written
	@FindBy(xpath="//tspan[contains(text(),'Checks Written')][1]")
	WebElement checksWrittenLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Checks Written')][2]")
	WebElement checksWrittenToggle;
	
	//Retail
	@FindBy(xpath="//tspan[contains(text(),'Retail')][1]")
	WebElement retailLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Retail')][2]")
	WebElement retailToggle;
	
	//Household
	@FindBy(xpath="//tspan[contains(text(),'Household')][1]")
	WebElement householdLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Household')][2]")
	WebElement householdToggle;
	
	//Insurance
	@FindBy(xpath="//tspan[contains(text(),'Insurance')][1]")
	WebElement insuranceLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Insurance')][2]")
	WebElement insuranceToggle;
	
	//Office Supply
	@FindBy(xpath="//tspan[contains(text(),'')][1]")
	WebElement officeSupplyLabel;
	@FindBy(xpath = "//tspan[contains(text(),'')][2]")
	WebElement officeSupplyToggle;
	
	//Restaurants
	@FindBy(xpath="//tspan[contains(text(),'Restaurants')][1]")
	WebElement restaurantsLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Restaurants')][2]")
	WebElement restaurantsToggle;
	
	//Telecom
	@FindBy(xpath="//tspan[contains(text(),'Telecom')][1]")
	WebElement telecomLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Telecom')][2]")
	WebElement telecomToggle;
	
	//Transportation
	@FindBy(xpath="//tspan[contains(text(),'Transportation')][1]")
	WebElement transportationLabel;
	@FindBy(xpath = "//tspan[contains(text(),'Transportation')][2]")
	WebElement transportationToggle;
	
	
	//--------------------------------------------------------------------------
	//Subject: Spendings First Col (Category Names)
	//--------------------------------------------------------------------------
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[2]/td[1]/div")
	WebElement subjectSpendingsRow1Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[3]/td[1]/div")
	WebElement subjectSpendingsRow2Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[4]/td[1]/div")
	WebElement subjectSpendingsRow3Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[5]/td[1]/div")
	WebElement subjectSpendingsRow4Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[6]/td[1]/div")
	WebElement subjectSpendingsRow5Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[7]/td[1]/div")
	WebElement subjectSpendingsRow6Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[8]/td[1]/div")
	WebElement subjectSpendingsRow7Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[9]/td[1]/div")
	WebElement subjectSpendingsRow8Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[10]/td[1]/div")
	WebElement subjectSpendingsRow9Col1;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[11]/td[1]/div")
	WebElement subjectSpendingsRow10Col1;
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	//Subject: Spendings Second Col (Money Value Per Category)
	//--------------------------------------------------------------------------
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[2]/td[2]/div")
	WebElement subjectSpendingsRow1Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[3]/td[2]/div")
	WebElement subjectSpendingsRow2Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[4]/td[2]/div")
	WebElement subjectSpendingsRow3Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[5]/td[2]/div")
	WebElement subjectSpendingsRow4Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[6]/td[2]/div")
	WebElement subjectSpendingsRow5Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[7]/td[2]/div")
	WebElement subjectSpendingsRow6Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[8]/td[2]/div")
	WebElement subjectSpendingsRow7Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[9]/td[2]/div")
	WebElement subjectSpendingsRow8Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[10]/td[2]/div")
	WebElement subjectSpendingsRow9Col2;
	@FindBy(xpath = "//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[11]/td[2]/div")
	WebElement subjectSpendingsRow10Col2;
	//--------------------------------------------------------------------------
	
	

	
	public MyMoneyMapPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	//actions
	
	public String[] findPieSlicesAndHover() throws InterruptedException {//Works
		WebElement[] slicesArr = new WebElement[10];
		String[] slicesArrText = new String[10];
		int sliceId = 1271;
		for(int i=0; i<9; i++) {
			slicesArr[i] = driver.findElement(By.id("ext-sprite-" + sliceId));
			act.moveToElement(slicesArr[i]).build().perform();
			Thread.sleep(3000);
			slicesArrText[i] = slicesArr[i].getText();
			System.out.println(slicesArrText[i]);
			sliceId++;
		}
		return slicesArrText;
	}
	

	
	public boolean checkAlphaAscDesc(String order) {//Can be 'ASC' or 'DESC' //Works
		String[] arr = new String[10];
		arr[0] = subjectSpendingsRow1Col1.getText();
		arr[1] = subjectSpendingsRow2Col1.getText();
		arr[2] = subjectSpendingsRow3Col1.getText();
		arr[3] = subjectSpendingsRow4Col1.getText();
		arr[4] = subjectSpendingsRow5Col1.getText();
		arr[5] = subjectSpendingsRow6Col1.getText();
		arr[6] = subjectSpendingsRow7Col1.getText();
		arr[7] = subjectSpendingsRow8Col1.getText();
		arr[8] = subjectSpendingsRow9Col1.getText();
		arr[9] = subjectSpendingsRow10Col1.getText();
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		boolean alphaOrdered = true;
		
		if(order.equals("ASC")) {
			for(int i=1; i<arr.length; i++) {
				if(arr[i].compareTo(arr[i-1]) < 0) {
					alphaOrdered = false;
					break;
				}
			}
		}
		if(order.equals("DESC")) {
			for(int i=1; i<arr.length; i++) {
				if(arr[i].compareTo(arr[i-1]) > 0) {
					alphaOrdered = false;
					break;
				}
			}
		}
		
		if(alphaOrdered) {
			System.out.println("Sorted Correctly");
		}
		else {
			System.out.println("Sorted Incorrectly");
		}
		
		return alphaOrdered;
	}
	
	public void checkDoubleAscDesc(String order) {//Can be 'ASC' or 'DESC' //Works
		String[] arr = new String[10];
		
		arr[0] = subjectSpendingsRow1Col2.getText().substring(1);
		arr[1] = subjectSpendingsRow2Col2.getText().substring(1);
		arr[2] = subjectSpendingsRow3Col2.getText().substring(1);
		arr[3] = subjectSpendingsRow4Col2.getText().substring(1);
		arr[4] = subjectSpendingsRow5Col2.getText().substring(1);
		arr[5] = subjectSpendingsRow6Col2.getText().substring(1);
		arr[6] = subjectSpendingsRow7Col2.getText().substring(1);
		arr[7] = subjectSpendingsRow8Col2.getText().substring(1);
		arr[8] = subjectSpendingsRow9Col2.getText().substring(1);
		arr[9] = subjectSpendingsRow10Col2.getText().substring(1);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		boolean numericOrdered = true;
		
		if(order.equals("ASC")) {
			for(int i=1; i<arr.length; i++) {
				if(Double.parseDouble(arr[i]) > Double.parseDouble(arr[i - 1])) {
					numericOrdered = false;
					break;
				}
			}
		}
		if(order.equals("DESC")) {
			for(int i=1; i<arr.length; i++) {
				if(Double.parseDouble(arr[i]) < Double.parseDouble(arr[i - 1])) {
					numericOrdered = false;
					break;
				}
			}
		}
//		Assert.assertTrue(alphaOrdered);
		if(numericOrdered) {
			System.out.println("Sorted Correctly");
		}
		else {
			System.out.println("Sorted Incorrectly");
		}
		
	}
	
	public void sameLegendAndLabel() {
		Assert.assertEquals(transportationLabel.getText(), transportationToggle.getText());
		Assert.assertEquals(autoLabel.getText(), autoToggle.getText());
		Assert.assertEquals(checksWrittenLabel.getText(), checksWrittenToggle.getText());
		Assert.assertEquals(retailLabel.getText(), retailToggle.getText());
		Assert.assertEquals(householdLabel.getText(), householdToggle.getText());
		Assert.assertEquals(insuranceLabel.getText(), insuranceToggle.getText());
		Assert.assertEquals(officeSupplyLabel.getText(), officeSupplyToggle.getText());
		Assert.assertEquals(restaurantsLabel.getText(), restaurantsToggle.getText());
		Assert.assertEquals(telecomLabel.getText(), telecomToggle.getText());
	}
	
//	public void hoverPie() throws InterruptedException{
//		act.moveToElement(slice1).build().perform();
//		Thread.sleep(3000);
//		
//	}
	

	public void pieChartVisibility() {
//		transportationToggle.click();
//		Assert.assertFalse(transportationLabel.isDisplayed());
//		autoToggle.click();
//		Assert.assertFalse(autoLabel.isDisplayed());
//		checksWrittenToggle.click();
//		Assert.assertFalse(checksWrittenLabel.isDisplayed());
//		retailToggle.click();
//		Assert.assertFalse(retailLabel.isDisplayed());
//		householdToggle.click();
//		Assert.assertFalse(householdLabel.isDisplayed());
//		insuranceToggle.click();
//		Assert.assertFalse(insuranceLabel.isDisplayed());
//		officeSupplyToggle.click();
//		Assert.assertFalse(officeSupplyLabel.isDisplayed());
//		restaurantsToggle.click();
//		Assert.assertFalse(restaurantsLabel.isDisplayed());
//		telecomToggle.click();
//		Assert.assertFalse(telecomLabel.isDisplayed());
		
		//Returns PieChart Back to original state for further testing
		transportationToggle.click();autoToggle.click();checksWrittenToggle.click();
		retailToggle.click();householdToggle.click();insuranceToggle.click();
		officeSupplyToggle.click();restaurantsToggle.click();telecomToggle.click();
	}
	

}