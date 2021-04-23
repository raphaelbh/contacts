package com.zup.apipoc.commons.exceptions;

public class RequiredFieldException extends RuntimeException {

   public RequiredFieldException(final String message) {
        super(message);
    }

}
