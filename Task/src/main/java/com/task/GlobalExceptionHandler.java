package com.task;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler 
{
	
	  @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
	  handleAllExceptions(Exception ex, WebRequest request) { List<String> details
	  = new ArrayList<>(); details.add(ex.getLocalizedMessage()); ErrorResponse
	  error = new ErrorResponse("something went wrong", details); return new
	 ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR); }
	 
 
	
	  @ExceptionHandler(ConstraintViolationException.class) public final
	  ResponseEntity<Object> UniqueContraintsException(Exception ex, WebRequest
	  request) throws JsonProcessingException {
	 
	 List<String> details = new ArrayList<>();
	  details.add(ex.getLocalizedMessage()); ErrorResponse error = new
	  ErrorResponse("EmailId unique constarint exception", details); ObjectMapper
	  map = new ObjectMapper(); map.setVisibility(PropertyAccessor.FIELD,
	  Visibility.ANY); //map.writeValueAsString(error); 
	  return new ResponseEntity(map.writeValueAsString(error), HttpStatus.NOT_FOUND); }
	 
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}