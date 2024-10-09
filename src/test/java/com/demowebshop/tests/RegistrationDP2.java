package com.demowebshop.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoshop.model.Person;
import com.github.javafaker.Faker;
import com.sun.tools.javac.util.List;

import utils.UniqueGenerator;

public class RegistrationDP2 extends baseTest {
	
	@Test(dataProvider="getData")
	public void verifyUserAbleToMultipleRegisterWithValidCredn(ArrayList<Person> personList) {
		
		personList.forEach(person->{
			logPage.navigateToRegisterPage();
			String uniqueEmail = person.email;
			regrPage.registerWithNewUser(person.fName, person.lName, 
				person.email, person.password);
			String expectedEmail = logPage.getLoggedMail();
			Assert.assertEquals(uniqueEmail, expectedEmail, "Registered email is differents");
			regrPage.logout();
			logPage.navigateToLoginSection();
		});
		
		
		
		
	}
	@DataProvider
	public Object[][] getData() {
		Faker faker= new Faker();
		String password= faker.internet().password();
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), password, password));
		personList.add(new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), password, password));
		return new Object[][] {
			{personList}
		};
		
	}
	
	

}
