package com.javafsd.departmentservice.Exception;

public class DepartmentNotFoundExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;



	public DepartmentNotFoundExceptions() {
	}



	public DepartmentNotFoundExceptions(String message, Throwable cause, boolean enableSuppression,
	boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	
	}



	public DepartmentNotFoundExceptions(String message, Throwable cause) {
	super(message, cause);
	}



	public DepartmentNotFoundExceptions(String message) {
	super(message);
	}



	public DepartmentNotFoundExceptions(Throwable cause) {
	super(cause);
	
	}
	

}
