package com.bajaj.jpalearning.exception.customerException;

public class CustomerAlreadyExistException extends RuntimeException{
    public CustomerAlreadyExistException(String message)
    {
        super(message);
    }
}
