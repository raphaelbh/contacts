package com.zup.apipoc.commons.exceptions;

import lombok.Getter;

import java.util.List;

public class InvalidDomainException extends RuntimeException {

    @Getter private final List<String> fieldErrors;

    public InvalidDomainException(final String message, List<String> fieldErrors) {
        super(message);
        this.fieldErrors = fieldErrors;
    }

}