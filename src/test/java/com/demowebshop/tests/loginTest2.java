package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class loginTest2 extends baseTest {

	@Test
	public void verifyUserAbleToLoginwithValidCredn() {
		

		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("obsqura24@");
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys("mypasss");
		driver.findElement(By.xpath("//*[@class='buttons']/*[@value='Log in']")).click();
	}
	
}
