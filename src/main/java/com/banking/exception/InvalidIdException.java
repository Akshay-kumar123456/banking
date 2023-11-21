package com.banking.exception;

public class InvalidIdException  extends Exception{

	
	private static final long serialVersionUID = 1025239765088196195L;

	private String message;

	public InvalidIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	
	
}
