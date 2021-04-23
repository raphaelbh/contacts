package com.zup.apipoc.contacts.domain.exceptions;

public class InvalidNameException extends RuntimeException {
   public InvalidNameException(final String message) {
        super(message);
    }
}
