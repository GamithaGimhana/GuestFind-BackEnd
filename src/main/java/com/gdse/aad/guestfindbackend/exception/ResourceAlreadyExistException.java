package com.gdse.aad.guestfindbackend.exception;

// custom exception
public class ResourceAlreadyExistException extends RuntimeException{
    public ResourceAlreadyExistException(String message) {
        super(message);
    }
}
