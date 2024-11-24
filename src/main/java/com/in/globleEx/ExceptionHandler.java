package com.in.globleEx;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ExceptionHandler {

	 @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> exceptionfroPid(RuntimeException ex)
	{
		 return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
}
