package com.zup.apipoc.commons.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class InvalidDomainException extends RuntimeException {

    @Getter @Setter List<String> fieldErrors = new ArrayList<>();

    public InvalidDomainException(final String message, List<String> fieldErrors) {
        super(message);
        this.fieldErrors = fieldErrors;
    }

}