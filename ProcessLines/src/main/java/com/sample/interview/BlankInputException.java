package com.sample.interview;

public class BlankInputException extends Exception {
	
	public static final long serialVersionUID = 43L ;

	@Override
	public String getMessage() {
		
		return "No input was provided";
	}
	
	

}
