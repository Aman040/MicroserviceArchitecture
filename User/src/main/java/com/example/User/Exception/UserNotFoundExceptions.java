package com.example.User.Exception;

public class UserNotFoundExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;
	

	public UserNotFoundExceptions() {
	}



	public UserNotFoundExceptions(String message, Throwable cause, boolean enableSuppression,
	boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	
	}



	public UserNotFoundExceptions(String message, Throwable cause) {
	super(message, cause);
	}



	public UserNotFoundExceptions(String message) {
	super(message);
	}



	public UserNotFoundExceptions(Throwable cause) {
	super(cause);
	
	}

	
	
}
