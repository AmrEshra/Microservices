package com.project.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	// Add an exception handler for NotFoundException	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NotFoundException exc, WebRequest request) {
		
		// create ErrorResponse
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exc.getMessage(), request.getDescription(false));		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
			
	// Add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(RuntimeException exc, WebRequest request) {
		
		// create ErrorResponse
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), exc.getMessage(), request.getDescription(false));		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(BusinessException exc, WebRequest request) {
		
		// create ErrorResponse
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase(), exc.getMessage(), request.getDescription(false));	
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		// create ErrorResponse
		ErrorResponse error = new ErrorResponse(status.value(), status.name(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}





