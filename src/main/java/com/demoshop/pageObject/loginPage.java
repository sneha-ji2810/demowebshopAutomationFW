package com.demoshop.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.PageActions;
import utils.WaitUtils;

public class loginPage extends PageActions {
	
	public WebDriver driver;
	public loginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);//used initilize all the webelement with driver
	}
	
	@FindBy(xpath="//*[@class=\"ico-login\"]")
	private WebElement logHeader;
	@FindBy(xpath="//a[@class='ico-register']")
	private WebElement registerHeader;
	
	@FindBy(xpath="//*[@id=\"Email\"]")
	private WebElement Email;	
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='buttons']/*[@value='Log in']")
	private WebElement loginBtn;
	
	@FindBy(css=".account")
	private WebElement LogMail;
	
	@FindBy(id="newsletter-email")
	private WebElement newsLetterMail;
	
	@FindBy(id="newsletter-subscribe-button")
	private WebElement newsLetterSubscribeBtn;
	
	@FindBy(id="newsletter-result-block")
	private WebElement newsLetterSubscribeText;
	
	
	
	
	public void navigateToLoginSection() {
		
		//logHeader.click();
		ClickElements(logHeader);
	}
	
	public void navigateToRegisterPage() {
		//registerHeader.click();
		ClickElements(registerHeader);
	}
	
	public void login(String email,String passLog) {
		//Email.sendKeys(email);
		//password.sendKeys(passLog);
		//loginBtn.click();
		setTextBox(Email, email);
		setTextBox(password, passLog);
		ClickElements(loginBtn);
	}
	public String  getLoggedMail() {
		
		//return getLogMail.getText();
		return getElementText(LogMail);
	}
	
	public String verifyNewsLetterMail(String uniqueMail,String expectedTxt) throws InterruptedException {
		
		/*newsLetterMail.sendKeys(uniqueMail);
		newsLetterSubscribeBtn.click();
		Thread.sleep(2000);
		return newsLetterSubscribeText.getText();
		*/
		
		setTextBox(newsLetterMail, uniqueMail);
		ClickElements(newsLetterSubscribeBtn);
		//Thread.sleep(2000);
		WaitUtils.waitUntilTextShows(newsLetterSubscribeText, driver, expectedTxt);
		return getElementText(newsLetterSubscribeText);
		
		
	}
	
	
			
}
