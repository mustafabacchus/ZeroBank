package com.was.qa.pages;

import org.testng.Assert;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.was.qa.base.TestBase;

public class MyMoneyMapPage extends TestBase{
	
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
		
		reverseCategoryOrder();
		
		String[] category = {"Auto", "Charity", "Checks Written", "Household", "Insurance",
							"Office Supply", "Restaurants", "Retail", "Telecom", "Transportation"}; 
		List <WebElement> list = new ArrayList<WebElement>();
		for(int i=0; i<category.length; i++) {
			List <WebElement> toggle = driver.findElements(By.xpath("//*[contains(text(), '" + category[i] + "')]"));
			
			String temp = toggle.get(1).getText();
			toggle.get(2).click();
			
			if(toggle.get(1).isDisplayed() == false) 
				System.out.println(temp + " slice successfully dissapeared.");
			else
				System.out.println(toggle.get(1).getText() + " slice failed to meet expected result");
			
			Thread.sleep(100);
		}
		System.out.println("\n\n");
		for(int i=0; i<category.length; i++) {
			List <WebElement> toggle = driver.findElements(By.xpath("//*[contains(text(), '" + category[i] + "')]"));
			
			toggle.get(2).click();
			
			if(toggle.get(1).isDisplayed()) 
				System.out.println(toggle.get(1).getText() + " slice successfully reapeared.");
			else
				System.out.println(toggle.get(1).getText() + " slice failed to meet expected result");
			
			Thread.sleep(100);
		}
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
		
		//Checks if out flow elements add up to out flow total
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