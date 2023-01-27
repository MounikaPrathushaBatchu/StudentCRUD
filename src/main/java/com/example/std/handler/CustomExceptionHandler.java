package com.example.std.handler;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.std.exception.CourseNotFoundException;
import com.example.std.exception.DepartmentNotFoundException;
import com.example.std.exception.StudentNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException snfe){
		
		return new ResponseEntity<String>(snfe.getMessage(),HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<String> handleDepartmentNotFound(DepartmentNotFoundException snfe){
		
		return new ResponseEntity<String>(snfe.getMessage(),HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<String> handleCourseNotFound(CourseNotFoundException snfe){
		
		return new ResponseEntity<String>(snfe.getMessage(),HttpStatus.NOT_FOUND);	
	}

}
