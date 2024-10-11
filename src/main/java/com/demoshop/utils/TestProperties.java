package com.demoshop.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	
	public static Properties getProperties() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\jijin\\eclipse-workspace\\DemoWebShopFramework\\src\\main\\resources\\config\\config.properties");
		prop.load(fis);
		return prop;
	}
}
