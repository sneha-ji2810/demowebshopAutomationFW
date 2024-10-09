package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
}
