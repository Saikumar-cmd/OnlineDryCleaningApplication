package com.cg.drycleaning.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.drycleaning.exception.EmptyEntityListException;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.exception.EntityDeletionException;
import com.cg.drycleaning.exception.EntityNotFoundException;
import com.cg.drycleaning.exception.EntityUpdationException;

@RestControllerAdvice
public class OnlineDryCleaningControllerAdvice {

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<String> handleRuntimeException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EmptyEntityListException.class })
	public ResponseEntity<String> handleEmptyEntityListException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EntityCreationException.class })
	public ResponseEntity<String> handleEntityCreationException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EntityDeletionException.class })
	public ResponseEntity<String> handleEntityDeletionException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EntityUpdationException.class })
	public ResponseEntity<String> handleEntityUpdationException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<String> handleEntityNotFoundException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
