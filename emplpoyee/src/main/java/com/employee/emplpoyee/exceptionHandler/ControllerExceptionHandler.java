package com.employee.emplpoyee.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.employee.emplpoyee.exceptions.RecordNotFoundException;


@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
	
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleException(final RecordNotFoundException e){

        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}