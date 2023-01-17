package com.example.std.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.std.exception.StudentNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException snfe){
		
		return new ResponseEntity<String>(snfe.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}

}
