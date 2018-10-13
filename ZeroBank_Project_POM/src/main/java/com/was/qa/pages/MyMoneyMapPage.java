package com.was.qa.pages;

import org.testng.Assert;


import java.text.NumberFormat;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
//	@FindBy(xpath="//tspan[contains(text(),'Transportation')][1]")
//	WebElement transportationLabel;
//	@FindBy(xpath = "")
//	WebElement transportationToggle;
	
	public MyMoneyMapPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	//actions
	
	public String[] getPieSlicesText() {
		String[] slicesArrText = new String[10];
		int sliceId = 1271;
		for(int i=0; i<10; i++) {
			slicesArrText[i] = driver.findElement(By.id("ext-sprite-" + sliceId)).getText();
			sliceId++;
		}
		return slicesArrText;
	}
	
	public void pieHover() throws InterruptedException {
		int sliceId = 1271;
		for(int i=0; i<10; i++) {
			WebElement slice = driver.findElement(By.id("ext-sprite-" + sliceId));
			act.moveToElement(slice).build().perform();
			Thread.sleep(100);
			System.out.println(slice);
			sliceId++;
		}
	}
	
	public String[] findCategoryNames() {
		String[] textArr = new String[10];
		int id = 2;
		for(int i=0; i<10; i++) {
			textArr[i] = driver.findElement(By.xpath("//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[" + id + "]/td[1]/div")).getText();
			id++;
		}
		return textArr;
		
	}
	
	public String[] findMoneyValues() {
		String[] textArr = new String[10];
		int id = 2;
		for(int i=0; i<10; i++) {
			textArr[i] = driver.findElement(By.xpath("//*[@id=\"gridview-1021-bd-Spendings\"]/td/table/tbody/tr[" + id + "]/td[2]/div")).getText().substring(1);
			id++;
		}
		return textArr;
	}
	
	
	public boolean checkAlphaAscDesc(String[] arr, String order) {//Can be 'ASC' or 'DESC' //Works
		
		//comment out later
		for(int i=0; i<arr.length; i++) 
			System.out.println(arr[i]);

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
		return alphaOrdered;
	}

	public boolean checkDoubleAscDesc(String[] arr, String order) {//Can be 'ASC' or 'DESC' //Works
		
		//Comment out later
		for(int i=0; i<arr.length; i++) 
			System.out.println(arr[i]);
		
		boolean numericOrdered = true;
		
		if(order.equals("ASC")) {
			for(int i=1; i<arr.length; i++) {
				if(Double.parseDouble(arr[i]) < Double.parseDouble(arr[i - 1])) {
					numericOrdered = false;
					break;
				}
			}
		}
		if(order.equals("DESC")) {
			for(int i=1; i<arr.length; i++) {
				if(Double.parseDouble(arr[i]) > Double.parseDouble(arr[i - 1])) {
					numericOrdered = false;
					break;
				}
			}
		}
		return numericOrdered;	
	}
	
	public boolean sameColAndLabel(String[] categoryColArr, String[] pieLableArr) {
		return Arrays.equals(categoryColArr, pieLableArr);
	}
	

	public void pieChartVisibility() throws InterruptedException {
		
		//Returns PieChart Back to original state for further testing
//		WebElement mapObject = driver.findElement(By.xpath("//*[name()='svg']/*[name()='rect']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click", mapObject);
//		mapObject.click();
//		System.out.println("Clicked the thing.");
	}
	
	public void reverseCategoryOrder() {
		WebElement reverseCategory = driver.findElement(By.id("gridcolumn-1018-titleEl"));
		act.click(reverseCategory).build().perform();
	}
	
	public void reverseMoneyOrder() {
		WebElement reverseMoney = driver.findElement(By.id("gridcolumn-1019-titleEl"));
		act.click(reverseMoney).build().perform();
	}
	
	public boolean addsUp() {
		String[] outflow = findMoneyValues();
		boolean flag = true;
		
		//Checks if outflow elements add up to outflow total
		double outflowSum = 0;
		for(int i=0; i<outflow.length; i++) 
			outflowSum = outflowSum + Double.parseDouble(outflow[i]);
		
		double outflowTotal= Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"gridview-1021\"]/table/tbody/tr[4]/td[2]/div/b")).getText().substring(1).replaceAll(",", ""));
		
		flag = (outflowTotal == outflowSum); if(flag == false) return flag;
		
		//Checks if inflow elements add up to inflow total
		double inflowSum = 0;
		int id = 2;
		for(int i=0; i<3; i++) {
			inflowSum = inflowSum + Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"gridview-1015-bd-Deposits\"]/td/table/tbody/tr[" + id + "]/td[2]/div")).getText().substring(1).replaceAll(",", ""));
			id++;
		}
		
		double inflowTotal= Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"gridview-1015\"]/table/tbody/tr[4]/td[2]/div/b")).getText().substring(1).replaceAll(",", ""));
		
		flag = (inflowTotal == inflowSum); if(flag == false) return flag;
		
		//Checks if these are the same as their previous counterparts
		double summaryTotalInflow = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"gridview-1031\"]/table/tbody/tr[2]/td[2]/div")).getText().substring(1).replaceAll(",", ""));
		double summaryTotalOutflow = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"gridview-1031\"]/table/tbody/tr[3]/td[2]/div")).getText().substring(1).replaceAll(",", ""));
		
		flag = (summaryTotalInflow == inflowTotal); if(flag == false) return flag;
		flag = (summaryTotalOutflow == outflowTotal); if(flag == false) return flag;
		
		//Checks if what's left is correct according to everything prior
		double whatsLeft = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"gridview-1031\"]/table/tbody/tr[4]/td[2]/div/b")).getText().substring(1).replaceAll(",", ""));
		
		flag = ((summaryTotalInflow - summaryTotalOutflow) == whatsLeft);
		
		
		return flag;
	}
	

}