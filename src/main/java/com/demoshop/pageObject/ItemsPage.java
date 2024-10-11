package com.demoshop.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class ItemsPage extends PageActions{

	public WebDriver driver;
	public ItemsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".list li:nth-child(4) a")
	WebElement apparelShoeOpt;
	
	@FindBy(css="#products-pagesize option:nth-child(2)")
	WebElement selectedSize;
	
	@FindBy(css=".product-item .product-title a")
	List<WebElement> productsListed;
	
	@FindBy(xpath="//*[@class=\"product-title\"]//a")
	WebElement productsListedTxt;
	
	
	public void selectApparelAndShoeOption() {
		
		ClickElements(apparelShoeOpt);
	}
	public int getSizeofDisplayedItems() {
		return Integer.parseInt(getElementText(selectedSize));
	}
	public int verifyProductsDisplayed() {
		
		return productsListed.size();
		
	}
	public String getTextOfProductDisplayed() {
		
		return getElementText(productsListedTxt);
	}

	
	
}
