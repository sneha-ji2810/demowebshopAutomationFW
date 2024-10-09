package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pageObject.ItemsPage;

import utils.DataUtils;

public class E2EChekoutTest extends baseTest {
	
	@Test(groups="Smoke")
	public void verifyNewUserRegisterAndCheckoutProduct() throws InterruptedException {
		
		//RegisterNew User
		DataUtils.initData();
		logPage.navigateToRegisterPage();
		regrPage.registerWithNewUser(DataUtils.fName,DataUtils.lName,DataUtils.Uniqemail,DataUtils.password);
		String expectedEmail = logPage.getLoggedMail();
		Assert.assertEquals(DataUtils.Uniqemail, expectedEmail, "Registered email is differents");
		
		//Searching product
		regrPage.searchItems(prop.getProperty("searchVal"));;
		String actualSearchPdtVal=itemPage.getTextOfProductDisplayed();
		Assert.assertEquals(prop.getProperty("SearchResultVal"), actualSearchPdtVal,"Its not the prodcut that searched");
				
		//AddCart
		cartPage.moveTocartPageMain();
		String actualCartHead=cartPage.getTextOfCartHEading();
		Assert.assertEquals(actualCartHead, prop.getProperty("cartHeadingTxt"),"Not moved to cart Page");
		String actualCartConfirmMsg=cartPage.addCartSelection();
		Assert.assertEquals(actualCartConfirmMsg, prop.getProperty("shopcartMsg"),"Not added to shopping cart");
		
		//Second check on  product Added or not
		String qty="1";
		Assert.assertEquals(cartPage.verifyProductAddedOrNot(),"(1)","Not added");
		
		//MoveTo CartPage
		String cartPageHeadingTxt=cartPage.moveToCartPage();
		Assert.assertEquals(cartPageHeadingTxt,prop.getProperty("cartPageHeading"),"Not in shopping cart Page");
		
		//Checkout
		String actualChcekoutPageHeading=cartPage.checkOutProduct();
		Assert.assertEquals(actualChcekoutPageHeading, prop.getProperty("checkOutPageHeading"),"Not moved to checkout page");
		
		//BillingAddress
		String actualSuccessOrderTxt=cartPage.fillBillingAddress();
		Assert.assertEquals(actualSuccessOrderTxt,prop.getProperty("orderSuccessTxt"),"Order not Placed");
		
		
	}

}
