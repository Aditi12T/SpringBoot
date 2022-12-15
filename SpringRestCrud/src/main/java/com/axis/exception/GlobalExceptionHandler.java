package com.axis.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<ErrorMessage> noIdFound(IDNotFoundException exception)
	{
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorMessage(exception.getMsg());
		errorMessage.setHttpStatus(HttpStatus.OK.toString());
		errorMessage.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND ); 
	}

}
