package com.demoshop.pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.PageActions;

public class SearchPage extends PageActions {

	public WebDriver driver;
	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="small-searchterms")
	WebElement searchBox;
	
	@FindBy(css=".button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@class=\"search-results\"]//h2[@class=\"product-title\"]/a")
	List<WebElement> searchResults;
	
	public void searchWithDiamondTxt(String val) {
		setTextBox(searchBox, val);
		ClickElements(searchBtn);
	}
	
	public List<String> getSearchedListProduct() {
		return getTextOfListElement(searchResults);
		
	}
	
	public void verifyDiamondTextWithSearchResult(String searchVal) {
		/*System.out.println("Total number of searchResults are:"+searchResults.size());
		int count=0;
		for(WebElement se:searchResults) {
			if(getElementText(se).contains(searchVal)) {
			
			System.out.println("Passed");
			count++;
			}
			else {
			System.out.println("Failed");
			}	
		}
		if(count==searchResults.size()) {
			System.out.println("All search results contains DIamond text");
		}
		else {
			System.out.println("TestCase failed");
		}
		
		*/
		
		
		List<String> productNameList=getSearchedListProduct();
		boolean istextMatched= true;
		for(String prodName:productNameList) {
			if(!prodName.contains(searchVal)) {
				istextMatched=false;
				break;
			}
			
		}
		Assert.assertTrue(istextMatched,"Product     Not matching");
		
		
	}
	
	public String getTextFromAlert() {
		
		Alert alert=driver.switchTo().alert();
		String txtVal= alert.getText();
		alert.accept();
		return txtVal;
	}
	
	public void clickEmptySearch() {
		ClickElements(searchBtn);
	}

}
