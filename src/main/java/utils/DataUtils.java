package utils;

import com.github.javafaker.Faker;

public class DataUtils {
	
	
	public static String fName,lName,Uniqemail,password;
	
	public static void initData() {
		
		Faker faker=new Faker();
		fName=faker.name().firstName();
		lName=faker.name().lastName();
		Uniqemail=faker.internet().emailAddress();
		password=faker.internet().password();
		
	}

}
