package com.demoshop.pageObject;
import java.sql.Driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class registerPage extends PageActions {
	
	private WebDriver driver;
	
	
	public registerPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="gender-male")
	private WebElement gender;
	
	@FindBy(id="FirstName")
	private WebElement firstName;
	
	@FindBy(id="LastName")
	private WebElement lastName;
	
	@FindBy(id="Email")
	private WebElement Email;
	
	@FindBy(id="Password")
	private WebElement passwrod;
	
	@FindBy(id="ConfirmPassword")
	private WebElement conPassword;
	
	@FindBy(id="register-button")
	private WebElement registerBtn;
	
	@FindBy(css = ".ico-logout")
	private WebElement logoutBtn;
	
	@FindBy(id="small-searchterms")
	private WebElement searchBox;
	
	@FindBy(css=".button-1.search-box-button")
	private WebElement searchBtn;
	

	public void registerWithNewUser(String fName,String lName,String email,String pwd) {
		
		/*gender.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		Email.sendKeys(email);
		passwrod.sendKeys(pwd);
		conPassword.sendKeys(pwd);
		registerBtn.click();
		*/
		ClickElements(gender);
		setTextBox(firstName, fName);
		setTextBox(lastName, lName);
		setTextBox(Email, email);
		setTextBox(passwrod, pwd);
		setTextBox(conPassword, pwd);
		ClickElements(registerBtn);
		
	}
	
	public void logout() {
		ClickElements(logoutBtn);;
	}
	
	public void searchItems(String prodName) {
		setTextBox(searchBox, prodName);
		ClickElements(searchBtn);
		
	}

	
}
