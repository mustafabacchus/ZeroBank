package com.was.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.was.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	//Property class used to retrieve values from the config.properties file (configurable parameters of application)
	public static Properties prop;
	public static Actions act;
	
	//constructor
	public TestBase() {

		
		//instantiate instance of Properties class
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +
					"\\src\\main\\java\\com\\was\\qa\\config\\config.properties");
			//read property list from input stream (that contains config values??) 
			//(Property class contains list of properties i.e. value from .properties file)
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(){
		//initialize driver to the correct driver class
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumBrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();			
		}else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\SeleniumBrowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();					
		}
		
		//instantiate instance of Actions class
		act = new Actions(driver);
		
		//open configured url		
		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//??????????????????????????????????????????????????????????????????????
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//??????????????????????????????????????????????????????????????????????
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
	
}
