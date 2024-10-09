package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pageObject.ItemsPage;

public class ApparelAndShoesProductTest extends baseTest{

	
	@Test(groups="Smoke")
	public void verifyApparelAndShoesDisplayItems() {
		
		itemPage.selectApparelAndShoeOption();
		int expectedSize=itemPage.getSizeofDisplayedItems();
		int actualSizeGet=itemPage.verifyProductsDisplayed();
		System.out.println("No of Items displayed"+actualSizeGet);
		System.out.println("No of Items to be displayed"+expectedSize);
		Assert.assertEquals(expectedSize, actualSizeGet,"Not displaying");
		
	}
	
}
