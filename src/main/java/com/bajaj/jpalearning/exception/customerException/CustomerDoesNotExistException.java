package com.bajaj.jpalearning.exception.customerException;

public class CustomerDoesNotExistException extends RuntimeException{
    public CustomerDoesNotExistException(String message)
    {
        super(message);
    }
}