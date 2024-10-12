package com.demoshop.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoshop.Context.Constants;
import com.demoshop.Context.DriverManager;

public class PageActions {
	private WebDriver driver;
	
	public PageActions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickElements(WebElement element) {
		//WaitUtils.waitUntilVisible(element, driver);
		WaitUtils.waitUntilClickable(element, driver);
		element.click();
	}
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200);");
	}

	public void clickElementWithJSExecutor(WebElement element) {
	
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void setTextBox(WebElement element,String val) {
		WaitUtils.waitUntilVisible(element, driver);
		WaitUtils.waitUntilClickable(element, driver);
		element.sendKeys(val);	
	}
	
	public String getElementText(WebElement element) {
		WaitUtils.waitUntilVisible(element, driver);
		return element.getText();
	}
	
	public void handleStaticDropDown(WebElement element,String visibleText) {
		Select se = new Select(element);
		se.selectByVisibleText(visibleText);
	}
	
	
	public List<String> getTextOfListElement(List<WebElement> listElement) {
		
		List<String> textList=new ArrayList<String>();
		for(WebElement ele:listElement) {
			
			textList.add(getElementText(ele));
		}
		return textList;
	}
	
	public static String getScreenShot(String testName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)DriverManager .getDriver();
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath=Constants.WORKINGDIRECTORY+ "\\screenshot\\"+testName+UniqueGenerator.getCurrentDateTime()+".png";
		File destFile = new File(screenshotPath);
		FileUtils.moveFile(srcFile, destFile);
		return screenshotPath;
	}
	
}
