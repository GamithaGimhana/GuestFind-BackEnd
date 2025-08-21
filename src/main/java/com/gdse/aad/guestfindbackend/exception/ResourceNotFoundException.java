package com.gdse.aad.guestfindbackend.exception;

// custom exception
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
