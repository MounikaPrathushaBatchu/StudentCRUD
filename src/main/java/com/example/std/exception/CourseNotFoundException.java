package com.example.std.exception;

public class CourseNotFoundException extends RuntimeException{
	public CourseNotFoundException() {
		super();
	}
	public CourseNotFoundException(String msg) {
		super(msg);
	}

}
