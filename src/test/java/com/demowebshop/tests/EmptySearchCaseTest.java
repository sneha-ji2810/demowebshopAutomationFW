package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptySearchCaseTest extends baseTest{
	
	@Test
	public void verifySearchWithEmptyKeyword() {
		
		searchPage.clickEmptySearch();
		String expectedTxtfromAlert=prop.getProperty("alertTxt");
		String actualTxtfromAlert=searchPage.getTextFromAlert();
		Assert.assertEquals(expectedTxtfromAlert, actualTxtfromAlert,"No proper msg");
		
	}

}
