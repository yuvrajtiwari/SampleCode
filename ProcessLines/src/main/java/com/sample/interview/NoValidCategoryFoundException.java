package com.sample.interview;

public class NoValidCategoryFoundException extends Exception {
	
	public static final long serialVersionUID = 42L ;

	@Override
	public String getMessage() {
		
		return "No Valid Category found";
	}
	
}
