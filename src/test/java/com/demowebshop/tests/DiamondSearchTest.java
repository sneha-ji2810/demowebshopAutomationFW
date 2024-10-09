package com.demowebshop.tests;

import org.testng.annotations.Test;

public class DiamondSearchTest  extends baseTest{
	
	@Test
	public void verifyDiamondTextInSearchResult() {
		
		searchPage.searchWithDiamondTxt(prop.getProperty("valueToSearch"));
		searchPage.verifyDiamondTextWithSearchResult(prop.getProperty("valueToSearch"));
		
	}
	

}
