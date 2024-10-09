package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoshop.pageObject.loginPage;
import com.demoshop.pageObject.registerPage;
import com.github.javafaker.Faker;

public class RegistartionDP extends baseTest {
	@Test(dataProvider="getData")
	public void verifyUserIsAbleToMultipleRegisterUsingCorrectCreds(String firstName, String lastName, String uniqueEmail, String password) {
		
		logPage.navigateToRegisterPage();
		regrPage.registerWithNewUser(firstName, lastName, uniqueEmail, password);
	    String expectedEmail = logPage.getLoggedMail();
		Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");

		
	}
	
	
	@DataProvider
	public String[][] getData() {
		Faker faker= new Faker();
		String creds[][]= new String[1][4];
		//Ist row
		creds[0][0]=faker.name().firstName();
		creds[0][1]=faker.name().lastName();
		creds[0][2]= faker.internet().emailAddress();
		creds[0][3]=faker.internet().password();
	
		
		return creds;
		
	}

}
