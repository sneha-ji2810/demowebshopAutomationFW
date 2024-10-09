package com.demoshop.model;

public class Person {

	public String fName, lName, email, password, confirmPassword;
	public Person(String fName, String lName, String email, String password, String confirmPassword) {
		
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	
}
