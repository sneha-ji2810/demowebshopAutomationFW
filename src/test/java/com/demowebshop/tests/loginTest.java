package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pageObject.loginPage;

public class loginTest extends baseTest {
	
	@Test
	public void  verifyUserAbleToLoginwithValidCredn() {
		
		
		logPage.navigateToLoginSection();
	
		logPage.login(prop.getProperty("email"), prop.getProperty("pwd"));
		String expectedLogMail=logPage.getLoggedMail();
		
		System.out.println(expectedLogMail);
		Assert.assertEquals(prop.getProperty("email"),"SnehaBEnoy@mail.com" ,"Logged Mail is not matching");
		
	}

}
