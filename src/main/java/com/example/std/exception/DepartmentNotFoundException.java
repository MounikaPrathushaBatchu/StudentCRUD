package com.example.std.exception;

public class DepartmentNotFoundException extends RuntimeException{
	
	public DepartmentNotFoundException() {
		super();
	}
	public DepartmentNotFoundException(String msg) {
		super(msg);
	}
}
