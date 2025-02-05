package rs.services.mssc_brewery.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e){
	List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

	e.getConstraintViolations().forEach(constraintViolations -> {
	    errors.add(constraintViolations.getPropertyPath() + " : " + constraintViolations.getMessage());
	});

	return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<String>> handlerBindingException(BindException ex){
	
	List<String> errors = new ArrayList<>();
	ex.getAllErrors().forEach( e -> {
	    errors.add(e.getCode() + " : " + e.getObjectName());
	});
	return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
