package com.demowebshop.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ExcelReader;
import utils.UniqueGenerator;

public class ExcelReadRegistrationTest extends baseTest {
	
	@Test
	public void verifyUserAbleToRegisterWithValidCredn() throws IOException {
		
		logPage.navigateToRegisterPage();
		
		String firstName= ExcelReader.getCellValue(1, 0);
		String lastName= ExcelReader.getCellValue(1, 1);
		String uniqueEmail = ExcelReader.getCellValue(1, 2)+UniqueGenerator.getCurrentDateTime()+"@gmail.com";
		String password= ExcelReader.getCellValue(1, 3);
		regrPage.registerWithNewUser(firstName,lastName,uniqueEmail,password);
		String expectedEmail = logPage.getLoggedMail();
		Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");
		
		
		
	}


}
