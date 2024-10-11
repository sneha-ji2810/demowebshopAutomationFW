package com.demowebshop.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.demoshop.utils.UniqueGenerator;

public class SubScriptionTest extends baseTest {

	@Test(groups="Smoke")
	public void userAbleToSubscribeWithValidMail() throws InterruptedException {
		
		
		String newsLetterActualTxt=logPage.verifyNewsLetterMail(UniqueGenerator.getUniqueEmail(),prop.getProperty("NewsLetterMsg"));
		System.out.println(newsLetterActualTxt);
		Assert.assertEquals(newsLetterActualTxt, prop.getProperty("NewsLetterMsg"),"User not get subscribed");
		
	}
	
	
}
