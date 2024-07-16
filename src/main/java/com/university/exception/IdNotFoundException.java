package com.university.exception;

public class IdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getMessage() {
		return "Id Not Found";
	}
}
