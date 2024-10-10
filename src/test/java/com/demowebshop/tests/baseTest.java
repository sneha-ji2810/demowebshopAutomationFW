package com.demowebshop.tests;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demoshop.pageObject.CartPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import com.demoshop.pageObject.ItemsPage;
import com.demoshop.pageObject.SearchPage;
import com.demoshop.pageObject.loginPage;
import com.demoshop.pageObject.registerPage;

import utils.TestProperties;

public class baseTest {
	
	WebDriver driver=null;
	public Properties prop;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"browserName"})
	public void initDriver(@Optional String browserName) throws IOException {
		prop=TestProperties.getProperties();
		System.out.println("In before method");
		if(browserName==null||browserName.isEmpty()) {
			browserName=prop.getProperty("browser");
			
		}
		
		getDriver(browserName);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("tndUrl"));
		initPages();
	}
	
	
	public WebDriver getDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();	
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Please choose a browser");
		}
		
		return driver;
	}
	
	public loginPage logPage;
	public registerPage regrPage;
	public SearchPage searchPage;
	public ItemsPage itemPage;
	public CartPage cartPage;
	
	public void initPages() {
		logPage = new loginPage(driver);
		regrPage = new registerPage(driver);
		searchPage=new SearchPage(driver);
		itemPage =new ItemsPage(driver);
		cartPage=new CartPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		
	driver.quit();
	}
}
