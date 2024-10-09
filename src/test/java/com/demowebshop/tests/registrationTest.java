package com.demowebshop.tests;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pageObject.loginPage;
import com.demoshop.pageObject.registerPage;
import com.github.javafaker.Faker;

import utils.UniqueGenerator;

public class registrationTest extends baseTest{
	
	/*
	 * We using page object model
	 * 1.Enhance code reusability
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void verifyUserAbleToRegisterWithValidCredn() {
		
		logPage.navigateToRegisterPage();
		
		/*Faker faker= new Faker();//For generating unique testData
		String firstName= faker.name().firstName();
		String lastName= faker.name().lastName();
		String uniqueEmail = faker.internet().emailAddress();
		String password= faker.internet().password();
		*/
		String uniqueEmail = UniqueGenerator.getUniqueEmail();
		regrPage.registerWithNewUser(UniqueGenerator.getUniqueFName(), UniqueGenerator.getUniqueLName(), 
			uniqueEmail, UniqueGenerator.getUniquePwd());
		String expectedEmail = logPage.getLoggedMail();
		Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");
		
		
	}

}
