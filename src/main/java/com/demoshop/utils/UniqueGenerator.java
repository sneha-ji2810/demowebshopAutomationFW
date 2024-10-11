package com.demoshop.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class UniqueGenerator {
	public static Faker faker=new Faker();
	public static String getUniqueEmail() {
	 
		return  faker.internet().emailAddress();
	}
	public static String getUniqueFName(){
		 
		return  faker.name().firstName();
	}
	public static String getUniqueLName(){
		 
		return  faker.name().lastName();
	}
	public static String getUniquePwd(){
		 
		return  faker.internet().password();
		
	}
	public static String getUniqCityName() {
		return faker.address().cityName();
	}
	public static String getUNiqueAddress() {
		return faker.address().fullAddress();
		
		}

	public static String getUniquePhoneNumber() {
	return faker.phoneNumber().phoneNumber();	
	}
	
	public static String getUniqueZipCode() {
		return faker.address().zipCode();

	}
	
	public static String getCurrentDateTime() {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());  
		  return date.replaceAll("[^0-9]", "");
	    
	}
	
	
}
