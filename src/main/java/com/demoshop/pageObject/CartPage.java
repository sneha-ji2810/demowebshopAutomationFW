package com.demoshop.pageObject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demoshop.utils.PageActions;
import com.demoshop.utils.UniqueGenerator;
import com.demoshop.utils.WaitUtils;



public class CartPage extends PageActions{
	public WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//*[@class=\"product-title\"]//a")
	WebElement productsListedTxt;
	
	@FindBy(xpath="//*[@class=\"breadcrumb\"]//ul")
	WebElement cartHeading;
	
	@FindBy(css="input#add-to-cart-button-36")
	WebElement addToCartBtn;
	
	@FindBy(css="#bar-notification p")
	WebElement addCartMsg;
	
	@FindBy(css=".ico-cart .cart-qty")
	WebElement addCartQty;
	
	@FindBy(css=".ico-cart .cart-label")
	WebElement moveToCartPageBtn;
	
	@FindBy(css=".page.shopping-cart-page .page-title")
	WebElement cartPageHeading;
	
	@FindBy(css=".inputs #CountryId")
	WebElement selectCountry;
	
	@FindBy(css=".inputs select#BillingNewAddress_CountryId")
	WebElement selectCountryBilling;
	
	
	@FindBy(css=".terms-of-service #termsofservice")
	WebElement selectAgreement;
	 
	@FindBy(css=".checkout-buttons #checkout")
	WebElement checkOutBtn;
	
	@FindBy(css=".page.checkout-page h1")
	WebElement checkOutPageHeading;
	
	@FindBy(css="[name=\"BillingNewAddress.City\"]")
	WebElement cityInBilling;
	
	@FindBy(css="#BillingNewAddress_Address1")
	WebElement addressBilling;
	
	@FindBy(css="#BillingNewAddress_ZipPostalCode")
	WebElement zipCodeBilling;
	
	@FindBy(css="#BillingNewAddress_PhoneNumber")
	WebElement phoneNumberBilling;
	
	@FindBy(css="#billing-buttons-container [title=Continue]")
	WebElement ContinueBtnBilling;
	
	@FindBy(css="#checkout-step-shipping [title='Continue']")
	WebElement ContinueShippingAddr;
	
	@FindBy(css="#shipping-method-buttons-container input")
	WebElement ContinueShippingMethodBtn;
	

	@FindBy(css="#payment-method-buttons-container [value='Continue']")
	WebElement ContinuePaymentMethod;
	
	@FindBy(xpath="//*[@id=\"opc-shipping\"]//h2")
	WebElement shippingAdrHead;
	
	
	@FindBy(css=".section.payment-info td p")
	WebElement paymentMethodSelected;
	
	
	@FindBy(css=".button-1.payment-info-next-step-button")
	WebElement continuePayemntInfo;
	
	@FindBy(css=".billing-info .payment-method")
	WebElement payemntMethodTxt;
	
	@FindBy(css=".shipping-info .shipping-method")
	WebElement shippingMethodTxt;
	
	@FindBy(css="#confirm-order-buttons-container .button-1.confirm-order-next-step-button")
	WebElement confirmOrder;
	
	@FindBy(css=".section.order-completed strong")
	WebElement orderCompletionTxt;
	
	
	
	public void moveTocartPageMain() {
		
		ClickElements(productsListedTxt);
		
	}
	public String getTextOfCartHEading() {
		return getElementText(cartHeading);
	}
	
	public String addCartSelection() {
		ClickElements(addToCartBtn);
		WaitUtils.waitUntilVisible(addCartMsg, driver);
		return getElementText(addCartMsg);
		
	}
	public String verifyProductAddedOrNot() {
		return getElementText(addCartQty);
	}
	
	public String moveToCartPage() {
		ClickElements(moveToCartPageBtn);
		return getElementText(cartPageHeading);
	}
	
	public String checkOutProduct() {
		handleStaticDropDown(selectCountry,"India");
		ClickElements(selectAgreement);
		ClickElements(checkOutBtn);
		return getElementText(checkOutPageHeading);
	}
	

	public String fillBillingAddress() throws InterruptedException {
		handleStaticDropDown(selectCountryBilling,"India");
		setTextBox(cityInBilling, UniqueGenerator.getUniqCityName());
		setTextBox(addressBilling, UniqueGenerator.getUNiqueAddress());
		setTextBox(zipCodeBilling, UniqueGenerator.getUniqueZipCode());
		setTextBox(phoneNumberBilling, UniqueGenerator.getUniquePhoneNumber());
		ClickElements(ContinueBtnBilling);
		//Thread.sleep(4000);
	
		//SHipping Address
		ClickElements(ContinueShippingAddr);
		//clickElementWithJSExecutor(ContinueShippingAddr);
		
		//SHippingMethod
		ClickElements(ContinueShippingMethodBtn);
		
		//PaymentMethod
		ClickElements(ContinuePaymentMethod);
		
		//Payment INfo
		String actualPayemntMethod=getElementText(paymentMethodSelected);
		Assert.assertEquals(actualPayemntMethod, "You will pay by COD","Wrong payemnt selected");
		scroll();
		ClickElements(continuePayemntInfo);
		
		//Confirm order
		String ActualTxtpayemntMethod=getElementText(payemntMethodTxt);
		String ActualTxtShippingMethod=getElementText(shippingMethodTxt);
		if(ActualTxtpayemntMethod.equalsIgnoreCase("Cash On Delivery (COD)") && 
				ActualTxtShippingMethod.equalsIgnoreCase("Ground")) {
			ClickElements(confirmOrder);
		}
		else
		{
			System.out.println("select correct payment and Shipping method");
		}
		
		return getElementText(orderCompletionTxt);
		
	}
	
	
	

}
