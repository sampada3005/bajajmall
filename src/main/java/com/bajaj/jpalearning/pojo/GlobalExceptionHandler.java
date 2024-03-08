package com.bajaj.jpalearning.pojo;

import com.bajaj.jpalearning.exception.addressException.AddressNotFoundException;
import com.bajaj.jpalearning.exception.customerException.CustomerAlreadyExistException;
import com.bajaj.jpalearning.exception.customerException.CustomerDoesNotExistException;
import com.bajaj.jpalearning.exception.customerException.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleCustomerNotFound(EntityNotFoundException customerNotFoundException){
       Map<String, Object> response = new HashMap<>();
       response.put("message", customerNotFoundException.getMessage());

       return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CustomerAlreadyExistException.class})
    public ResponseEntity<Object> handleCustomerAlreadyExistException(CustomerAlreadyExistException customerAlreadyExistException){
        Map<String, Object> response = new HashMap<>();
        response.put("message", customerAlreadyExistException.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({CustomerDoesNotExistException.class})
    public ResponseEntity<Object> handleCustomerNotExistException(CustomerDoesNotExistException customerDoesNotExistException){
        Map<String, Object> response = new HashMap<>();
        response.put("message", customerDoesNotExistException.getMessage());

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
